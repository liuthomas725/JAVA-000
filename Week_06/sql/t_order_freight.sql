CREATE TABLE `t_order_freight` (
  `order_freight_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '主键id',
  `freight_price` decimal(10,2) unsigned NOT NULL DEFAULT '0.00' COMMENT '运费',
  `store_order_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '主订单id',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`order_freight_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='订单运费信息';