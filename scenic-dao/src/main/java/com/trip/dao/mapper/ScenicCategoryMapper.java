package com.trip.dao.mapper;

import com.trip.dao.entity.ScenicCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface ScenicCategoryMapper {

  List<ScenicCategory> selectCategoryList(@Param("status") Integer status);

  List<ScenicCategory> selectCategoryPageList(@Param("status") Integer status,
                                              @Param("offset") Integer offset,
                                              @Param("limit") Integer limit);

  int countCategories(@Param("status") Integer status);

  ScenicCategory selectById(@Param("id") Integer id);

  int insertCategory(ScenicCategory category);

  int updateCategory(ScenicCategory category);

  int deleteCategory(Integer id);
}

