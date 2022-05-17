package es.abelfgdeveloper.core.exception.domain;

public class BusinessException extends CoreGenericException {

  private static final long serialVersionUID = -6902936420648460262L;

  protected BusinessException(DomainError error, Throwable cause) {
    super(error, cause);
  }

  protected BusinessException(DomainError error) {
    super(error);
  }
}
