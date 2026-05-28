package com.trip.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.trip.common.query.ScenicQuery;
import com.trip.common.result.PageResult;
import com.trip.dao.entity.ScenicSpot;
import com.trip.dao.mapper.ScenicSpotMapper;
import com.trip.service.ScenicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ScenicServiceImpl implements ScenicService {

    @Autowired
    private ScenicSpotMapper scenicSpotMapper;

    @Override
    public PageResult<ScenicSpot> getScenicList(ScenicQuery query) {
        PageHelper.startPage(query.getPage(), query.getSize());
        List<ScenicSpot> list = scenicSpotMapper.getScenicList(query);
        Page<ScenicSpot> page = (Page<ScenicSpot>)list;
        return new PageResult<>(page.getTotal(), page.getResult(), query.getPage(), query.getSize());
    }

    @Override
    public ScenicSpot getScenicDetail(Long id) {
        ScenicSpot scenicSpot = scenicSpotMapper.getScenicDetail(id);
        return scenicSpot;
    }
}
