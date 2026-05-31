package com.trip.dao.mapper;

import com.trip.common.query.AdminScenicQuery;
import com.trip.common.query.ScenicQuery;
import com.trip.dao.entity.ScenicSpot;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ScenicSpotMapper {

    List<ScenicSpot> getScenicList(ScenicQuery query);

    ScenicSpot getScenicDetail(Long id);
    
    List<ScenicSpot> getAdminScenicList(AdminScenicQuery query);

    ScenicSpot getAdminScenicDetail(Long id);

    void addScenic(ScenicSpot scenicSpot);

    void deleteScenic(Long id);

    void updateScenic(@Param("id") Long id, @Param("scenicSpot") ScenicSpot scenicSpot);

    void updateScenicStatus(@Param("id") Long id, @Param("status") Integer status);
}
