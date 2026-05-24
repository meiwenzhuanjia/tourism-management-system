package com.trip.dao.entity;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

//订单主表
@Data
public class OrderInfo {
    private Long id;
    private String orderNo;
    private Long userId;
    private BigDecimal totalAmount;
    private LocalDate visitDate;
    private Integer payType;
    private Integer payStatus;
    private Integer orderStatus;
    private String contactName;
    private String contactPhone;
    private String remark;
    private LocalDateTime payTime;
    private LocalDateTime expireTime;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Integer isDeleted;
}
