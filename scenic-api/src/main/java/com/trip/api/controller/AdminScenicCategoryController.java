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
    public Result<PageResult> list(
            @RequestParam(required = false) Integer status,
            @RequestParam Integer page,
            @RequestParam Integer size) {

        log.info("获取分类列表,status={}, page={}, size={}", status, page, size);

        PageQuery pageQuery = new PageQuery();
        pageQuery.setPage(page);
        pageQuery.setSize(size);

        return scenicCategoryService.getAdminCategoryPageList(status, pageQuery);
    }

    @GetMapping("/detail/{id}")
    public Result<ScenicCategory> detail(@PathVariable Integer id) {
        log.info("【管理员】获取分类详情，id={}", id);
        return scenicCategoryService.getCategoryDetail(id);
    }

    @PostMapping("/add")
    public Result<Map<String, Integer>> add(@RequestBody AddCategoryRequest request) {
        log.info("【管理员】添加分类，请求参数: {}", request);

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

        return scenicCategoryService.addCategory(request);
    }

    @PutMapping("/update/{id}")
    public Result<Void> update(@PathVariable Integer id, @RequestBody UpdateCategoryRequest request) {
        log.info("【管理员】更新分类，id={}, 请求参数: {}", id, request);

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

        return scenicCategoryService.updateCategory(id, request);
    }

    @DeleteMapping("/delete/{id}")
    public Result<Void> delete(@PathVariable Integer id) {
        log.info("【管理员】删除分类，id={}", id);
        return scenicCategoryService.deleteCategory(id);
    }
}
