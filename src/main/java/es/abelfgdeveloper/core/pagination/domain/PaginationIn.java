package es.abelfgdeveloper.core.pagination.domain;

import es.abelfgdeveloper.core.exception.domain.ValidationException;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class PaginationIn {

  public static final int MINIMUM_PAGE = 1;
  public static final int MINIMUM_SIZE = 1;

  public static final int DEFAULT_PAGE = 1;
  public static final int DEFAULT_SIZE = 10;
  public static final int MAXIMUM_SIZE = 100;

  private int page;
  private int size;

  public PaginationIn(Integer page, Integer size) {
    if (page == null) {
      this.page = DEFAULT_PAGE;
    } else {
      this.page = page;
    }
    if (size == null) {
      this.size = DEFAULT_SIZE;
    } else {
      this.size = size;
    }
    validatePage(this.page);
    validateSize(this.size);
  }

  private void validatePage(int page) {
    if (page < MINIMUM_PAGE) {
      throw new ValidationException(PaginationErrorCode.MINIMUM_PAGE);
    }
  }

  private void validateSize(int size) {
    if (size < MINIMUM_SIZE) {
      throw new ValidationException(PaginationErrorCode.MINIMUM_SIZE);
    }
    if (size > MAXIMUM_SIZE) {
      throw new ValidationException(PaginationErrorCode.MAXIMUM_SIZE);
    }
  }
}
