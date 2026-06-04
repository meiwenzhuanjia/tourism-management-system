package com.trip.api.controller;

import com.trip.common.dto.AddCategoryRequest;
import com.trip.common.dto.UpdateCategoryRequest;
import com.trip.common.query.PageQuery;
import com.trip.common.result.PageResult;
import com.trip.common.result.Result;
import com.trip.dao.entity.ScenicCategory;
import com.trip.service.ScenicCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/admin/category")
public class AdminScenicCategoryController {

    @Autowired
    private ScenicCategoryService scenicCategoryService;

    @GetMapping("/list")
    public Result getAdminCategoryList(
            @RequestParam(required = false) Integer status,
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size) {

        log.info("获取分类列表,status={}, page={}, size={}", status, page, size);

        PageQuery pageQuery = new PageQuery();
        pageQuery.setPage(page);
        pageQuery.setSize(size);

        PageResult<ScenicCategory> pageResult = scenicCategoryService.getAdminCategoryPageList(status, pageQuery);
        return Result.success(pageResult);
    }

    @GetMapping("/detail/{id}")
    public Result getAdminCategoryDetail(@PathVariable Integer id) {
        log.info("获取分类详情,id={}", id);
        ScenicCategory category = scenicCategoryService.getCategoryDetail(id);
        return Result.success(category);
    }

    @PostMapping("/add")
    public Result addCategory(@RequestBody AddCategoryRequest request) {
        log.info("添加分类,参数{}", request);

        if (request.getCategoryName() == null || request.getCategoryName().trim().isEmpty()) {
            return Result.error(400, "分类名称不能为空");
        }

        if (request.getCategoryName().length() < 2 || request.getCategoryName().length() > 50) {
            return Result.error(400, "分类名称长度必须在 2-50 之间");
        }

        if (request.getDescription() != null && request.getDescription().length() > 200) {
            return Result.error(400, "描述长度不能超过 200");
        }

        if (request.getIconUrl() != null && request.getIconUrl().length() > 500) {
            return Result.error(400, "图标 URL 长度不能超过 500");
        }

        Map<String, Integer> data = scenicCategoryService.addCategory(request);
        return Result.success(data);
    }

    @PutMapping("/update/{id}")
    public Result updateCategory(@PathVariable Integer id, @RequestBody UpdateCategoryRequest request) {
        log.info("更新分类,id={},参数{}", id, request);

        if (request.getCategoryName() == null || request.getCategoryName().trim().isEmpty()) {
            return Result.error(400, "分类名称不能为空");
        }

        if (request.getCategoryName().length() < 2 || request.getCategoryName().length() > 50) {
            return Result.error(400, "分类名称长度必须在 2-50 之间");
        }

        if (request.getDescription() != null && request.getDescription().length() > 200) {
            return Result.error(400, "描述长度不能超过 200");
        }

        if (request.getIconUrl() != null && request.getIconUrl().length() > 500) {
            return Result.error(400, "图标 URL 长度不能超过 500");
        }

        if (request.getSortOrder() == null) {
            return Result.error(400, "排序值不能为空");
        }

        if (request.getStatus() == null) {
            return Result.error(400, "状态不能为空");
        }

        scenicCategoryService.updateCategory(id, request);
        return Result.success();
    }

    @DeleteMapping("/delete/{id}")
    public Result deleteCategory(@PathVariable Integer id) {
        log.info("删除分类,id={}", id);
        scenicCategoryService.deleteCategory(id);
        return Result.success();
    }
}
