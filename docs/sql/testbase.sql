USE tourism_db;

-- ====================== 1. 用户表测试数据 ======================
INSERT INTO sys_user (username, password, nickname, phone, email, user_type, status)
VALUES
    ('admin', 'e10adc3949ba59abbe56e057f20f883e', '超级管理员', '13800001111', 'admin@qq.com', 2, 1),
    ('user01', 'e10adc3949ba59abbe56e057f20f883e', '普通游客小A', '13800002222', 'user01@qq.com', 1, 1),
    ('user02', 'e10adc3949ba59abbe56e057f20f883e', '普通游客小B', '13800003333', 'user02@qq.com', 1, 1);

-- ====================== 2. 角色表测试数据 ======================
INSERT INTO sys_role (role_name, permissions, description)
VALUES
    ('超级管理员', '["*"]', '拥有系统全部操作权限'),
    ('运营人员', '["scenic:list","scenic:add","scenic:edit","order:query"]', '负责景区上架下架、订单查询'),
    ('审核员', '["scenic:audit","comment:audit","strategy:audit"]', '审核景区信息、用户评论、旅游攻略');

-- ====================== 3. 景区分类测试数据 ======================
INSERT INTO scenic_category (category_name, description, sort_order, status)
VALUES
    ('自然景观', '山川湖泊、森林草原等自然风光类景区', 1, 1),
    ('人文古迹', '历史建筑、古镇遗迹、文化场馆类景区', 2, 1),
    ('主题乐园', '游乐设施、亲子游玩、休闲娱乐场所', 3, 1),
    ('城市休闲', '城市公园、网红打卡、滨江步道景点', 4, 1);

-- ====================== 4. 景区信息测试数据 ======================
INSERT INTO scenic_spot (category_id, scenic_name, description, cover_image, location, longitude, latitude, open_time, price, score, stock, is_real_name, status, view_count)
VALUES
    (1, '黄山风景区', '天下第一奇山，奇松怪石云海温泉闻名于世', '/img/scenic/huangshan.jpg', '安徽省黄山市黄山区', 118.178921, 30.143256, '06:00-18:00', 190.00, 4.8, 5000, 1, 1, 12680),
    (1, '张家界森林公园', '喀斯特地貌奇峰林立，自然风光绝美', '/img/scenic/zhangjiajie.jpg', '湖南省张家界市武陵源区', 110.482365, 29.321478, '07:00-17:30', 225.00, 4.9, 4000, 1, 1, 9860),
    (2, '故宫博物院', '明清两代皇家宫殿，世界级文化遗产', '/img/scenic/gugong.jpg', '北京市东城区景山前街', 116.397128, 39.916888, '08:30-17:00', 60.00, 4.9, 10000, 1, 1, 28960),
    (3, '上海迪士尼乐园', '大型童话主题乐园，游玩项目丰富', '/img/scenic/disney.jpg', '上海市浦东新区川沙镇', 121.682457, 31.145896, '08:00-21:00', 599.00, 4.7, 2000, 1, 1, 16520);

-- ====================== 5. 景区每日库存测试数据 ======================
INSERT INTO scenic_stock (scenic_id, visit_date, total_stock, surplus_stock)
VALUES
    (1, '2026-05-25', 5000, 4680),
    (2, '2026-05-25', 4000, 3520),
    (3, '2026-05-25', 10000, 8900),
    (4, '2026-05-25', 2000, 1360);

-- ====================== 6. 订单主表测试数据 ======================
INSERT INTO order_info (order_no, user_id, total_amount, visit_date, pay_type, pay_status, order_status, contact_name, contact_phone, remark, pay_time, expire_time)
VALUES
    ('ORD20260524001', 2, 380.00, '2026-05-25', 1, 1, 1, '小B', '13800003333', '双人出行，靠窗观赏风景', '2026-05-24 10:20:35', NULL),
    ('ORD20260524002', 1, 225.00, '2026-05-26', 2, 1, 1, '小A', '13800002222', '单人游玩', '2026-05-24 14:10:22', NULL);

-- ====================== 7. 订单子项测试数据 ======================
INSERT INTO order_item (order_id, scenic_id, scenic_name_snapshot, unit_price_snapshot, quantity, total_price)
VALUES
    (1, 1, '黄山风景区', 190.00, 2, 380.00),
    (2, 2, '张家界森林公园', 225.00, 1, 225.00);

-- ====================== 8. 景区评论测试数据 ======================
INSERT INTO scenic_comment (user_id, scenic_id, content, images, score, status, parent_id)
VALUES
    (2, 1, '黄山景色特别震撼，值得专程前来游玩', '/img/comment/c1.jpg', 5, 1, 0),
    (1, 3, '故宫历史底蕴浓厚，建筑工艺十分精美', '/img/comment/c2.jpg', 5, 1, 0);

-- ====================== 9. 旅游攻略测试数据 ======================
INSERT INTO travel_strategy (title, description, content, cover_image, admin_id, category, view_count, like_count, status)
VALUES
    ('黄山2天1夜游玩全攻略', '经典游玩路线，避坑省钱指南', '详细行程规划、食宿推荐、景点打卡点位', '/img/strategy/huangshan_str.jpg', 1, '自然风景', 3680, 216, 1),
    ('北京故宫深度游览指南', '讲解历史典故，小众打卡点位推荐', '分区游览顺序，文物观赏要点介绍', '/img/strategy/gugong_str.jpg', 1, '人文古迹', 4250, 289, 1);

-- ====================== 10. 系统公告测试数据 ======================
INSERT INTO sys_announcement (title, content, type, status, publisher, view_count, publish_time)
VALUES
    ('平台正式上线通知', '景区票务管理系统全面上线，支持在线购票预约', 1, 1, '管理员', 1560, '2026-05-20 09:00:00'),
    ('五一出行购票提醒', '节假日客流量较大，请提前3天预约购票', 2, 1, '运营组', 2380, '2026-05-22 11:30:00');

-- ====================== 11. 用户收藏测试数据 ======================
INSERT INTO user_favorite (user_id, target_id, target_type)
VALUES
    (1, 1, 1),
    (2, 3, 1),
    (1, 1, 2);

-- ====================== 12. 用户点赞测试数据 ======================
INSERT INTO user_like (user_id, target_id, target_type)
VALUES
    (2, 1, 1),
    (1, 2, 1),
    (2, 1, 2);

-- ====================== 13. 购物车测试数据 ======================
INSERT INTO shopping_cart (user_id, scenic_id, quantity, selected)
VALUES
    (1, 4, 1, 1),
    (2, 2, 2, 1);