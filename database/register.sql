CREATE TABLE `t_student_info` (

`id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',

`nickname` varchar(20) NOT NULL COMMENT '昵称',

`password` varchar(32) NOT NULL COMMENT '密码',

`mobile` varchar(30) NOT NULL COMMENT '手机号',

`email` varchar(50) NOT NULL COMMENT '邮箱',

`specialty_id` bigint(20) NULL COMMENT 't_specialty表的id（学生所属专业）',

`grade_id` bigint(20) NULL COMMENT 't_grade表的id（学生所属年级）',

PRIMARY KEY (`id`) 

)

ENGINE = InnoDB

DEFAULT CHARACTER SET = utf8

COMMENT = '学生信息表';



CREATE TABLE `t_specialty` (

`id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',

`specialty_name` varchar(30) NOT NULL COMMENT '专业名称',

PRIMARY KEY (`id`) 

)

ENGINE = InnoDB

DEFAULT CHARACTER SET = utf8

COMMENT = '学生所属专业表';



CREATE TABLE `t_grade` (

`id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',

`grade_name` varchar(10) NOT NULL COMMENT '年级名字',

PRIMARY KEY (`id`) 

)

ENGINE = InnoDB

DEFAULT CHARACTER SET = utf8

COMMENT = '年级表';



CREATE TABLE `t_mac` (

`id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',

`mac` varchar(30) NOT NULL COMMENT 'mac地址',

`student_id` bigint(20) NOT NULL COMMENT 't_student表的id（该mac地址所属的学生）',

PRIMARY KEY (`id`) 

)

ENGINE = InnoDB

DEFAULT CHARACTER SET = utf8

COMMENT = '学生mac地址表';



