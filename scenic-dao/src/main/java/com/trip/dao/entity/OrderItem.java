package com.trip.dao.entity;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

//订单子项表
@Data
public class OrderItem {
    private Long id;
    private Long orderId;
    private Long scenicId;
    private String scenicNameSnapshot;
    private BigDecimal unitPriceSnapshot;
    private Integer quantity;
    private BigDecimal totalPrice;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
