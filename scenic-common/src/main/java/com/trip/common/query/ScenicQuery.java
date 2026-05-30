package com.trip.common.query;

import lombok.Data;

@Data
public class ScenicQuery extends PageQuery{
    private Integer categoryId;
    private String keyword;
    private String sortType; // 排序类型: hot, new, score, price_asc, price_desc
}
