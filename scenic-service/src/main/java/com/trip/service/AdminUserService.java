package com.trip.service;

import com.trip.common.query.AdminUserQuery;
import com.trip.common.result.PageResult;
import com.trip.dao.entity.SysUser;

public interface AdminUserService {

    PageResult<SysUser> getAdminUserList(AdminUserQuery query);

    void updateUserStatus(Long id, Integer status);
}
