package es.abelfgdeveloper.core.exception.domain;

public class ValidationException extends BusinessException {

  private static final long serialVersionUID = -5431703764823092448L;

  public ValidationException(DomainError error, Throwable cause) {
    super(error, cause);
  }

  public ValidationException(DomainError error) {
    super(error);
  }
}
