package com.trip.dao.entity;

import lombok.Data;
import java.time.LocalDateTime;

//旅游攻略表
@Data
public class TravelStrategy {
    private Long id;
    private String title;
    private String description;
    private String content;
    private String coverImage;
    private Long adminId;
    private String category;
    private Long viewCount;
    private Long likeCount;
    private Integer status;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Integer isDeleted;
}
