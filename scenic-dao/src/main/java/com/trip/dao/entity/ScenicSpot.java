package com.trip.dao.entity;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ScenicSpot {
    private Long id;// 主键
    private Integer categoryId;// 分类id
    private String categoryName;// 分类名称
    private String scenicName;// 景点名称
    private String description;// 景点描述
    private String coverImage;// 景点封面图片
    private String location;// 景点位置
    private BigDecimal longitude;// 经度
    private BigDecimal latitude;// 纬度
    private String openTime;// 开放时间
    private BigDecimal price;// 价格
    private BigDecimal score;// 评分
    private Integer stock;// 库存
    private Integer isRealName;// 是否实名认证
    private Integer status;// 状态
    private Long viewCount;// 浏览次数
    private LocalDateTime createTime;// 创建时间
    private LocalDateTime updateTime;// 更新时间
    private Integer isDeleted;// 是否删除
}
