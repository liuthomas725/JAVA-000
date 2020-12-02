CREATE TABLE `t_user` (
  `user_id` bigint(20) unsigned NOT NULL,
  `user_name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '用户名',
  `phone` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '手机号码',
  `password` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '用户密码',
  `sex` tinyint(4) DEFAULT NULL COMMENT '性别:1男2女',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户信息表';