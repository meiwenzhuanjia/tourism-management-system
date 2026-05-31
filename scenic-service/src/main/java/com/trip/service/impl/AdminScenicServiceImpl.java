package com.trip.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.trip.common.query.AdminScenicQuery;
import com.trip.common.result.PageResult;
import com.trip.dao.entity.ScenicSpot;
import com.trip.dao.mapper.ScenicSpotMapper;
import com.trip.service.AdminScenicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AdminScenicServiceImpl implements AdminScenicService {

    @Autowired
    private ScenicSpotMapper scenicSpotMapper;

    @Override
    public PageResult<ScenicSpot> getAdminScenicList(AdminScenicQuery query) {
        PageHelper.startPage(query.getPage(), query.getSize());
        List<ScenicSpot> list = scenicSpotMapper.getAdminScenicList(query);
        Page<ScenicSpot> page = (Page<ScenicSpot>)list;
        return new PageResult<>(page.getTotal(), page.getResult(), query.getPage(), query.getSize());
    }

    @Override
    public ScenicSpot getAdminScenicDetail(Long id) {
        ScenicSpot scenicSpot = scenicSpotMapper.getAdminScenicDetail(id);
        return scenicSpot;
    }

    @Override
    public void addScenic(ScenicSpot scenicSpot) {
        scenicSpotMapper.addScenic(scenicSpot);
    }

    @Override
    public void updateScenic(Long id, ScenicSpot scenicSpot) {
        scenicSpotMapper.updateScenic(id, scenicSpot);
    }

    @Override
    public void updateScenicStatus(Long id, Integer status) {
        scenicSpotMapper.updateScenicStatus(id, status);
    }

    @Override
    public void deleteScenic(Long id) {
        scenicSpotMapper.deleteScenic(id);
    }

}
