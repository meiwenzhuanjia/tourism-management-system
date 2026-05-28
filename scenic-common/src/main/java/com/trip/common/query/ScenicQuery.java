package com.trip.common.query;

import lombok.Data;

@Data
public class ScenicQuery extends PageQuery{
    private Integer categoryId;
    private String keyword;
}
