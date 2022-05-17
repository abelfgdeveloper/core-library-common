package es.abelfgdeveloper.core.exception.domain;

import java.io.Serializable;
import java.util.StringJoiner;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class DomainError implements Serializable {

  private static final long serialVersionUID = -6398919421376794774L;

  private static final String SEPARATOR = "-";

  private final String context;
  private final String code;

  @Override
  public String toString() {
    return new StringJoiner(SEPARATOR).add(context).add(code).toString();
  }
}
