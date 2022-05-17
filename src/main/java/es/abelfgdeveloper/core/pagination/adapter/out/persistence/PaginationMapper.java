package es.abelfgdeveloper.core.pagination.adapter.out.persistence;

import es.abelfgdeveloper.core.pagination.domain.PaginationIn;
import es.abelfgdeveloper.core.pagination.domain.PaginationOut;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

@Component
public class PaginationMapper {

  public PageRequest map(PaginationIn pagination) {
    return PageRequest.of(pagination.getPage() - 1, pagination.getSize());
  }

  public PaginationOut map(Page<?> page) {
    return PaginationOut.builder()
        .getTotalPages(page.getTotalPages())
        .getTotalElements(page.getTotalElements())
        .getNumberOfElements(page.getNumberOfElements())
        .hasNext(page.hasNext())
        .hasPrevious(page.hasPrevious())
        .build();
  }
}
