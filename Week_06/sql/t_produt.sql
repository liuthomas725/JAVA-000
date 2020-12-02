CREATE TABLE `t_produt` (
  `product_id` int(11) NOT NULL,
  `product_name` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '商品名字',
  `product_logo` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '商品logo',
  `desc` varchar(500) COLLATE utf8_bin DEFAULT NULL COMMENT '商品描述',
  `status` tinyint(3) unsigned DEFAULT NULL COMMENT '1.上架2下架',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='商品信息';