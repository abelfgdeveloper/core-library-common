package es.abelfgdeveloper.core.exception.domain;

public class NotFoundException extends BusinessException {

  private static final long serialVersionUID = 1003448607188179044L;

  public NotFoundException(DomainError error, Throwable cause) {
    super(error, cause);
  }

  public NotFoundException(DomainError error) {
    super(error);
  }
}
