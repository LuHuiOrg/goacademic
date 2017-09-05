/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50715
Source Host           : 127.0.0.1:3306
Source Database       : lh_web_test

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2017-09-04 17:43:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(20) DEFAULT NULL COMMENT '员工名字',
  `username` varchar(20) DEFAULT NULL COMMENT '员工登录系统名',
  `password` char(32) DEFAULT NULL COMMENT '员工登录系统密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='公司员工表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', '曾小辉', 'zengxiaohui', '123456');

-- ----------------------------
-- Table structure for t_category
-- ----------------------------
DROP TABLE IF EXISTS `t_category`;
CREATE TABLE `t_category` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) NOT NULL COMMENT '名称',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父id',
  `parent_ids` varchar(200) DEFAULT NULL COMMENT '所有父id，'''',''''分隔',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='分类表';

-- ----------------------------
-- Records of t_category
-- ----------------------------

-- ----------------------------
-- Table structure for t_chapter
-- ----------------------------
DROP TABLE IF EXISTS `t_chapter`;
CREATE TABLE `t_chapter` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '章节id',
  `course_id` bigint(20) NOT NULL COMMENT '课程表（t_course）的id',
  `name` varchar(50) NOT NULL COMMENT '章节名字',
  `url` varchar(200) DEFAULT NULL COMMENT '章节视频url地址',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='课程章节表';

-- ----------------------------
-- Records of t_chapter
-- ----------------------------

-- ----------------------------
-- Table structure for t_course
-- ----------------------------
DROP TABLE IF EXISTS `t_course`;
CREATE TABLE `t_course` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '课程id',
  `name` varchar(50) NOT NULL COMMENT '课程名字',
  `description` varchar(1000) DEFAULT NULL COMMENT '课程详情',
  `cover` varchar(200) DEFAULT NULL COMMENT '课程封面',
  `price` decimal(12,2) DEFAULT NULL COMMENT '课程价格',
  `category_id` bigint(20) unsigned DEFAULT NULL COMMENT '课程所属分类',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='课程表';

-- ----------------------------
-- Records of t_course
-- ----------------------------
INSERT INTO `t_course` VALUES ('3', 'java课程培训', '23423收到广东省', 'http://47.92.123.48/images/cover/ef7554cf-2929-4f8d-8a5c-78bfbe118682.png', '250.00', null);

-- ----------------------------
-- Table structure for t_mac
-- ----------------------------
DROP TABLE IF EXISTS `t_mac`;
CREATE TABLE `t_mac` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `mac` varchar(30) NOT NULL COMMENT 'mac地址',
  `student_id` bigint(20) NOT NULL COMMENT 't_student表的id（该mac地址所属的学生）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='学生mac地址表';

-- ----------------------------
-- Records of t_mac
-- ----------------------------

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `order_code` char(12) NOT NULL COMMENT '订单编号',
  `student_info_id` bigint(20) NOT NULL COMMENT '学生信息id',
  `order_amount` decimal(12,2) NOT NULL COMMENT '订单金额',
  `paid_amount` decimal(12,2) DEFAULT NULL COMMENT '已付金额',
  `paid_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '支付时间',
  `pay_type` int(11) DEFAULT NULL COMMENT '支付类型',
  `pay_status` int(11) NOT NULL COMMENT '支付状态',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `remarks` varchar(200) DEFAULT NULL COMMENT '备注说明',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='订单表';

-- ----------------------------
-- Records of t_order
-- ----------------------------

-- ----------------------------
-- Table structure for t_order_item
-- ----------------------------
DROP TABLE IF EXISTS `t_order_item`;
CREATE TABLE `t_order_item` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `order_code` char(12) NOT NULL COMMENT '订单编号',
  `course_id` bigint(20) NOT NULL COMMENT '课程id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='订单明细表';

-- ----------------------------
-- Records of t_order_item
-- ----------------------------

-- ----------------------------
-- Table structure for t_shopping_cart
-- ----------------------------
DROP TABLE IF EXISTS `t_shopping_cart`;
CREATE TABLE `t_shopping_cart` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '购物车主键',
  `student_info_id` bigint(20) NOT NULL COMMENT '学生信息id',
  `course_id` bigint(20) NOT NULL COMMENT '课程id',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='购物车表';

-- ----------------------------
-- Records of t_shopping_cart
-- ----------------------------

-- ----------------------------
-- Table structure for t_student_info
-- ----------------------------
DROP TABLE IF EXISTS `t_student_info`;
CREATE TABLE `t_student_info` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `nickname` varchar(20) NOT NULL COMMENT '昵称',
  `password` varchar(32) NOT NULL COMMENT '密码',
  `mobile` varchar(30) NOT NULL COMMENT '手机号',
  `email` varchar(50) NOT NULL COMMENT '邮箱',
  `category_id` bigint(20) unsigned DEFAULT NULL COMMENT '学生所属分类',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='学生信息表';

-- ----------------------------
-- Records of t_student_info
-- ----------------------------
INSERT INTO `t_student_info` VALUES ('1', '自掘坟墓', '123456', '13776060074', '2362651588@qq.com', null);
