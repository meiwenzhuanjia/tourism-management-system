package com.trip.service.impl;

import com.trip.common.dto.AddCategoryRequest;
import com.trip.common.dto.UpdateCategoryRequest;
import com.trip.common.query.PageQuery;
import com.trip.common.result.PageResult;
import com.trip.dao.entity.ScenicCategory;
import com.trip.dao.mapper.ScenicCategoryMapper;
import com.trip.service.ScenicCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class ScenicCategoryServiceImpl implements ScenicCategoryService {

    @Autowired
    private ScenicCategoryMapper scenicCategoryMapper;

    @Override
    public List<ScenicCategory> getCategoryList(Integer status) {
        return scenicCategoryMapper.selectCategoryList(status);
    }

    @Override
    public PageResult<ScenicCategory> getAdminCategoryPageList(Integer status, PageQuery pageQuery) {
        try {
            int page = pageQuery.getPage();
            int size = pageQuery.getSize();

            if (page < 1) {
                page = 1;
            }
            if (size < 1 || size > 100) {
                size = 10;
            }

            int offset = (page - 1) * size;

            log.info("分页查询参数: status={}, offset={}, limit={}", status, offset, size);

            List<ScenicCategory> list = scenicCategoryMapper.selectCategoryPageList(status, offset, size);
            int total = scenicCategoryMapper.countCategories(status);

            log.info("查询结果: total={}, listSize={}", total, list != null ? list.size() : 0);

            PageResult<ScenicCategory> pageResult = new PageResult<>();
            pageResult.setList(list);
            pageResult.setTotal((long) total);
            pageResult.setPage(page);
            pageResult.setSize(size);

            return pageResult;
        } catch (Exception e) {
            log.error("获取分类列表失败", e);
            throw e;
        }
    }

    @Override
    public ScenicCategory getCategoryDetail(Integer id) {
        log.info("获取分类详情，id={}", id);

        ScenicCategory category = scenicCategoryMapper.selectById(id);

        if (category == null) {
            log.warn("分类不存在，id={}", id);
            throw new RuntimeException("分类不存在");
        }

        return category;
    }

    @Override
    public Map<String, Integer> addCategory(AddCategoryRequest request) {
        log.info("添加分类，请求参数: {}", request);

        ScenicCategory category = new ScenicCategory();
        BeanUtils.copyProperties(request, category);

        int result = scenicCategoryMapper.insertCategory(category);

        if (result > 0) {
            log.info("添加分类成功，id={}", category.getId());
            Map<String, Integer> data = new HashMap<>();
            data.put("id", category.getId());
            return data;
        } else {
            log.error("添加分类失败");
            throw new RuntimeException("添加失败");
        }
    }

    @Override
    public void updateCategory(Integer id, UpdateCategoryRequest request) {
        log.info("更新分类，id={}, 请求参数: {}", id, request);

        ScenicCategory existCategory = scenicCategoryMapper.selectById(id);
        if (existCategory == null) {
            log.warn("分类不存在，id={}", id);
            throw new RuntimeException("分类不存在");
        }

        ScenicCategory category = new ScenicCategory();
        category.setId(id);
        BeanUtils.copyProperties(request, category);

        int result = scenicCategoryMapper.updateCategory(category);

        if (result > 0) {
            log.info("更新分类成功，id={}", id);
        } else {
            log.error("更新分类失败，id={}", id);
            throw new RuntimeException("更新失败");
        }
    }

    @Override
    public void deleteCategory(Integer id) {
        log.info("删除分类，id={}", id);

        ScenicCategory existCategory = scenicCategoryMapper.selectById(id);
        if (existCategory == null) {
            log.warn("分类不存在，id={}", id);
            throw new RuntimeException("分类不存在");
        }

        int result = scenicCategoryMapper.deleteCategory(id);

        if (result > 0) {
            log.info("删除分类成功，id={}", id);
        } else {
            log.error("删除分类失败，id={}", id);
            throw new RuntimeException("删除失败");
        }
    }
}
