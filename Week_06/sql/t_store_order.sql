CREATE TABLE `t_store_order` (
  `store_order_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '主键id',
  `user_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '用户id',
  `store_name` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '商家名字',
  `store_id` decimal(10,2) unsigned NOT NULL DEFAULT '0.00' COMMENT '商家id',
  `order_num` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '下单数量',
  `address_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '收获地址id',
  `status` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '1待支付,2已付款,3已完成,4已取消,5已退款',
  `freight_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '运费id',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`store_order_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='主订单信息';