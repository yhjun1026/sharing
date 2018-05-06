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
CREATE TABLE SHGoodsBorrowMst(
UUID            VARCHAR(32)    PRIMARY KEY NOT NULL,
BILLNUMBER      VARCHAR(32)    NOT NULL,              /*物品借用单号*/
STAT            VARCHAR(16)    NOT NULL,              /*单据状态 new 新增; 已领取 using; 已归还 backed; 已赔偿 compensated*/
BORROWERTYPE    VARCHAR(64)    NULL,                  /*借用人类型(内部员工，外部)*/ 
BORROWER        VARCHAR(64)    NULL,                  /*借用人*/
MOBILE          VARCHAR(32)    NULL,                  /*借用人手机号*/
ADDRESS         VARCHAR(256)   NULL,                  /*借用人联系地址*/
RETURNTIME      DATETIME       NULL,                  /*计划归还时间*/
REALRETURNTIME  DATETIME       NULL,                  /*实际归还时间*/
FILLER          VARCHAR(64)    NULL,                  /*填单人*/  
FILDATE         DATETIME       NULL,                  /*填单人时间*/  
LASTER          VARCHAR(64)    NULL,                  /*最后修改人*/
LASTUPDTIME     DATETIME       NULL,                  /*最后更新时间*/ 
MEMO            VARCHAR(256)   NULL,                  /*备注(预留)*/
STOREUUID       VARCHAR(32)    NULL                   /*所属组织(SHSTORE.UUID)*/
);

/*物品借用单明细*/
CREATE TABLE SHGoodsBorrowDtl(
UUID               VARCHAR(32)      PRIMARY KEY NOT NULL,
GOODSUUID          VARCHAR(32)      NOT NULL,              /*物品UUID*/
GOODSCODE          VARCHAR(64)      NOT NULL,              /*物品代码*/
GOODSNAME          VARCHAR(64)      NOT NULL,              /*物品名称*/
BORROWQTY          DECIMAL(10,2)    DEFAULT 0 NULL,        /*物品借用数量*/
BORROWDESCRIP      VARCHAR(512)     NULL,                  /*借出物品情况描述*/
DEPOSITAMT         DECIMAL(10,2)    DEFAULT 0 NULL,        /*借用时缴纳押金*/
DAMAGED            INT              DEFAULT 0 NULL,        /*损坏标识;0 没有损坏;1 已损坏;*/
RETURNDESCRIP      VARCHAR(512)     NULL,                  /*归还物品情况描述*/
BACKQTY            DECIMAL(10,2)    DEFAULT 0 NULL,        /*物品归还数量*/
PAYAMT             DECIMAL(10,2)    DEFAULT 0 NULL,        /*使用费用金额*/
BACKDEPOSITAMT     DECIMAL(10,2)    DEFAULT 0 NULL,        /*归还押金情况*/
MEMO               VARCHAR(256)     NULL,                  /*备注(预留)*/
BORROWUUID         VARCHAR(32)      NULL,                  /*借用单ID(SHGoodsBorrowMst.UUID)*/
BORROWPAYUUID      VARCHAR(32)      NULL,                  /*借用单付款id*/
BACKPAYUUID        VARCHAR(32)      NULL,                  /*退款付款id*/
COMPENSATEPAYUUID  VARCHAR(32)      NULL                   /*赔偿付款id*/
);

/*支付信息*/
CREATE TABLE SHPAYINFO(
UUID               VARCHAR(32)      PRIMARY KEY NOT NULL,
PAYID              VARCHAR(64)      NOT NULL,              /*支付记录id*/
TRANSTYPE          INT              NOT NULL,              /*交易类型,  1:支付， -1:退款*/
PAYTYPE            INT              NULL,                  /*支付方式, 1:微信， 2:支付宝*/
TRADENO            VARCHAR(64)      NOT NULL,              /*支付单号（支付平台）*/
OUTTRADENO         VARCHAR(64)      NOT NULL,              /*支付单号（商户）*/
PAYAMT             DECIMAL(10,2)    DEFAULT 0 NULL,        /*使用费用金额*/
PAYUSER            VARCHAR(64)      NOT NULL,              /*支付人*/
PAYTIME            DATETIME         NULL,                  /*支付（退款）时间*/
ORITRADENO         VARCHAR(64)      NULL,                  /*原支付单号（支付平台，退款时使用）*/
ORIOUTTRADENO      VARCHAR(64)      NULL                   /*原支付单号（商户，退款时使用）*/
);

/****************************END****************************/