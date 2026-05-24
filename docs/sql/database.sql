-- 创建数据库
CREATE DATABASE IF NOT EXISTS tourism_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE tourism_db;

-- 1. 用户表（删除 uid 字段 + 对应索引）
CREATE TABLE sys_user (
                          id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '主键ID(系统自增)',
                          username VARCHAR(50) NOT NULL UNIQUE COMMENT '用户名/账号',
                          password VARCHAR(255) NOT NULL COMMENT '密码(加密存储)',
                          nickname VARCHAR(50) COMMENT '昵称',
                          avatar_url VARCHAR(500) COMMENT '头像URL',
                          phone VARCHAR(11) UNIQUE COMMENT '手机号',
                          email VARCHAR(100) COMMENT '邮箱',
                          user_type TINYINT DEFAULT 1 COMMENT '用户类型: 1-普通用户, 2-管理员',
                          status TINYINT DEFAULT 1 COMMENT '账号状态: 1-正常, 0-冻结/禁用',
                          last_login_time DATETIME COMMENT '最后登录时间',
                          create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                          update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                          is_deleted TINYINT DEFAULT 0 COMMENT '是否删除: 0-否, 1-是',
                          INDEX idx_phone (phone),
                          INDEX idx_username (username)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户基础信息表';

-- 2. 管理员角色表
CREATE TABLE sys_role (
                          id TINYINT PRIMARY KEY AUTO_INCREMENT,
                          role_name VARCHAR(30) NOT NULL COMMENT '角色名称: 超级管理员,运营,审核员',
                          permissions TEXT COMMENT '权限列表(JSON格式)',
                          description VARCHAR(200) COMMENT '角色描述',
                          create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                          update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                          is_deleted TINYINT DEFAULT 0 COMMENT '是否删除:0-否,1-是'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='管理员角色权限表';

-- 3. 景区分类表
CREATE TABLE scenic_category (
                                 id INT PRIMARY KEY AUTO_INCREMENT,
                                 category_name VARCHAR(50) NOT NULL COMMENT '分类名称',
                                 description VARCHAR(200) COMMENT '分类描述',
                                 icon_url VARCHAR(500) COMMENT '分类图标URL',
                                 sort_order INT DEFAULT 0 COMMENT '排序序号',
                                 status TINYINT DEFAULT 1 COMMENT '状态:1-启用,0-禁用',
                                 create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                 update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                 is_deleted TINYINT DEFAULT 0 COMMENT '是否删除:0-否,1-是'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='景区分类表';

-- 4. 景区信息表（增加库存、是否实名）
CREATE TABLE scenic_spot (
                             id BIGINT PRIMARY KEY AUTO_INCREMENT,
                             category_id INT COMMENT '所属分类ID',
                             scenic_name VARCHAR(100) NOT NULL COMMENT '景区名称',
                             description TEXT COMMENT '景区描述',
                             cover_image VARCHAR(500) COMMENT '封面图片URL',
                             location VARCHAR(200) COMMENT '所在地',
                             longitude DECIMAL(10,6) COMMENT '经度',
                             latitude DECIMAL(10,6) COMMENT '纬度',
                             open_time VARCHAR(100) COMMENT '开放时间',
                             price DECIMAL(10,2) DEFAULT 0.00 COMMENT '门票价格',
                             score DECIMAL(3,1) DEFAULT 0.0 COMMENT '评分',
                             stock INT DEFAULT 0 COMMENT '门票总库存',
                             is_real_name TINYINT DEFAULT 0 COMMENT '是否需要实名：0-不需要 1-需要',
                             status TINYINT DEFAULT 0 COMMENT '状态:0-待审核,1-已上架,2-已下架',
                             view_count BIGINT DEFAULT 0 COMMENT '浏览量',
                             create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                             update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                             is_deleted TINYINT DEFAULT 0 COMMENT '是否删除:0-否,1-是',
                             INDEX idx_category_id (category_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='景区信息表';

-- 5. 订单主表（删除uid → 使用user_id，补充支付字段）
CREATE TABLE order_info (
                            id BIGINT PRIMARY KEY AUTO_INCREMENT,
                            order_no VARCHAR(50) NOT NULL UNIQUE COMMENT '订单号',
                            user_id BIGINT NOT NULL COMMENT '用户ID',
                            total_amount DECIMAL(10,2) NOT NULL COMMENT '订单总金额',
                            visit_date DATE COMMENT '游玩日期',
                            pay_type TINYINT COMMENT '支付方式：1-微信 2-支付宝',
                            pay_status TINYINT DEFAULT 0 COMMENT '支付状态:0-待支付,1-已支付,2-已取消,3-退款中,4-退款成功',
                            order_status TINYINT DEFAULT 0 COMMENT '订单状态:0-待付款,1-待使用,2-已完成,3-已过期',
                            contact_name VARCHAR(50) COMMENT '联系人姓名',
                            contact_phone VARCHAR(11) COMMENT '联系人电话',
                            remark VARCHAR(200) COMMENT '用户备注',
                            pay_time DATETIME COMMENT '支付时间',
                            expire_time DATETIME COMMENT '支付过期时间',
                            create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                            update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                            is_deleted TINYINT DEFAULT 0,
                            INDEX idx_order_no (order_no),
                            INDEX idx_user_id (user_id),
                            INDEX idx_visit_date (visit_date)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单主表';

-- 6. 订单子项表
CREATE TABLE order_item (
                            id BIGINT PRIMARY KEY AUTO_INCREMENT,
                            order_id BIGINT NOT NULL COMMENT '订单主表ID',
                            scenic_id BIGINT NOT NULL COMMENT '景区ID',
                            scenic_name_snapshot VARCHAR(100) NOT NULL COMMENT '景区名称快照',
                            unit_price_snapshot DECIMAL(10,2) NOT NULL COMMENT '单价快照',
                            quantity INT DEFAULT 1 COMMENT '购买数量',
                            total_price DECIMAL(10,2) NOT NULL COMMENT '小计金额',
                            create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                            update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                            INDEX idx_order_id (order_id),
                            INDEX idx_scenic_id (scenic_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单子项表';

-- 7. 评论表（增加图片字段）
CREATE TABLE scenic_comment (
                                id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                user_id BIGINT NOT NULL COMMENT '用户ID',
                                scenic_id BIGINT NOT NULL COMMENT '景区ID',
                                content TEXT COMMENT '评论内容',
                                images VARCHAR(1000) COMMENT '评论图片，多张逗号分隔',
                                score TINYINT DEFAULT 5 COMMENT '评分1-5星',
                                status TINYINT DEFAULT 0 COMMENT '审核状态:0-待审核,1-已通过,2-违规屏蔽',
                                parent_id BIGINT DEFAULT 0 COMMENT '父评论ID(回复)',
                                create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                is_deleted TINYINT DEFAULT 0 COMMENT '是否删除',
                                INDEX idx_user_id (user_id),
                                INDEX idx_scenic_id (scenic_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='景区评论表';

-- 8. 攻略表（删除作者昵称 → 使用 admin_id）
CREATE TABLE travel_strategy (
                                 id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                 title VARCHAR(200) NOT NULL COMMENT '攻略标题',
                                 description VARCHAR(500) COMMENT '摘要/描述',
                                 content LONGTEXT COMMENT '详细内容(HTML或Markdown)',
                                 cover_image VARCHAR(500) COMMENT '封面图',
                                 admin_id BIGINT NOT NULL COMMENT '发布管理员ID',
                                 category VARCHAR(30) COMMENT '攻略分类标签',
                                 view_count BIGINT DEFAULT 0 COMMENT '浏览量',
                                 like_count BIGINT DEFAULT 0 COMMENT '点赞数',
                                 status TINYINT DEFAULT 0 COMMENT '状态: 0-待审核, 1-已发布, 2-已下架',
                                 create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                 update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                 is_deleted TINYINT DEFAULT 0 COMMENT '是否删除: 0-否, 1-是'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='旅游攻略表';

-- 9. 公告表
CREATE TABLE sys_announcement (
                                  id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                  title VARCHAR(200) NOT NULL COMMENT '公告标题',
                                  content TEXT COMMENT '公告内容',
                                  type TINYINT DEFAULT 1 COMMENT '类型:1-系统通知,2-运营公告,3-活动',
                                  status TINYINT DEFAULT 0 COMMENT '状态:0-待发布,1-已发布,2-已下架',
                                  publisher VARCHAR(50) COMMENT '发布人',
                                  view_count BIGINT DEFAULT 0 COMMENT '浏览量',
                                  publish_time DATETIME COMMENT '发布时间',
                                  create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                  update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                  is_deleted TINYINT DEFAULT 0 COMMENT '是否删除'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='系统公告表';

-- 10. 用户收藏表
CREATE TABLE user_favorite (
                               id BIGINT PRIMARY KEY AUTO_INCREMENT,
                               user_id BIGINT NOT NULL COMMENT '用户ID',
                               target_id BIGINT NOT NULL COMMENT '收藏目标ID',
                               target_type TINYINT NOT NULL COMMENT '类型:1-景区,2-攻略',
                               create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                               UNIQUE KEY uk_user_target (user_id, target_id, target_type),
                               INDEX idx_user_id (user_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户收藏表';

-- 11. 用户点赞表
CREATE TABLE user_like (
                           id BIGINT PRIMARY KEY AUTO_INCREMENT,
                           user_id BIGINT NOT NULL COMMENT '用户ID',
                           target_id BIGINT NOT NULL COMMENT '点赞目标ID',
                           target_type TINYINT NOT NULL COMMENT '类型:1-攻略,2-评论',
                           create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                           UNIQUE KEY uk_user_target (user_id, target_id, target_type),
                           INDEX idx_user_id (user_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户点赞记录表';

-- 12. 购物车表
CREATE TABLE shopping_cart (
                               id BIGINT PRIMARY KEY AUTO_INCREMENT,
                               user_id BIGINT NOT NULL COMMENT '用户ID',
                               scenic_id BIGINT NOT NULL COMMENT '景区ID',
                               quantity INT DEFAULT 1 COMMENT '数量',
                               selected TINYINT DEFAULT 1 COMMENT '是否选中:0-否,1-是',
                               create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                               update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                               UNIQUE KEY uk_user_scenic (user_id, scenic_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='购物车表';

-- 13、景区库存表（按日期库存，防止超卖）
CREATE TABLE scenic_stock (
                              id BIGINT PRIMARY KEY AUTO_INCREMENT,
                              scenic_id BIGINT NOT NULL COMMENT '景区ID',
                              visit_date DATE NOT NULL COMMENT '游玩日期',
                              total_stock INT DEFAULT 0 COMMENT '总库存',
                              surplus_stock INT DEFAULT 0 COMMENT '剩余库存',
                              create_time DATETIME DEFAULT CURRENT_TIMESTAMP,
                              update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                              is_deleted TINYINT DEFAULT 0,
                              UNIQUE KEY uk_scenic_date (scenic_id, visit_date)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='景区每日库存表';