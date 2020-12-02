CREATE TABLE `t_address` (
  `address_id` bigint(20) NOT NULL COMMENT '主键id',
  `person_name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '收货人姓名',
  `address` varchar(500) COLLATE utf8_bin DEFAULT NULL COMMENT '收货地址',
  `person_phone` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '收货人手机号码',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`address_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='收货人信息';