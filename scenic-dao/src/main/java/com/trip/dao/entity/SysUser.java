package com.trip.dao.entity;

import lombok.Data;
import java.time.LocalDateTime;

//用户基础信息表
@Data
public class SysUser {
    private Long id;
    private String username;
    private String password;
    private String nickname;
    private String avatarUrl;
    private String phone;
    private String email;
    private Integer userType;
    private Integer status;
    private LocalDateTime lastLoginTime;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Integer isDeleted;
}