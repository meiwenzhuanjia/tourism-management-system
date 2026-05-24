package com.trip.dao.entity;

import lombok.Data;
import java.time.LocalDateTime;

//用户点赞表
@Data
public class UserLike {
    private Long id;
    private Long userId;
    private Long targetId;
    private Integer targetType;
    private LocalDateTime createTime;
}
