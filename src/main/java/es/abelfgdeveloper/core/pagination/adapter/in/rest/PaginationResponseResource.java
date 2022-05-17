package es.abelfgdeveloper.core.pagination.adapter.in.rest;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PaginationResponseResource {

  private int getTotalPages;
  private long getTotalElements;
  private int getNumberOfElements;
  private boolean hasNext;
  private boolean hasPrevious;
}
