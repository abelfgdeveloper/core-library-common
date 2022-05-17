package es.abelfgdeveloper.core.exception.domain;

public class TechnicalException extends CoreGenericException {

  private static final long serialVersionUID = -2769846228342222225L;

  protected TechnicalException(DomainError error, Throwable cause) {
    super(error, cause);
  }

  protected TechnicalException(DomainError error) {
    super(error);
  }
}
