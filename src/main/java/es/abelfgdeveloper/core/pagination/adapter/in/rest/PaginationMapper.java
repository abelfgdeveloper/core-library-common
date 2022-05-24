package es.abelfgdeveloper.core.pagination.adapter.in.rest;

import es.abelfgdeveloper.core.pagination.domain.PaginationOut;
import org.springframework.stereotype.Component;

@Component
public class PaginationMapper {

  public PaginationResponseResource map(PaginationOut pagination) {
    return PaginationResponseResource.builder()
        .totalPages(pagination.getGetTotalPages())
        .totalElements(pagination.getGetTotalElements())
        .numberOfElements(pagination.getGetNumberOfElements())
        .hasNext(pagination.isHasNext())
        .hasPrevious(pagination.isHasPrevious())
        .build();
  }
}
