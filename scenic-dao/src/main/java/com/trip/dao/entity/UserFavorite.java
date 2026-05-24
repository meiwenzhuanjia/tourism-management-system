package com.trip.dao.entity;

import lombok.Data;
import java.time.LocalDateTime;

//用户收藏表
@Data
public class UserFavorite {
    private Long id;
    private Long userId;
    private Long targetId;
    private Integer targetType;
    private LocalDateTime createTime;
}
