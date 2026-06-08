package com.trip.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.trip.common.query.AdminUserQuery;
import com.trip.common.result.PageResult;
import com.trip.dao.entity.ScenicSpot;
import com.trip.dao.entity.SysUser;
import com.trip.dao.mapper.UserMapper;
import com.trip.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    private UserMapper UserMapper;

    @Override
    public PageResult<SysUser> getAdminUserList(AdminUserQuery query) {
        PageHelper.startPage(query.getPage(), query.getSize());
        List<SysUser> list = UserMapper.getAdminScenicList(query);
        Page<SysUser> page = (Page<SysUser>)list;
        return new PageResult<>(page.getTotal(), page.getResult(), query.getPage(), query.getSize());
    }

    @Override
    public void updateUserStatus(Long id, Integer status) {
        UserMapper.updateUserStatus(id, status);
    }
}
