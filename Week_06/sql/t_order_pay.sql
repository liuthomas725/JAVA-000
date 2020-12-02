CREATE TABLE `t_order_pay` (
  `order_pay_id` int(11) NOT NULL COMMENT '主键id',
  `order_price` decimal(10,2) DEFAULT NULL COMMENT '订单价格',
  `pay_money` decimal(10,0) DEFAULT NULL COMMENT '支付金额',
  `pay_type` tinyint(4) DEFAULT NULL COMMENT '支付方式:1支付宝2微信',
  `store_order_id` bigint(20) DEFAULT NULL COMMENT '主订单id',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`order_pay_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='交易单信息';