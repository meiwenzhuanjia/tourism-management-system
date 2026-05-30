package com.trip.common.query;

import lombok.Data;

@Data
public class AdminScenicQuery extends PageQuery{
    private Integer categoryId;
    private String keyword;
    private Integer status; // 状态：0-待审核，1-已上架，2-已下架
}
