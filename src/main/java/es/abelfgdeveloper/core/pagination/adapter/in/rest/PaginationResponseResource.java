package es.abelfgdeveloper.core.pagination.adapter.in.rest;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PaginationResponseResource {

  private int totalPages;
  private long totalElements;
  private int numberOfElements;
  private boolean hasNext;
  private boolean hasPrevious;
}
