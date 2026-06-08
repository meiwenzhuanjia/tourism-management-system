package com.trip.dao.mapper;

import com.trip.common.query.AdminUserQuery;
import com.trip.dao.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    List<SysUser> getAdminScenicList(AdminUserQuery query);

    void updateUserStatus(Long id, Integer status);
}
