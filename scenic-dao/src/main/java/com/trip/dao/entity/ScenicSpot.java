package com.trip.dao.entity;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

//景区信息表（核心业务表）
@Data
public class ScenicSpot {
    private Long id;//主键ID
    private Integer categoryId;//分类ID
    private String scenicName;//景区名称
    private String description;//描述
    private String coverImage;//封面图片
    private String location;//位置
    private BigDecimal longitude;//经度
    private BigDecimal latitude;//纬度
    private String openTime;//开放时间
    private BigDecimal price;// 价格
    private BigDecimal score;//评分
    private Integer stock;//库存
    private Integer isRealName;//是否实名认证
    private Integer status;//状态
    private Long viewCount;//浏览量
    private LocalDateTime createTime;//创建时间
    private LocalDateTime updateTime;//更新时间
    private Integer isDeleted;//是否删除
}
