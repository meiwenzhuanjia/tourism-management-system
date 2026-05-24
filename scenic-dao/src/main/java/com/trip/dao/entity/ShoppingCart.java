package com.trip.dao.entity;

import lombok.Data;
import java.time.LocalDateTime;

//购物车表
@Data
public class ShoppingCart {
    private Long id;
    private Long userId;
    private Long scenicId;
    private Integer quantity;
    private Integer selected;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
