package com.trip.service;

import com.trip.common.query.AdminScenicQuery;
import com.trip.common.result.PageResult;
import com.trip.dao.entity.ScenicSpot;

public interface AdminScenicService {


    PageResult<ScenicSpot> getAdminScenicList(AdminScenicQuery query);

    ScenicSpot getAdminScenicDetail(Long id);

    void addScenic(ScenicSpot scenicSpot);

    void updateScenic(Long id, ScenicSpot scenicSpot);

    void updateScenicStatus(Long id, Integer status);

    void deleteScenic(Long id);


}
