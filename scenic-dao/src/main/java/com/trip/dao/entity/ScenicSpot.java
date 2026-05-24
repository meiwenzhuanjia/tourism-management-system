package com.trip.dao.entity;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

//景区信息表（核心业务表）
@Data
public class ScenicSpot {
    private Long id;
    private Integer categoryId;
    private String scenicName;
    private String description;
    private String coverImage;
    private String location;
    private BigDecimal longitude;
    private BigDecimal latitude;
    private String openTime;
    private BigDecimal price;
    private BigDecimal score;
    private Integer stock;
    private Integer isRealName;
    private Integer status;
    private Long viewCount;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Integer isDeleted;
}
