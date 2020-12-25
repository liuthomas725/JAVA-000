CREATE TABLE `t_freeze` (
  `freeze_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '主键id',
  `freeze_amount` bigint(20) unsigned NOT NULL COMMENT '冻结金额',
  `currency` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT ':1.人民币；2美元',
  `freeze_status` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '冻结状态:1.冻结;2.解冻',
  `account_id` bigint(20) unsigned NOT NULL COMMENT '账户id',
  PRIMARY KEY (`freeze_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='冻结表';