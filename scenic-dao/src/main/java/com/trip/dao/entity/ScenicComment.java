package com.trip.dao.entity;

import lombok.Data;
import java.time.LocalDateTime;

//景区评论表
@Data
public class ScenicComment {
    private Long id;
    private Long userId;
    private Long scenicId;
    private String content;
    private String images;
    private Integer score;
    private Integer status;
    private Long parentId;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Integer isDeleted;
}
