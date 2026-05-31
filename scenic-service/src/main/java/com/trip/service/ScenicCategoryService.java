package com.trip.service;

import com.trip.common.dto.AddCategoryRequest;
import com.trip.common.dto.UpdateCategoryRequest;
import com.trip.common.query.PageQuery;
import com.trip.common.result.PageResult;
import com.trip.common.result.Result;
import com.trip.dao.entity.ScenicCategory;

import java.util.List;
import java.util.Map;

public interface ScenicCategoryService {
    Result<List<ScenicCategory>> getCategoryList(Integer status);

    Result<PageResult> getAdminCategoryPageList(Integer status, PageQuery pageQuery);

    Result<ScenicCategory> getCategoryDetail(Integer id);

    Result<Map<String, Integer>> addCategory(AddCategoryRequest request);

    Result<Void> updateCategory(Integer id, UpdateCategoryRequest request);

    Result<Void> deleteCategory(Integer id);
}
