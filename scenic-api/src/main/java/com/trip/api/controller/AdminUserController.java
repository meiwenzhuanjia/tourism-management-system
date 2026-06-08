package com.trip.api.controller;

import com.trip.common.query.AdminUserQuery;
import com.trip.common.result.PageResult;
import com.trip.common.result.Result;
import com.trip.dao.entity.ScenicSpot;
import com.trip.dao.entity.SysUser;
import com.trip.service.AdminScenicService;
import com.trip.service.AdminUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

//后台用户管理
@Slf4j
@RestController
@RequestMapping("/admin/user")
public class AdminUserController {

    @Autowired
    private AdminUserService adminUserService;

    //获取用户列表
    @GetMapping("/list")
    public Result getUserList(AdminUserQuery adminUserQuery){
        log.info("分页查询,参数{},{},{},{}", adminUserQuery);
        PageResult<SysUser> pageResult = adminUserService.getAdminUserList(adminUserQuery);
        return Result.success(pageResult);
    }

    //更新用户状态
    @PutMapping("/update/status")
    public Result updateUserStatus(Long id, Integer status) {
        log.info("更新用户状态,参数id={}, status={}", id, status);
        adminUserService.updateUserStatus(id, status);
        return Result.success();
    }

}
