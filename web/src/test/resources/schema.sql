CREATE TABLE `menu` (
	`uuid` varchar(32) NOT NULL COMMENT '主键',
	`name` VARCHAR (50) DEFAULT NULL,
PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;