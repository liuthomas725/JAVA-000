CREATE TABLE `t_order_preferential` (
  `order_preferential_id` int(11) NOT NULL COMMENT '主键id',
  `preferential_price` decimal(10,2) NOT NULL COMMENT '抵扣金额',
  `preferential_type` tinyint(4) NOT NULL COMMENT '抵扣类型:1红包2券',
  `store_order_id` int(11) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`order_preferential_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='订单抵扣信息';