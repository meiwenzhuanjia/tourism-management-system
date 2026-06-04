package com.trip.service;

import com.trip.common.dto.AddCategoryRequest;
import com.trip.common.dto.UpdateCategoryRequest;
import com.trip.common.query.PageQuery;
import com.trip.common.result.PageResult;
import com.trip.dao.entity.ScenicCategory;

import java.util.List;
import java.util.Map;

public interface ScenicCategoryService {

    List<ScenicCategory> getCategoryList(Integer status);

    PageResult<ScenicCategory> getAdminCategoryPageList(Integer status, PageQuery pageQuery);

    ScenicCategory getCategoryDetail(Integer id);

    Map<String, Integer> addCategory(AddCategoryRequest request);

    void updateCategory(Integer id, UpdateCategoryRequest request);

    void deleteCategory(Integer id);
}
