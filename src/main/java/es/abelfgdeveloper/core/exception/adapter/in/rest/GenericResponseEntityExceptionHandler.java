package es.abelfgdeveloper.core.exception.adapter.in.rest;

import es.abelfgdeveloper.core.exception.adapter.in.rest.ErrorResponseResource.ErrorResponseResourceBuilder;
import es.abelfgdeveloper.core.exception.domain.CoreGenericException;
import java.time.Instant;
import java.util.Arrays;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RequiredArgsConstructor
@ControllerAdvice
public class GenericResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

  private static final String GENERIC_ERROR_CODE = "GENERIC_ERROR";

  private final Environment environment;
  private final HttpStatusMapper httpStatusMapper;
  private final StackTraceMapper stackTraceMapper;

  @ExceptionHandler
  public ResponseEntity<Object> handleAllExceptions(Exception exception) {
    HttpStatus httpStatus = getHttpStatus(exception);
    loggerTheException(exception, httpStatus);
    ErrorResponseResourceBuilder bodyBuilder =
        buildBaseErrorResponseResource(exception, httpStatus);

    if (isNotProduction()) {
      addNotProductionData(bodyBuilder, exception);
    }
    return new ResponseEntity<>(bodyBuilder.build(), httpStatus);
  }

  private ErrorResponseResourceBuilder buildBaseErrorResponseResource(
      Exception exception, HttpStatus httpStatus) {
    return ErrorResponseResource.builder()
        .timestamp(Instant.now())
        .status(httpStatus.value())
        .error(httpStatus.getReasonPhrase())
        .code(getCode(exception))
        .traceId(null);
  }

  private HttpStatus getHttpStatus(Exception exception) {
    if (exception instanceof CoreGenericException) {
      return httpStatusMapper.map((CoreGenericException) exception);
    }
    return HttpStatus.INTERNAL_SERVER_ERROR;
  }

  private String getCode(Exception exception) {
    if (exception instanceof CoreGenericException) {
      CoreGenericException genericException = (CoreGenericException) exception;
      return genericException.getError().toString();
    } else {
      return GENERIC_ERROR_CODE;
    }
  }

  private boolean isNotProduction() {
    return !Arrays.asList(environment.getActiveProfiles()).contains("pro");
  }

  private void addNotProductionData(ErrorResponseResourceBuilder bodyBuilder, Exception exception) {
    bodyBuilder.detail(exception.getClass().getName());
    bodyBuilder.stackTrace(stackTraceMapper.map(exception.getStackTrace()));
    bodyBuilder.cause(buildErrorResponseResource(exception.getCause()));
  }

  private ErrorResponseResource buildErrorResponseResource(Throwable throwable) {
    if (throwable == null) {
      return null;
    } else {
      return ErrorResponseResource.builder()
          .code(throwable.getMessage())
          .detail(throwable.getClass().getName())
          .stackTrace(stackTraceMapper.map(throwable.getStackTrace()))
          .cause(buildErrorResponseResource(throwable.getCause()))
          .build();
    }
  }

  private void loggerTheException(Exception exception, HttpStatus httpStatus) {
    if (httpStatus.is5xxServerError()) {
      log.error("Exception: {}", exception);
    } else {
      log.warn("Exception: {}", exception);
    }
  }
}
