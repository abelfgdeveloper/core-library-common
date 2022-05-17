package es.abelfgdeveloper.core.exception.domain;

import lombok.Getter;

public class CoreGenericException extends RuntimeException {

  private static final long serialVersionUID = 8385044265067681825L;

  @Getter private final DomainError error;

  protected CoreGenericException(DomainError error, Throwable cause) {
    super(error.toString(), cause);
    this.error = error;
  }

  protected CoreGenericException(DomainError error) {
    super(error.toString());
    this.error = error;
  }
}
