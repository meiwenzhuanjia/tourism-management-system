package com.trip.service;

import com.trip.common.query.ScenicQuery;
import com.trip.common.result.PageResult;
import com.trip.dao.entity.ScenicSpot;

public interface ScenicService {
    PageResult<ScenicSpot> getScenicList(ScenicQuery query);
}
