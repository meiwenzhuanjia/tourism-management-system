package com.trip.dao.mapper;

import com.trip.common.query.ScenicQuery;
import com.trip.dao.entity.ScenicSpot;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ScenicSpotMapper {

    List<ScenicSpot> getScenicList(ScenicQuery query);
}
