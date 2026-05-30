package com.trip.api.controller;

import com.trip.common.query.AdminScenicQuery;
import com.trip.common.result.PageResult;
import com.trip.common.result.Result;
import com.trip.dao.entity.ScenicSpot;
import com.trip.service.AdminScenicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/admin/scenic")
public class AdminScenicController {

    @Autowired
    private AdminScenicService adminScenicService;

    //获取景区列表
    @GetMapping("/list")
    public Result getAdminScenicList(AdminScenicQuery query) {
        log.info("分页查询,参数{},{},{},{}", query);
        PageResult<ScenicSpot> pageResult = adminScenicService.getAdminScenicList(query);
        return Result.success(pageResult);
    }

    //获取景点详情
    @GetMapping("/detail/{id}")
    public Result getAdminScenicDetail(@PathVariable Long id) {
        log.info("查询详情,参数{}", id);
        ScenicSpot scenicSpot = adminScenicService.getAdminScenicDetail(id);
        return Result.success(scenicSpot);
    }

    //添加景区
    @PostMapping("/add")
    public Result addScenic(@RequestBody ScenicSpot scenicSpot) {
        log.info("添加,参数{}", scenicSpot);
        adminScenicService.addScenic(scenicSpot);
        return Result.success();
    }

    //更新景区
    @PutMapping("/update/{id}")
    public Result updateScenic(@PathVariable Long id, @RequestBody ScenicSpot scenicSpot) {
        log.info("更新,参数{},{}", id, scenicSpot);
        scenicSpot.setId(id);
        adminScenicService.updateScenic(id,scenicSpot);
        return Result.success();
    }

    //更新景区状态
    @PutMapping("/update/status/{id}")
    public Result updateScenicStatus(@PathVariable Long id, @RequestBody Map<String, Integer> params) {
        log.info("更新状态,参数id={}, status={}", id, params.get("status"));
        adminScenicService.updateScenicStatus(id, params.get("status"));
        return Result.success();
    }

    //删除景区
    @DeleteMapping("/delete/{id}")
    public Result deleteScenic(@PathVariable Long id) {
        log.info("删除,参数{}", id);
        adminScenicService.deleteScenic(id);
        return Result.success();
    }
}
