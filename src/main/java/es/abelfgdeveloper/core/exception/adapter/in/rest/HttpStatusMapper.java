package es.abelfgdeveloper.core.exception.adapter.in.rest;

import es.abelfgdeveloper.core.exception.domain.CoreGenericException;
import es.abelfgdeveloper.core.exception.domain.NotFoundException;
import es.abelfgdeveloper.core.exception.domain.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class HttpStatusMapper {

  public HttpStatus map(CoreGenericException exception) {
    HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

    if (exception instanceof NotFoundException) {
      httpStatus = HttpStatus.NOT_FOUND;
    } else if (exception instanceof ValidationException) {
      httpStatus = HttpStatus.BAD_REQUEST;
    }

    return httpStatus;
  }
}
