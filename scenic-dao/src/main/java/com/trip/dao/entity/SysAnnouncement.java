package com.trip.dao.entity;

import lombok.Data;
import java.time.LocalDateTime;

//系统公告表
@Data
public class SysAnnouncement {
    private Long id;
    private String title;
    private String content;
    private Integer type;
    private Integer status;
    private String publisher;
    private Long viewCount;
    private LocalDateTime publishTime;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Integer isDeleted;
}
