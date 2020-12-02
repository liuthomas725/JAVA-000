CREATE TABLE `t_produt_sku` (
  `produt_sku_id` bigint(20) unsigned NOT NULL,
  `sku_attribute` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '规格属性',
  `sku_num` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '数量',
  `pid` bigint(20) DEFAULT NULL COMMENT '父skuid',
  `produt_id` bigint(20) DEFAULT NULL COMMENT '商品id',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`produt_sku_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='商品规格属性';