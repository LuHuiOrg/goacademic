CREATE TABLE `t_course` (
`id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '课程id',
`name` varchar(50) NOT NULL COMMENT '课程名字',
`description` varchar(1000) NULL DEFAULT NULL COMMENT '课程详情',
`cover` varchar(200) NULL DEFAULT NULL COMMENT '课程封面',
`price` decimal(12,2) NULL DEFAULT NULL COMMENT '课程价格',
PRIMARY KEY (`id`) 
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '课程表';

CREATE TABLE `t_chapter` (
`id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '章节id',
`course_id` bigint(20) NOT NULL COMMENT '课程表（t_course）的id',
`name` varchar(50) NOT NULL COMMENT '章节名字',
`url` varchar(200) NULL DEFAULT NULL COMMENT '章节视频url地址',
`parent_id` bigint(20) NULL DEFAULT NULL COMMENT '父id',
PRIMARY KEY (`id`) 
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '课程章节表';

CREATE TABLE `t_shopping_cart` (
`id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '购物车主键',
`student_info_id` bigint(20) NOT NULL COMMENT '学生信息id',
`course_id` bigint(20) NOT NULL COMMENT '课程id',
`create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY (`id`) 
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '购物车表';

CREATE TABLE `t_order` (
`id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
`order_code` char(12) NOT NULL COMMENT '订单编号',
`student_info_id` bigint(20) NOT NULL COMMENT '学生信息id',
`order_amount` decimal(12,2) NOT NULL COMMENT '订单金额',
`paid_amount` decimal(12,2) NULL DEFAULT NULL COMMENT '已付金额',
`paid_time` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '支付时间',
`pay_type` int(11) NULL COMMENT '支付类型',
`pay_status` int(11) NOT NULL COMMENT '支付状态',
`create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
`remarks` varchar(200) NULL DEFAULT NULL COMMENT '备注说明',
PRIMARY KEY (`id`) 
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '订单表';

CREATE TABLE `t_order_item` (
`id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
`order_code` char(12) NOT NULL COMMENT '订单编号',
`course_id` bigint(20) NOT NULL COMMENT '课程id',
PRIMARY KEY (`id`) 
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '订单明细表';

