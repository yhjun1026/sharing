﻿/****************************表结构的设计****************************/
/*组织表*/
CREATE TABLE SHSTORE(
UUID            VARCHAR(32)      PRIMARY KEY NOT NULL,
CODE            VARCHAR(32)      NOT NULL,    /*组织代码*/
NAME            VARCHAR(64)      NOT NULL,    /*组织名称*/
LICENCE         VARCHAR(128)     NULL,        /*注册信息*/
LASTUPDTIME     DATETIME         NULL,        /*最后修改时间*/
MEMO            VARCHAR(256)     NULL,        /*备注(预留)*/
UPPERUUID       VARCHAR(32)      NULL         /*上级组织UUID(SHSTORE.UUID)*/
);


/*用户表*/
CREATE TABLE SHUSER(
UUID            VARCHAR(32)      PRIMARY KEY NOT NULL,
CODE            VARCHAR(32)      NOT NULL,    /*用户代码*/
NAME            VARCHAR(64)      NOT NULL,    /*用户名称*/
TYPE            VARCHAR(64)      NULL,        /*用户类型*/
GROUPUUID       VARCHAR(64)      NULL,        /*用户组UUID*/
PASSWORD        VARCHAR(64)      NULL,        /*用户密码*/
LOGINTIME       DATETIME         NULL,        /*登陆时间*/
MOBILE          VARCHAR(32)      NULL,        /*手机号*/
LASTUPDTIME     DATETIME         NULL,        /*最后更新时间*/
MEMO            VARCHAR(256)     NULL,        /*备注(预留)*/
STOREUUID       VARCHAR(32)      NULL,        /*所属组织(SHSTORE.UUID)*/
STORECODE       VARCHAR(64)      NULL,        /*所属组织(SHSTORE.CODE)*/
STORENAME       VARCHAR(64)      NULL         /*所属组织(SHSTORE.NAME)*/
);

/*物品表*/
CREATE TABLE SHGOODS(
UUID            VARCHAR(32)      PRIMARY KEY NOT NULL,
CODE            VARCHAR(64)      NOT NULL,       /*物品代码*/
NAME            VARCHAR(64)      NOT NULL,       /*物品名称*/
TYPE            VARCHAR(64)      NULL,           /*物品类型*/
STAT            INT              DEFAULT 0 NULL, /*物品状态 0 正常; 1 使用中; 2 作废;  3 损坏;*/
PICTURE         VARCHAR(64)      NULL,           /*物品图片ID*/
DESCRIPTION     VARCHAR(512)     NULL,           /*详细描述*/
PRICE           DECIMAL(10,2)    NULL,           /*借用单价*/
DEPOSITAMT      DECIMAL(10,2)    NULL,           /*押金金额*/
REPAYAMT        DECIMAL(10,2)    NULL,           /*损坏需偿还金额*/
LASTER          VARCHAR(32)      NULL,           /*最后修改人*/
LASTUPDTIME     DATETIME         NULL,           /*最后更新时间*/
MEMO            VARCHAR(256)     NULL,           /*备注(预留)*/
STOREUUID       VARCHAR(32)      NULL            /*所属组织(SHSTORE.UUID)*/
);

/*物品库存*/
CREATE TABLE SHGoodsStock(
UUID            VARCHAR(32)    PRIMARY KEY NOT NULL,  /*物品uuid*/
INV             DECIMAL(10,2)  DEFAULT 0 NOT NULL,    /*总库存*/
QTY             DECIMAL(10,2)  DEFAULT 0 NOT NULL,    /*可用数量*/
USEQTY          DECIMAL(10,2)  DEFAULT 0 NOT NULL,    /*已借出数量*/
LASTUPDTIME     DATETIME       NULL,                  /*最后更新时间*/
MEMO            VARCHAR(256)   NULL                   /*备注(预留)*/
);

/*物品借用单主表*/
CREATE TABLE IF NOT EXISTS `shgoodsborrowmst` (
  `uuid` varchar(32) NOT NULL,
  `bill_number` varchar(32) NOT NULL COMMENT '借用单据号',
  `stat` varchar(16) NOT NULL COMMENT '单据状态 new 新增; 已领取 using; 已归还 backed; 已赔偿 compensated',
  `borrow_type` varchar(64) DEFAULT NULL COMMENT '借用人类型(内部员工，外部)，暂时无用',
  `borrower` varchar(64) DEFAULT NULL COMMENT '借用人',
  `mobile` varchar(32) NOT NULL COMMENT '借用人手机号',
  `address` varchar(256) DEFAULT NULL COMMENT '借用人联系地址',
  `plan_return_time` datetime NOT NULL COMMENT '计划归还时间',
  `real_return_time` datetime DEFAULT NULL COMMENT '实际归还时间',
  `borrow_operator` varchar(64) DEFAULT NULL COMMENT '领用受理人',
  `borrow_operate_time` datetime DEFAULT NULL COMMENT '领用受理时间',
  `return_operator` varchar(64) DEFAULT NULL COMMENT '归还受理人',
  `return_operate_time` datetime DEFAULT NULL COMMENT '归还受理时间',
  `lst_upd_time` datetime NOT NULL COMMENT '最后更新时间',
  `memo` varchar(256) DEFAULT NULL COMMENT '备注',
  `store_uuid` varchar(32) DEFAULT NULL COMMENT '所属组织，暂时无用',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='物品借用单主表';

/*物品借用单明细*/
CREATE TABLE IF NOT EXISTS `shgoodsborrowdtl` (
  `uuid` varchar(32) NOT NULL,
  `goods_uuid` varchar(32) NOT NULL COMMENT '物品id',
  `goods_code` varchar(64) DEFAULT NULL COMMENT '物品代码',
  `goods_name` varchar(64) DEFAULT NULL COMMENT '物品名称',
  `borrow_qty` decimal(10,2) DEFAULT '0.00' COMMENT '物品借用数量，暂时无用',
  `borrow_descrip` varchar(512) DEFAULT NULL COMMENT '借出物品情况描述',
  `deposit_amt` decimal(10,2) DEFAULT '0.00' COMMENT '借用物品时缴纳押金',
  `damaged` int(11) DEFAULT '0' COMMENT '损坏标识;0 没有损坏;1 已损坏;',
  `return_descrip` varchar(512) DEFAULT NULL COMMENT '物品归还时描述',
  `return_qty` decimal(10,2) DEFAULT '0.00' COMMENT '物品归还数量，暂时无用',
  `pay_amt` decimal(10,2) DEFAULT '0.00' COMMENT '使用费用金额',
  `return_deposit_amt` decimal(10,2) DEFAULT '0.00' COMMENT '归还押金金额',
  `borrow_uuid` varchar(32) NOT NULL COMMENT '借用单主表id',
  `borrow_pay_uuid` varchar(32) DEFAULT NULL COMMENT '借用付款id',
  `return_pay_uuid` varchar(32) DEFAULT NULL COMMENT '归还时退款id',
  `compensate_pay_uuid` varchar(32) DEFAULT NULL COMMENT '赔偿付款id',
  `memo` varchar(256) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`uuid`),
  KEY `borrow_uuid` (`borrow_uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='借用单明细表';

/*支付信息*/
CREATE TABLE IF NOT EXISTS `shpayinfo` (
  `uuid` varchar(32) NOT NULL,
  `pay_id` varchar(64) DEFAULT NULL COMMENT '支付记录id',
  `trans_type` int(11) NOT NULL COMMENT '交易类型,  1:支付， -1:退款',
  `pay_type` int(11) DEFAULT NULL COMMENT '支付方式, 1:微信， 2:支付宝',
  `trade_no` varchar(64) NOT NULL COMMENT '支付单号（支付平台）',
  `out_trade_no` varchar(64) NOT NULL COMMENT '支付单号（商户）',
  `pay_amt` decimal(10,2) DEFAULT '0.00' COMMENT '支付金额',
  `pay_user` varchar(64) DEFAULT NULL COMMENT '支付人',
  `pay_time` datetime DEFAULT NULL COMMENT '支付（退款）时间',
  `ori_trade_no` varchar(64) DEFAULT NULL COMMENT '原支付单号（支付平台，退款时使用）',
  `ori_out_trade_no` varchar(64) DEFAULT NULL COMMENT '原支付单号（商户，退款时使用）',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='付款信息表';

CREATE TABLE IF NOT EXISTS `serial_number` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `day` date NOT NULL COMMENT '日期',
  `business_code` varchar(64) NOT NULL DEFAULT '' COMMENT '业务类型code',
  `num` int(11) NOT NULL DEFAULT '0' COMMENT '当前值',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `orgCodeDay` (`business_code`,`day`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

/****************************END****************************/