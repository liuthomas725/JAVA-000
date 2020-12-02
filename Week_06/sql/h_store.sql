CREATE TABLE `h_store` (
  `store_id` bigint(20) NOT NULL COMMENT '主键id',
  `store_name` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '商家名字',
  `store_logo` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '商家logo',
  `desc` varchar(500) COLLATE utf8_bin NOT NULL COMMENT '详情',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`store_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='商家信息';