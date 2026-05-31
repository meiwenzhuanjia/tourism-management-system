package com.trip.api.controller;
import com.trip.common.result.Result;
import com.trip.dao.entity.ScenicCategory;

import com.trip.service.ScenicCategoryService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/scenic/category")
public class ScenicCategoryController {
    @Autowired
    private ScenicCategoryService scenicCategoryService;

    @GetMapping("/list")
    public Result<List<ScenicCategory>> list(@RequestParam(required = false) Integer status) {
        log.info("查询景点分类数据");
        Result<List<ScenicCategory>> result = scenicCategoryService.getCategoryList(status);
        return result;
    }
}