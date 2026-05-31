package com.trip.api.controller;

import com.trip.common.query.ScenicQuery;
import com.trip.common.result.PageResult;
import com.trip.common.result.Result;
import com.trip.dao.entity.ScenicSpot;
import com.trip.service.ScenicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/scenic")
public class ScenicController {

    @Autowired
    private ScenicService scenicService;

    //获取景点列表
    @GetMapping("/list")
    public Result getScenicList(ScenicQuery query) {
        log.info("分页查询,参数{},{},{},{}", query);
        PageResult<ScenicSpot> pageResult = scenicService.getScenicList(query);
        return Result.success(pageResult, "添加成功");
    }

    //获取景点详情
    @GetMapping("/detail/{id}")
    public Result getScenicDetail(@PathVariable Long id) {
        log.info("查询详情,参数{}", id);
        ScenicSpot scenicSpot = scenicService.getScenicDetail(id);
        return Result.success(scenicSpot, "添加成功");
    }
}