CREATE TABLE `t_product_order` (
  `product_order_id` bigint(20) NOT NULL COMMENT '主键id',
  `product_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '商品名字',
  `product_price` decimal(10,2) DEFAULT NULL COMMENT '商品价格',
  `order_num` int(11) DEFAULT NULL COMMENT '下单数量',
  `order_status` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '1待支付,2已付款,3已完成,4已取消,5已退款',
  `pay_money` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '支付金额',
  `store_order_id` bigint(20) unsigned DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`product_order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='子订单信息';