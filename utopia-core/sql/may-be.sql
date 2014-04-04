  ----------------------------- CO_ACTION_LOG -----------------------------------
create table CO_ACTION_LOG
(
  CO_ACTION_LOG_ID     BIGINT not null,
  LOGGER               TINYINT(1) not null,
  START_TIME           DATETIME default now() not null,
  END_TIME             DATETIME,
  STATUS               INT default 0 not null,
  CO_USECASE_ACTION_ID BIGINT not null
);

alter table CO_ACTION_LOG
  add constraint PK_CO_ACTION_LOG primary key (CO_ACTION_LOG_ID);

  
alter table CO_ACTION_LOG
  add constraint FK_CO_ACTION_LOG_ACT_ID foreign key (CO_USECASE_ACTION_ID)
  references CO_USECASE_ACTION (CO_USECASE_ACTION_ID) on delete cascade;