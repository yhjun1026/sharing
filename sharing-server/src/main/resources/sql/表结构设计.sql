/****************************表结构的设计****************************/
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

/*物品表*/
CREATE TABLE SHGOODS(
UUID            VARCHAR(32)      PRIMARY KEY NOT NULL,
CODE            VARCHAR(64)      NOT NULL,       /*物品代码*/
NAME            VARCHAR(64)      NOT NULL,       /*物品名称*/
TYPE            VARCHAR(64)      NULL,           /*物品类型*/
STAT            INT              DEFAULT 0 NULL, /*物品状态 0 正常; 1 使用中; 2 作废;  3 损坏;*/
QUANTITY        INT              DEFAULT 0 NULL, /*物品数量*/
STOCKQUANTITY   INT              DEFAULT 0 NULL, /*物品库存数量*/
PICTURE         VARCHAR(64)      NULL,           /*物品图片ID*/
DESCRIPTION     VARCHAR(512)     NULL,           /*详细描述*/
PRICE           DECIMAL(10,2)    NULL,           /*单价*/
DEPOSITAMT      DECIMAL(10,2)    NULL,           /*押金金额*/
COSTPRICE       DECIMAL(10,2)    NULL,           /*成本金额*/
REPAYAMT        DECIMAL(10,2)    NULL,           /*损坏需偿还金额*/
RENTPRICE       DECIMAL(10,2)    NULL,           /*租用价格*/
LASTER          VARCHAR(32)      NULL,           /*最后修改人*/
LASTUPDTIME     DATETIME         NULL,           /*最后更新时间*/
MEMO            VARCHAR(256)     NULL,           /*备注(预留)*/
STOREUUID       VARCHAR(32)      NULL            /*所属组织(SHSTORE.UUID)*/
);

/*物品库存*/
CREATE TABLE SHGoodsStock(
UUID            VARCHAR(32)    PRIMARY KEY NOT NULL,  /*uuid*/
GOODSUUID       VARCHAR(32)    NOT NULL,              /*物品UUID*/
NO              INT            DEFAULT 0 NOT NULL,    /*商品编号*/
STATE           INT            DEFAULT 0 NOT NULL,    /*0表示可用，1表示已预定，2表示已租用，3表示已损坏，4表示已遗失*/
LOCKVERSION     INT            DEFAULT 0 NOT NULL,    /*乐观锁*/
MEMO            VARCHAR(256)   NULL                   /*备注*/
);

/*物品借用单主表*/
CREATE TABLE IF NOT EXISTS `shgoodsborrowmst` (
  `uuid` varchar(32) NOT NULL,
  `bill_number` varchar(32) NOT NULL COMMENT '借用单据号',
  `stat` varchar(16) NOT NULL COMMENT '单据状态 new 新增; 已领取 using; 已归还 backed; 已赔偿 compensated',
  `borrower` varchar(64) DEFAULT NULL COMMENT '借用人',
  `mobile` varchar(32) NOT NULL COMMENT '借用人手机号',
  `address` varchar(256) DEFAULT NULL COMMENT '借用人联系地址',
  `plan_back_time` datetime NOT NULL COMMENT '计划归还时间',
  `real_back_time` datetime DEFAULT NULL COMMENT '实际归还时间',
  `borrow_dealer` varchar(64) DEFAULT NULL COMMENT '领用受理人',
  `borrow_deal_time` datetime DEFAULT NULL COMMENT '领用受理时间',
  `back_dealer` varchar(64) DEFAULT NULL COMMENT '归还受理人',
  `back_deal_time` datetime DEFAULT NULL COMMENT '归还受理时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `lst_upd_time` datetime NOT NULL COMMENT '最后更新时间',
  `memo` varchar(256) DEFAULT NULL COMMENT '备注',
  `borrow_pay_uuid` varchar(32) DEFAULT NULL COMMENT '租用付款uuid',
  `back_pay_uuid` varchar(32) DEFAULT NULL COMMENT '退还时退款uuid',
  `compensate_pay_uuid` varchar(32) DEFAULT NULL COMMENT '赔偿付款uuid',
  `store_uuid` varchar(32) DEFAULT NULL COMMENT '所属组织，暂时无用',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='物品借用单主表';


/*物品借用单明细*/
CREATE TABLE IF NOT EXISTS `shgoodsborrowdtl` (
  `uuid` varchar(32) NOT NULL,
  `goods_uuid` varchar(32) NOT NULL COMMENT '具体物品uuid',
  `goods_code` varchar(64) DEFAULT NULL COMMENT '具体物品代码',
  `goods_name` varchar(64) DEFAULT NULL COMMENT '物品名称',
  `goods_price` decimal(10,2) DEFAULT NULL COMMENT '物品单价',
  `compensate_amt` decimal(10,2) DEFAULT NULL COMMENT '需赔偿金额',
  `borrow_descrip` varchar(512) DEFAULT NULL COMMENT '借出物品情况描述',
  `deposit_amt` decimal(10,2) DEFAULT '0.00' COMMENT '借用物品时缴纳押金',
  `return_descrip` varchar(512) DEFAULT NULL COMMENT '物品归还时描述',
  `borrow_uuid` varchar(32) NOT NULL COMMENT '借用单主表id',
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
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `orgCodeDay` (`business_code`,`day`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `sharing_menu` (
  `id` int(11) NOT NULL,
  `code` varchar(255) DEFAULT NULL COMMENT '编号',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `parent_id` int(11) DEFAULT NULL COMMENT '父级菜单id',
  `show_sep` varchar(255) DEFAULT NULL COMMENT '显示顺序',
  `createTime` datetime DEFAULT NULL,
  `router` varchar(255) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `sharing_operation` (
  `id` int(11) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `action` varchar(255) DEFAULT NULL,
  `menu_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `sharing_role_operation` (
  `id` int(11) NOT NULL,
  `role_type` varchar(255) DEFAULT NULL,
  `operation_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `shuser` (
  `uuid` varchar(32) NOT NULL,
  `code` varchar(32) NOT NULL COMMENT '员工代码',
  `name` varchar(64) NOT NULL COMMENT '员工名称',
  `type` varchar(64) DEFAULT NULL COMMENT '用户类型',
  `group_uuid` varchar(64) DEFAULT NULL COMMENT '用户组',
  `password` varchar(64) DEFAULT NULL COMMENT '密码',
  `login_time` datetime DEFAULT NULL COMMENT '登录时间',
  `mobile` varchar(32) DEFAULT NULL COMMENT '联系方式',
  `lst_upd_time` datetime DEFAULT NULL COMMENT '最后修改时间',
  `memo` varchar(256) DEFAULT NULL COMMENT '备注',
  `store_uuid` varchar(32) DEFAULT NULL COMMENT '组织id',
  `store_code` varchar(64) DEFAULT NULL COMMENT '组织代码',
  `store_name` varchar(64) DEFAULT NULL COMMENT '组织名称',
  `stat` tinyint(4) NOT NULL DEFAULT '0' COMMENT '用户状态（0 启用，1 停用）',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/****************************END****************************/