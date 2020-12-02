CREATE TABLE `t_deduction` (
  `deduction_id` bigint(20) NOT NULL COMMENT '主键id',
  `full` int(11) NOT NULL COMMENT '满',
  `reduce` int(11) NOT NULL COMMENT '减',
  `type` tinyint(4) DEFAULT NULL COMMENT '类型:1.红包2.商家券3.商品券',
  `store_id` bigint(20) DEFAULT NULL COMMENT '商家id',
  `product_id` bigint(20) DEFAULT NULL COMMENT '商品id',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`deduction_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='抵扣券或红包信息';