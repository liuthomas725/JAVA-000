CREATE TABLE `t_ship_template` (
  `ship_template_id` bigint(20) DEFAULT NULL COMMENT '主键id',
  `store_id` int(11) DEFAULT NULL COMMENT '商家id',
  `weight` int(11) DEFAULT NULL COMMENT '重量',
  `send_type` tinyint(4) DEFAULT NULL COMMENT '配送快递',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='物流模版';