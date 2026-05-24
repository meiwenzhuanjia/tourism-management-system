package com.trip.dao.entity;

import lombok.Data;
import java.time.LocalDateTime;

//景区分类表
@Data
public class ScenicCategory {
    private Integer id;
    private String categoryName;
    private String description;
    private String iconUrl;
    private Integer sortOrder;
    private Integer status;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Integer isDeleted;
}
