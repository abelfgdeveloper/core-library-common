package es.abelfgdeveloper.core.exception.adapter.in.rest;

import java.time.Instant;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ErrorResponseResource {

  private Instant timestamp;
  private int status;
  private String error;
  private String code;
  private String traceId;
  private String detail;
  private List<String> stackTrace;
  private ErrorResponseResource cause;
}
