package com.trip.dao.entity;

import lombok.Data;
import java.time.LocalDateTime;

//管理员角色权限表
@Data
public class SysRole {
    private Integer id;
    private String roleName;
    private String permissions;
    private String description;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Integer isDeleted;
}
