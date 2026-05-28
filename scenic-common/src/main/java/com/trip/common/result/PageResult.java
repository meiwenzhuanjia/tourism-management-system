package com.trip.common.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PageResult<T> {
    private Long total;
    private List<T> list;
    private Integer page;
    private Integer size;
}
