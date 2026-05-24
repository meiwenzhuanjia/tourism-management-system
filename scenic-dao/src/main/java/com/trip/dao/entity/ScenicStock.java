package com.trip.dao.entity;

import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

//景区每日库存表
@Data
public class ScenicStock {
    private Long id;
    private Long scenicId;
    private LocalDate visitDate;
    private Integer totalStock;
    private Integer surplusStock;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Integer isDeleted;
}
