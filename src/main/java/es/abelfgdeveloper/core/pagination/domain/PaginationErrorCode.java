package es.abelfgdeveloper.core.pagination.domain;

import es.abelfgdeveloper.core.exception.domain.DomainError;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PaginationErrorCode {

  private static final String CONTEXT = "PAGINATION";

  public static final DomainError MINIMUM_PAGE = build("PAGE_BELOW_MINIMUM");
  public static final DomainError MINIMUM_SIZE = build("SIZE_BELOW_MINIMUM");
  public static final DomainError MAXIMUM_SIZE = build("SIZE_ABOVE_MAXIMUM");

  private static DomainError build(String code) {
    return new DomainError(CONTEXT, code);
  }
}
