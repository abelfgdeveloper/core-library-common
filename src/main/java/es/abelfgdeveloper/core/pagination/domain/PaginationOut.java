package es.abelfgdeveloper.core.pagination.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PaginationOut {

  private int getTotalPages;
  private long getTotalElements;
  private int getNumberOfElements;
  private boolean hasNext;
  private boolean hasPrevious;
}
