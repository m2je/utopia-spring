-- Create table
create table CO_SETTINGS
(
  CO_SETTING_ID number(10) not null,
  Key           varchar2(500) not null,
  value         varchar2(3000) not null,
  CM_SYSTEM_ID  NUMBER(10) not null,
  Description	clob
)
;
-- Create/Recreate primary, unique and foreign key constraints 
alter table CO_SETTINGS
  add constraint PK_CO_SETTING_ID primary key (CO_SETTING_ID);
alter table CO_SETTINGS
  add constraint UN_PK_CO_SETTING_KEY unique (KEY);
alter table CO_SETTINGS
  add constraint FK_CO_SETTING_SYSTEM foreign key (CM_SYSTEM_ID)
  references common.cm_system (CM_SYSTEM_ID);