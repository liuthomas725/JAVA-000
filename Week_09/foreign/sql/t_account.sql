CREATE TABLE `t_account` (
  `account_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '主键id',
  `account_type` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '账号类型:1.人民币；2美元',
  `balance` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '余额',
  `userid` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '用户id',
  PRIMARY KEY (`account_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='账号表';