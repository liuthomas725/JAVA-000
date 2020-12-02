CREATE TABLE `t_order_ship` (
  `order_ship_id` bigint(20) NOT NULL COMMENT '主键id',
  `ship_company` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '物流公司',
  `desc` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '描述',
  `store_order_id` bigint(20) DEFAULT NULL COMMENT '主订单id',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`order_ship_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='订单物流信息';