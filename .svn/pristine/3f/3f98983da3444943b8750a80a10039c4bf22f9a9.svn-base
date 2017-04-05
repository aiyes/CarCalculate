-- Create table   SUTanwei        -------------- 2016-01-13 ---------------
create table CO_INSURANCE_FORM
(
  pol_order          varchar2(32),
  pol_no             VARCHAR2(32),
  prod_id            CHAR(4),
  user_nam           VARCHAR2(64),
  id_card            VARCHAR2(24),
  ins_count          INT,
  email              VARCHAR2(120),
  account_id         VARCHAR2(32),
  uni_user           VARCHAR2(120),
  last_login_errdate TIMESTAMP(6),
  login_err_count    NUMBER(2) default 0,
  isvalid            CHAR(1) default 0
)
;
-- Add comments to the table 
comment on table CO_INSURANCE_FORM
  is '合家欢投保表';  
-- Add comments to the columns 
comment on column CO_INSURANCE_FORM.pol_order
  is '保险订单号
';
comment on column CO_INSURANCE_FORM.pol_no
  is '保单号
';
comment on column CO_INSURANCE_FORM.prod_id
  is '险种代码
';
comment on column CO_INSURANCE_FORM.user_nam
  is '用户姓名
';
comment on column CO_INSURANCE_FORM.id_card
  is '身份证号
';
comment on column CO_INSURANCE_FORM.ins_count
  is '份数
';
comment on column CO_INSURANCE_FORM.email
  is '邮箱
';
comment on column CO_INSURANCE_FORM.account_id
  is '对方资金账户ID
';
comment on column CO_INSURANCE_FORM.uni_user
  is '唯一标识用户字段
';
comment on column CO_INSURANCE_FORM.last_login_errdate
  is '登陆失败最大次数时的时间
';
comment on column CO_INSURANCE_FORM.login_err_count
  is '登录失败次数
';
comment on column CO_INSURANCE_FORM.isvalid
  is '是否有效
';
-- Create/Recreate primary, unique and foreign key constraints 
alter table CO_INSURANCE_FORM
  add constraint PK_CO_INSURANCE_FORM primary key (POL_ORDER);
  
  
-- Create table
create table CO_PAYMENT_FORM
(
  pol_id           VARCHAR2(32) not null,
  pol_order        VARCHAR2(32),
  pol_no           VARCHAR2(32),
  prod_id          CHAR(4) not null,
  acci_tm          TIMESTAMP(6) not null,
  province         VARCHAR2(8) not null,
  city             VARCHAR2(24) not null,
  county           VARCHAR2(24) not null,
  acci_addr        VARCHAR2(200) not null,
  loss_amount      NUMBER(12,2) not null,
  linkman          VARCHAR2(64) not null,
  mobile_phone     VARCHAR2(16) not null,
  acci_cause       CHAR(2) not null,
  acci_desc        VARCHAR2(1048) not null,
  account_nam      VARCHAR2(64) not null,
  account_bank_no  CHAR(2) not null,
  account_bank_nam VARCHAR2(64),
  account_mess     VARCHAR2(120) not null,
  bank_card        VARCHAR2(24) not null,
  create_tm        TIMESTAMP(6) default sysdate not null,
  isvalid          CHAR(1) default '0' not null
)
;
-- Add comments to the table 
comment on table CO_PAYMENT_FORM
  is '合家欢理赔表';  
-- Add comments to the columns 
comment on column CO_PAYMENT_FORM.pol_id
  is '表格主键';
comment on column CO_PAYMENT_FORM.pol_order
  is '保险订单号(唯一键)';
comment on column CO_PAYMENT_FORM.pol_no
  is '保单号(唯一键)';
comment on column CO_PAYMENT_FORM.prod_id
  is '险种代码';
comment on column CO_PAYMENT_FORM.acci_tm
  is '出险时间';
comment on column CO_PAYMENT_FORM.province
  is '省份';
comment on column CO_PAYMENT_FORM.city
  is '市';
comment on column CO_PAYMENT_FORM.county
  is '县';
comment on column CO_PAYMENT_FORM.acci_addr
  is '出险地点';
comment on column CO_PAYMENT_FORM.loss_amount
  is '估损金额';
comment on column CO_PAYMENT_FORM.linkman
  is '联系人';
comment on column CO_PAYMENT_FORM.mobile_phone
  is '手机号';
comment on column CO_PAYMENT_FORM.acci_cause
  is '出险原因';
comment on column CO_PAYMENT_FORM.acci_desc
  is '出险经过';
comment on column CO_PAYMENT_FORM.account_nam
  is '投保人户名';
comment on column CO_PAYMENT_FORM.account_bank_no
  is '投保人开户行序号';
comment on column CO_PAYMENT_FORM.account_bank_nam
  is '投保人开户行';
comment on column CO_PAYMENT_FORM.account_mess
  is '支行信息';
comment on column CO_PAYMENT_FORM.bank_card
  is '投保人账号';
comment on column CO_PAYMENT_FORM.create_tm
  is '创建时间';
comment on column CO_PAYMENT_FORM.isvalid
  is '是否有效(0-报案中,1-报案完成,2-撤单）';
-- Create/Recreate primary, unique and foreign key constraints 
alter table CO_PAYMENT_FORM
  add constraint PK_CO_PAYMENT_FORM primary key (POL_ID);
alter table CO_PAYMENT_FORM
  add constraint UN_CO_PAYMENT_FORM_POL unique (POL_ORDER, POL_NO);
  
  
 
-- Create table
create table CO_PAYMENT_FORM_HISTORY
(
  pol_id           VARCHAR2(32) not null,
  pol_order        VARCHAR2(32),
  pol_no           VARCHAR2(32),
  prod_id          CHAR(4) not null,
  acci_tm          TIMESTAMP(6) not null,
  province         VARCHAR2(8) not null,
  city             VARCHAR2(24) not null,
  county           VARCHAR2(24) not null,
  acci_addr        VARCHAR2(200) not null,
  loss_amount      NUMBER(12,2) not null,
  linkman          VARCHAR2(64) not null,
  mobile_phone     VARCHAR2(16) not null,
  acci_cause       CHAR(2) not null,
  acci_desc        VARCHAR2(1048) not null,
  account_nam      VARCHAR2(64) not null,
  account_bank_no  CHAR(2) not null,
  account_bank_nam VARCHAR2(64),
  account_mess     VARCHAR2(120) not null,
  bank_card        VARCHAR2(24) not null,
  create_tm        TIMESTAMP(6) default sysdate not null,
  isvalid          CHAR(1) default '0' not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255;
-- Add comments to the table 
comment on table CO_PAYMENT_FORM_HISTORY
  is '合家欢理赔历史表';  
-- Add comments to the columns 
comment on column CO_PAYMENT_FORM_HISTORY.pol_id
  is '表格主键';
comment on column CO_PAYMENT_FORM_HISTORY.pol_order
  is '保险订单号(唯一键)';
comment on column CO_PAYMENT_FORM_HISTORY.pol_no
  is '保单号(唯一键)';
comment on column CO_PAYMENT_FORM_HISTORY.prod_id
  is '险种代码';
comment on column CO_PAYMENT_FORM_HISTORY.acci_tm
  is '出险时间';
comment on column CO_PAYMENT_FORM_HISTORY.province
  is '省份';
comment on column CO_PAYMENT_FORM_HISTORY.city
  is '市';
comment on column CO_PAYMENT_FORM_HISTORY.county
  is '县';
comment on column CO_PAYMENT_FORM_HISTORY.acci_addr
  is '出险地点';
comment on column CO_PAYMENT_FORM_HISTORY.loss_amount
  is '估损金额';
comment on column CO_PAYMENT_FORM_HISTORY.linkman
  is '联系人';
comment on column CO_PAYMENT_FORM_HISTORY.mobile_phone
  is '手机号';
comment on column CO_PAYMENT_FORM_HISTORY.acci_cause
  is '出险原因';
comment on column CO_PAYMENT_FORM_HISTORY.acci_desc
  is '出险经过';
comment on column CO_PAYMENT_FORM_HISTORY.account_nam
  is '投保人户名';
comment on column CO_PAYMENT_FORM_HISTORY.account_bank_no
  is '投保人开户行序号';
comment on column CO_PAYMENT_FORM_HISTORY.account_bank_nam
  is '投保人开户行';
comment on column CO_PAYMENT_FORM_HISTORY.account_mess
  is '支行信息';
comment on column CO_PAYMENT_FORM_HISTORY.bank_card
  is '投保人账号';
comment on column CO_PAYMENT_FORM_HISTORY.create_tm
  is '创建时间';
comment on column CO_PAYMENT_FORM_HISTORY.isvalid
  is '是否有效(0-报案中,1-报案完成,2-撤单）';
-- Create/Recreate primary, unique and foreign key constraints 
alter table CO_PAYMENT_FORM_HISTORY
  add constraint PK_CO_PAYMENT_FORM_HISTORY primary key (POL_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;



 
-- Create table
create table CO_ATTR_IMG
(
  pol_id    VARCHAR2(32) not null,
  attr_id   number not null,
  acci_type CHAR(2) not null,
  acci_desc VARCHAR2(64) not null,
  img_nam   VARCHAR2(64),
  img_path  VARCHAR2(128) not null,
  create_tm TIMESTAMP(6) default sysdate not null,
  isvalid   CHAR(1) default '0' not null
)
;
-- Add comments to the table 
comment on table CO_ATTR_IMG
  is '合家图片表';
-- Add comments to the columns 
comment on column CO_ATTR_IMG.pol_id
  is '合家欢理赔表主键(联合主键)';
comment on column CO_ATTR_IMG.attr_id
  is 'sequcen(联合主键)';
comment on column CO_ATTR_IMG.acci_type
  is '理赔原因类型
';
comment on column CO_ATTR_IMG.acci_desc
  is '理赔原因描述
';
comment on column CO_ATTR_IMG.img_nam
  is '图片名称
';
comment on column CO_ATTR_IMG.img_path
  is '图片路径
';
comment on column CO_ATTR_IMG.create_tm
  is '创建时间
';
comment on column CO_ATTR_IMG.isvalid
  is '是否有效
';
-- Create/Recreate primary, unique and foreign key constraints 
alter table CO_ATTR_IMG
  add constraint PK_CO_ATTR_IMG primary key (POL_ID, ATTR_ID);
  
  
  
-- Create table
create table CO_ATTR_IMG_HISTORY
(
  pol_id    VARCHAR2(32) not null,
  attr_id   NUMBER not null,
  acci_type CHAR(2) not null,
  acci_desc VARCHAR2(64) not null,
  img_nam   VARCHAR2(64),
  img_path  VARCHAR2(128) not null,
  create_tm TIMESTAMP(6) default sysdate not null,
  isvalid   CHAR(1) default '0' not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255;
-- Add comments to the table 
comment on table CO_ATTR_IMG_HISTORY
  is '合家图片历史表';
-- Add comments to the columns 
comment on column CO_ATTR_IMG_HISTORY.pol_id
  is '合家欢理赔表主键(联合主键)';
comment on column CO_ATTR_IMG_HISTORY.attr_id
  is 'sequcen(联合主键)';
comment on column CO_ATTR_IMG_HISTORY.acci_type
  is '理赔原因类型
';
comment on column CO_ATTR_IMG_HISTORY.acci_desc
  is '理赔原因描述
';
comment on column CO_ATTR_IMG_HISTORY.img_nam
  is '图片名称
';
comment on column CO_ATTR_IMG_HISTORY.img_path
  is '图片路径
';
comment on column CO_ATTR_IMG_HISTORY.create_tm
  is '创建时间
';
comment on column CO_ATTR_IMG_HISTORY.isvalid
  is '是否有效
';
-- Create/Recreate primary, unique and foreign key constraints 
alter table CO_ATTR_IMG_HISTORY
  add constraint PK_CO_ATTR_IMG_HISTORY primary key (POL_ID, ATTR_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;
  
  
-- Add/modify columns 
alter table CO_PAYMENT_FORM modify acci_tm date;



-- Create sequence 
create sequence SEQ_ATTR_IMG_ATTR_ID
minvalue 1
maxvalue 999999999999999
start with 1
increment by 1
cache 20
order;



-- Create sequence 
create sequence SEQ_PAYMENT_FORM_POL_ID
minvalue 1
maxvalue 999999999999999
start with 1
increment by 1
cache 20
order;
  

-- Add/modify columns 
alter table CO_PAYMENT_FORM modify county null;

-- Add/modify columns 
alter table CO_PAYMENT_FORM_HISTORY modify county null;

-- Add/modify columns 
alter table CO_PAYMENT_FORM add user_nam VARCHAR2(64);
-- Add comments to the columns 
comment on column CO_PAYMENT_FORM.user_nam
  is '用户名';

-- Add/modify columns 
alter table CO_PAYMENT_FORM_HISTORY add user_nam VARCHAR2(64);
-- Add comments to the columns 
comment on column CO_PAYMENT_FORM_HISTORY.user_nam
  is '用户名';

  
  