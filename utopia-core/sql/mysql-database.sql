create schema core;
CREATE USER core IDENTIFIED BY 'core';
GRANT ALL PRIVILEGES ON core.* TO 'core'@'localhost' WITH GRANT OPTION;
use core;
/*----------------------------- CO_ACTION -----------------------------------*/
create table CO_ACTION
(
  CO_ACTION_ID BIGINT not null,
  CREATED      DATE,
  CREATEDBY    BIGINT,
  UPDATED      DATE,
  UPDATEDBY    BIGINT,
  NAME         VARCHAR(50),
  METHODNAME   VARCHAR(200),
  DELETED      BIT default 0
);
alter table CO_ACTION
  add constraint PK_CO_ACTION primary key (CO_ACTION_ID); 
  
/*----------------------------- CO_APPLICATION -----------------------------------*/
create table CO_APPLICATION
(
  CO_APPLICATION_ID BIGINT not null,
  NAME              VARCHAR(200) not null,
  SECRET_KEY        VARCHAR(3000) not null,
  CREATED           DATETIME default now() not null,
  UPDATED           DATETIME default now() not null,
  CREATEDBY         BIGINT not null,
  UPDATEDBY         BIGINT not null,
  TOKEN_VALIDITY    BIGINT not null,
  DELETED           BIT default 0,
  SCOPE             VARCHAR(2000),
  REDIRECT_URL      VARCHAR(3000)
);
alter table CO_APPLICATION
  add constraint PK_CO_APPLICATION primary key (CO_APPLICATION_ID);
alter table CO_APPLICATION
  add constraint UN_CO_APPLICATION_NAME unique (NAME);

/*----------------------------- CO_APP_REFRESH_TOKEN -----------------------------------*/  
 create table CO_APP_REFRESH_TOKEN
(
  CO_APP_REFRESH_TOKEN_ID BIGINT not null,
  REFRESH_TOKEN           VARCHAR(200) not null,
  CO_USER_ID              BIGINT not null,
  CO_APPLICATION_ID       BIGINT not null,
  AUTHENTICATION          BLOB not null
);
alter table CO_APP_REFRESH_TOKEN
  add constraint PK_CO_APP_REFRESH_TOKEN_ID primary key (CO_APP_REFRESH_TOKEN_ID);
alter table CO_APP_REFRESH_TOKEN
  add constraint UN_CO_APP_REFRESH_TOKEN unique (REFRESH_TOKEN);
alter table CO_APP_REFRESH_TOKEN
  add constraint FK_CO_APP_REFRESH_TOKEN_APP foreign key (CO_APPLICATION_ID)
  references CO_APPLICATION (CO_APPLICATION_ID); 
  /*----------------------------- CO_APP_USCS_ACCSS -----------------------------------*/
  create table CO_APP_USCS_ACCSS
(
  CO_APP_USCS_ACCSS_ID BIGINT not null,
  CO_APPLICATION_ID    BIGINT not null,
  CO_USECASE_ID        BIGINT,
  CO_USECASE_ACTION_ID BIGINT
);

alter table CO_APP_USCS_ACCSS
  add constraint PK_APP_USCS_ACCSS primary key (CO_APP_USCS_ACCSS_ID);
alter table CO_APP_USCS_ACCSS
  add constraint UN_CO_APP_USCS_ACCSS unique (CO_USECASE_ID, CO_APPLICATION_ID);

  /*----------------------------- CO_ATTACHMENT -----------------------------------*/
  create table CO_ATTACHMENT
(
  CO_ATTACHMENT_ID     BIGINT not null,
  CO_USECASE_ID        BIGINT not null,
  CO_USECASE_ACTION_ID BIGINT,
  RECORD_ID            BIGINT not null,
  ATTACH_FILE          BLOB,
  FILE_NAME            VARCHAR(2000) not null
);
alter table CO_ATTACHMENT
  add constraint PK_CO_ATTACHMENT primary key (CO_ATTACHMENT_ID);
/*----------------------------- CO_MENU -----------------------------------*/
  create table CO_MENU
(
  CO_MENU_ID           BIGINT not null,
  CREATED              DATE not null,
  CREATEDBY            BIGINT not null,
  UPDATED              DATE not null,
  UPDATEDBY            BIGINT not null,
  NAME                 VARCHAR(50) not null,
  CO_USECASE_ACTION_ID BIGINT,
  PARENT_MENU_ID       BIGINT,
  ICON                 VARCHAR(2000),
  CM_SUBSYSTEM_ID      BIGINT,
  PRECEDENCE           INT,
  DIRECT_URL           VARCHAR(2000),
  LINK_TARGET          TINYINT default 1,
  MENU_TYPE            TINYINT default 0 not null,
  DELETED              BIT default 0
);
alter table CO_MENU
  add constraint PK_CO_MENU primary key (CO_MENU_ID);
alter table CO_MENU
  add constraint FK_CO_MENU_PARENT_MENU foreign key (PARENT_MENU_ID)
  references CO_MENU (CO_MENU_ID) ;
  /*----------------------------- CO_PORTAL -----------------------------------*/
  create table CO_PORTAL
(
  CO_PORTAL_ID BIGINT not null,
  DELETED      BIT default 0 not null,
  CREATED      DATETIME default NOW() not null,
  CREATEDBY    BIGINT not null,
  UPDATED      DATETIME default NOW() not null,
  UPDATEDBY    BIGINT not null,
  NAME         VARCHAR(300) not null,
  DOMAIN_NAME  VARCHAR(500) not null
);

alter table CO_PORTAL
  add constraint PK_CO_PORTAL_ID primary key (CO_PORTAL_ID);
alter table CO_PORTAL
  add constraint UN_CO_PORTAL_DOMAIN unique (DOMAIN_NAME);
alter table CO_PORTAL
  add constraint UN_CO_PORTAL_NAME unique (NAME);
  /*----------------------------- CO_PORTAL_SYS_ACCSS -----------------------------------*/
  create table CO_PORTAL_SYS_ACCSS
(
  CO_PORTAL_SYS_ACCSS_ID BIGINT not null,
  CM_SYSTEM_ID           BIGINT not null,
  CM_SUBSYSTEM_ID        BIGINT,
  CO_PORTAL_ID           BIGINT not null
);

alter table CO_PORTAL_SYS_ACCSS
  add constraint PK_CO_PORTAL_SYS_ACCSS_ID primary key (CO_PORTAL_SYS_ACCSS_ID);
alter table CO_PORTAL_SYS_ACCSS
  add constraint UN_CO_PORTAL_SYS_ACCSS unique (CO_PORTAL_ID, CM_SYSTEM_ID, CM_SUBSYSTEM_ID);
  
/*----------------------------- CO_REVISION -----------------------------------*/
  create table CO_REVISION
(
  CO_REVISION_ID    BIGINT not null,
  CO_USECASE_ID     BIGINT not null,
  RECORD_ID         BIGINT not null,
  CREATEDBY         BIGINT not null,
  CREATED           DATETIME default now() not null,
  DESCRIPTION       VARCHAR(3000),
  SERIALIZED_OBJECT LONGTEXT not null
);


alter table CO_REVISION
  add constraint PK_CO_REVISION_ID primary key (CO_REVISION_ID);
  
/*----------------------------- CO_ROLE -----------------------------------*/
  create table CO_ROLE
(
  CO_ROLE_ID BIGINT not null,
  NAME       VARCHAR(200) not null,
  CREATED    DATETIME default NOW() not null,
  CREATEDBY  BIGINT not null,
  UPDATEDBY  BIGINT not null,
  UPDATED    DATETIME default NOW() not null,
  DELETED    BIT default 0
);

alter table CO_ROLE
  add constraint PK_CO_ROLE primary key (CO_ROLE_ID);
alter table CO_ROLE
  add constraint UN_CO_ROLE_NAME unique (NAME);

/*----------------------------- CO_ROLE_ORGANIZATION_ACSS -----------------------------------*/
  create table CO_ROLE_ORGANIZATION_ACSS
(
  CO_ROLE_ORGANIZATION_ACSS_ID BIGINT not null,
  CM_ORGANIZATION_ID           BIGINT not null,
  CREATED                      DATETIME default NOW() not null,
  CREATEDBY                    BIGINT not null,
  UPDATED                      DATETIME default NOW() not null,
  UPDATEDBY                    BIGINT not null,
  CO_ROLE_ID                   BIGINT not null
);
alter table CO_ROLE_ORGANIZATION_ACSS
  add constraint PK_CO_ROLE_ORGNZTION_ACSS_ID primary key (CO_ROLE_ORGANIZATION_ACSS_ID);
alter table CO_ROLE_ORGANIZATION_ACSS
  add constraint UN_CO_ROLE_ORG_ACSS unique (CO_ROLE_ID, CM_ORGANIZATION_ID);

/*----------------------------- CO_ROLE_SUBSYSTEM_ACSS -----------------------------------*/
  create table CO_ROLE_SUBSYSTEM_ACSS
(
  CO_ROLE_ID                BIGINT not null,
  CO_ROLE_SUBSYSTEM_ACSS_ID BIGINT not null,
  CREATED                   DATETIME default NOW() not null,
  CREATEDBY                 BIGINT not null,
  UPDATEDBY                 BIGINT not null,
  UPDATED                   DATETIME default NOW() not null,
  CM_SUBSYSTEM_ID           BIGINT not null
);

alter table CO_ROLE_SUBSYSTEM_ACSS
  add constraint PK_CO_ROLE_SUBSYSTEM_ACSS primary key (CO_ROLE_SUBSYSTEM_ACSS_ID);
alter table CO_ROLE_SUBSYSTEM_ACSS
  add constraint UN_CO_ROLE_SUBSYSTEM_RL_SUB unique (CO_ROLE_ID, CM_SUBSYSTEM_ID);
alter table CO_ROLE_SUBSYSTEM_ACSS
  add constraint FK_ROLE_SUBSYSTEM_ACSS_ROLE foreign key (CO_ROLE_ID)
  references CO_ROLE (CO_ROLE_ID);
/*----------------------------- CO_ROLE_USCS_ACTN_ACCS -----------------------------------*/
  create table CO_ROLE_USCS_ACTN_ACCS
(
  CO_ROLE_USCS_ACTN_ACCS_ID BIGINT not null,
  CREATED                   DATETIME DEFAULT NOW() not null,
  CREATEDBY                 BIGINT not null,
  UPDATED                   DATETIME DEFAULT NOW() not null,
  UPDATEDBY                 BIGINT not null,
  CO_USECASE_ACTION_ID      BIGINT not null,
  CO_ROLE_ID                BIGINT not null
);

alter table CO_ROLE_USCS_ACTN_ACCS
  add constraint PK_CO_ROLE_USCS_ACTN_ACCS primary key (CO_ROLE_USCS_ACTN_ACCS_ID);
alter table CO_ROLE_USCS_ACTN_ACCS
  add constraint UN_CO_ROLE_USCS_ACTN_ACCS_RL unique (CO_ROLE_ID, CO_USECASE_ACTION_ID);

alter table CO_ROLE_USCS_ACTN_ACCS
  add constraint FK_ROLE_USCS_ACTN_ACCS_ROLE foreign key (CO_ROLE_ID)
  references CO_ROLE (CO_ROLE_ID);
  
/*----------------------------- CO_ROLE_USECASE_ACSS -----------------------------------*/
  create table CO_ROLE_USECASE_ACSS
(
  CO_ROLE_USECASE_ACSS_ID BIGINT not null,
  CREATED                 DATETIME DEFAULT NOW() not null,
  CREATEDBY               BIGINT not null,
  UPDATED                 DATETIME DEFAULT NOW() not null,
  UPDATEDBY               BIGINT not null,
  CO_USECASE_ID           BIGINT not null,
  CO_ROLE_ID              BIGINT not null
);
alter table CO_ROLE_USECASE_ACSS
  add constraint PK_CO_USECASE_ROLE_ACSS primary key (CO_ROLE_USECASE_ACSS_ID);
alter table CO_ROLE_USECASE_ACSS
  add constraint UN_CO_USECASE_ROLE_ACSS_RL unique (CO_ROLE_ID, CO_USECASE_ID);
alter table CO_ROLE_USECASE_ACSS
  add constraint FK_CO_ROLE_USCS_ACCS foreign key (CO_ROLE_ID)
  references CO_ROLE (CO_ROLE_ID) ;
  
/*----------------------------- CO_SEQUENCE -----------------------------------*/
create table CO_SEQUENCE
(
  CO_SEQUENCE_ID  BIGINT not null,
  TABLENAME       VARCHAR(50) not null,
  CREATED         DATETIME DEFAULT NOW() not null,
  CREATEDBY       BIGINT not null,
  UPDATED         DATETIME DEFAULT NOW() not null,
  UPDATEDBY       BIGINT not null,
  CM_SUBSYSTEM_ID BIGINT not null,
  CURRENTID       BIGINT not null,
  DELETED         BIT default 0
);

alter table CO_SEQUENCE
  add constraint PK_CO_SEQUENCE primary key (CO_SEQUENCE_ID);
alter table CO_SEQUENCE
  add constraint UN_CO_SEQUNCE_TABLENAME unique (TABLENAME);

/*----------------------------- CO_SETTINGS -----------------------------------*/
  create table CO_SETTINGS
(
  CO_SETTING_ID BIGINT not null,
  K           VARCHAR(500) not null,
  V         VARCHAR(3000) not null,
  CM_SYSTEM_ID  BIGINT not null,
  DESCRIPTION   TEXT not null
);
alter table CO_SETTINGS
  add constraint PK_CO_SETTING_ID primary key (CO_SETTING_ID);
alter table CO_SETTINGS
  add constraint UN_CO_SETTING_KEY unique (K);
  
/*----------------------------- CO_USECASE -----------------------------------*/
  create table CO_USECASE
(
  CO_USECASE_ID     BIGINT not null,
  NAME              VARCHAR(50),
  CREATED           DATETIME DEFAULT NOW() NOT NULL,
  CREATEDBY         BIGINT,
  UPDATED           DATETIME DEFAULT NOW() NOT NULL,
  UPDATEDBY         BIGINT,
  CM_SUBSYSTEM_ID   BIGINT not null,
  DELETED           BIT default 0
);

alter table CO_USECASE
  add constraint PK_CO_USECASE primary key (CO_USECASE_ID);
alter table CO_USECASE
  add constraint UN_CO_USECASE_NAME unique (NAME, CM_SUBSYSTEM_ID);

/*----------------------------- CO_USECASE_ACTION -----------------------------------*/
  create table CO_USECASE_ACTION
(
  CO_USECASE_ID        BIGINT not null,
  CO_USECASE_ACTION_ID BIGINT not null,
  CO_ACTION_ID         BIGINT not null,
  CREATED              DATETIME DEFAULT NOW() not null,
  CREATEDBY            BIGINT not null,
  UPDATED              DATETIME DEFAULT NOW() not null,
  UPDATEDBY            BIGINT not null,
  DELETED              BIT default 0
);
alter table CO_USECASE_ACTION
  add constraint PK_CO_USECASE_ACTION primary key (CO_USECASE_ACTION_ID);
alter table CO_USECASE_ACTION
  add constraint UN_CO_USCS_ACTION unique (CO_ACTION_ID, CO_USECASE_ID);
alter table CO_USECASE_ACTION
  add constraint FK_CO_USECASE_ACTION_CO_ACTION foreign key (CO_ACTION_ID)
  references CO_ACTION (CO_ACTION_ID) ;
alter table CO_USECASE_ACTION
  add constraint FK_CO_USE_CASE_ACT_CO_USCS_ID foreign key (CO_USECASE_ID)
  references CO_USECASE (CO_USECASE_ID) ;

  
/*----------------------------- CO_USER -----------------------------------*/
create table CO_USER
(
  CO_USER_ID         BIGINT not null,
  USERNAME           VARCHAR(200) not null,
  PASSWORD           VARCHAR(200) not null,
  CREATED            DATETIME default NOW() not null,
  CREATEDBY          BIGINT not null,
  UPDATED            DATETIME default NOW() not null,
  UPDATEDBY          BIGINT not null,
  USER_IMAGE         BLOB,
  CM_BPARTNER_ID     BIGINT not null,
  CM_ORGANIZATION_ID BIGINT,
  DELETED            BIT default 0,
  CO_PORTAL_ID       BIGINT not null
);

alter table CO_USER
  add constraint PK_CO_USER primary key (CO_USER_ID);
alter table CO_USER
  add constraint UN_CO_USER_BPARTNER unique (CM_BPARTNER_ID);
alter table CO_USER
  add constraint UN_CO_USER_USERNAME unique (USERNAME, CO_PORTAL_ID);
alter table CO_USER
  add constraint FK_CO_USER_PORTAL_ID foreign key (CO_PORTAL_ID)
  references CO_PORTAL (CO_PORTAL_ID);
 
alter table CO_USER
  add constraint CH_CO_USER_USERNAME
  check (length(username)>4);

/*----------------------------- CO_USER_APP_TOKEN -----------------------------------*/
  create table CO_USER_APP_TOKEN
(
  CO_USER_APP_TOKEN_ID BIGINT not null,
  CO_USER_ID           BIGINT not null,
  CO_APPLICATION_ID    BIGINT not null,
  TOKEN                VARCHAR(200) not null,
  VALID_TO             DATE not null,
  CREATED              DATETIME default NOW() not null,
  UPDATED              DATETIME default NOW() not null,
  REFRESH_TOKEN        VARCHAR(200) not null,
  AUTHENTICATION       BLOB not null
);

alter table CO_USER_APP_TOKEN
  add constraint PK_CO_USER_APP_TOKEN primary key (CO_USER_APP_TOKEN_ID);
alter table CO_USER_APP_TOKEN
  add constraint UN_CO_USER_APP_TOKEN unique (TOKEN);
alter table CO_USER_APP_TOKEN
  add constraint UN_CO_USER_APP_TOKEN_REF unique (REFRESH_TOKEN);
alter table CO_USER_APP_TOKEN
  add constraint UN_CO_USR_APP_TKN_TOKEN unique (TOKEN, VALID_TO);
alter table CO_USER_APP_TOKEN
  add constraint FK_CO_USER_APP_TOKEN_APP foreign key (CO_APPLICATION_ID)
  references CO_APPLICATION (CO_APPLICATION_ID) on delete cascade;
alter table CO_USER_APP_TOKEN
  add constraint FK_CO_USER_APP_TOKEN_USER foreign key (CO_USER_ID)
  references CO_USER (CO_USER_ID) on delete cascade;
/*----------------------------- CO_USER_LOG -----------------------------------*/
  create table CO_USER_LOG
(
  CO_USER_LOG_ID BIGINT not null,
  CO_USER_APP_TOKEN_ID  BIGINT not null,
  LOGIN_DATE     DATETIME default NOW() not null,
  LOG_OUT_DATE   DATE,
  DESCRIPTION    TEXT,
  CLIENT_ADDRESS VARCHAR(200)
);

alter table CO_USER_LOG
  add constraint PK_CO_USER_LOG_ID primary key (CO_USER_LOG_ID);
alter table CO_USER_LOG
  add constraint FK_CO_USER_LOG_APP_TOKEN_ID foreign key (CO_USER_APP_TOKEN_ID)
  references CO_USER_APP_TOKEN (CO_USER_APP_TOKEN_ID) ;
/*----------------------------- CO_USER_LOG_DTL -----------------------------------*/
  create table CO_USER_LOG_DTL
(
  CO_USER_LOG_DTL_ID   BIGINT not null,
  CO_USER_LOG_ID       BIGINT not null,
  CO_USECASE_ACTION_ID BIGINT,
  ACTION_NAME          VARCHAR(100),
  STATUS               TINYINT default 1 not null,
  ACTION_DATE          DATETIME default NOW() not null
);

alter table CO_USER_LOG_DTL
  add constraint PK_CO_USER_LOG_DTL_ID primary key (CO_USER_LOG_DTL_ID);
alter table CO_USER_LOG_DTL
  add constraint FK_CO_USER_LOG_LOG_ID foreign key (CO_USER_LOG_ID)
  references CO_USER_LOG (CO_USER_LOG_ID) on delete cascade;
alter table CO_USER_LOG_DTL
  add constraint FK_CO_USER_LOG_USACT_ID foreign key (CO_USECASE_ACTION_ID)
  references CO_USECASE_ACTION (CO_USECASE_ACTION_ID) on delete cascade;

/*----------------------------- CO_USER_ORGANIZATION_ACSS -----------------------------------*/
create table CO_USER_ORGANIZATION_ACSS
(
  CO_USER_ORGANIZATION_ACSS_ID BIGINT not null,
  CM_ORGANIZATION_ID           BIGINT not null,
  CREATED                      DATETIME default NOW() not null,
  CREATEDBY                    BIGINT not null,
  UPDATED                      DATETIME default NOW() not null,
  UPDATEDBY                    BIGINT not null,
  CO_USER_ID                   BIGINT not null
);
alter table CO_USER_ORGANIZATION_ACSS
  add constraint PK_CO_USER_ORGNZTION_ACSS_ID primary key (CO_USER_ORGANIZATION_ACSS_ID);
alter table CO_USER_ORGANIZATION_ACSS
  add constraint UN_CO_USER_ORG_ACSS unique (CO_USER_ID, CM_ORGANIZATION_ID);
alter table CO_USER_ORGANIZATION_ACSS
  add constraint FK_CO_USER_ORG_ACSS_USER_ID foreign key (CO_USER_ID)
  references CO_USER (CO_USER_ID) ;
/*----------------------------- CO_USER_ROLES -----------------------------------*/  
create table CO_USER_ROLES
(
  CO_USER_ROLES_ID BIGINT not null,
  CREATED          DATETIME default NOW() not null,
  CREATEDBY        BIGINT not null,
  UPDATED          DATETIME default NOW() not null,
  UPDATEDBY        BIGINT not null,
  CO_USER_ID       BIGINT not null,
  CO_ROLE_ID       BIGINT not null
);
alter table CO_USER_ROLES
  add constraint PK_CS_USER_ROLES3 primary key (CO_USER_ROLES_ID);
alter table CO_USER_ROLES
  add constraint UN_CO_USER_ROLE unique (CO_USER_ID, CO_ROLE_ID);
alter table CO_USER_ROLES
  add constraint FK_CO_USER_ROLE_ROLE foreign key (CO_ROLE_ID)
  references CO_ROLE (CO_ROLE_ID) on delete cascade;
alter table CO_USER_ROLES
  add constraint FK_CO_USER_ROLE_USER foreign key (CO_USER_ID)
  references CO_USER (CO_USER_ID) on delete cascade;
/*----------------------------- CO_USER_USECASE_ACSS -----------------------------------*/  
create table CO_USER_USECASE_ACSS
(
  CO_USER_USECASE_ACSS_ID BIGINT not null,
  CREATED                 DATETIME DEFAULT NOW() not null,
  CREATEDBY               BIGINT not null,
  UPDATED                 DATETIME DEFAULT NOW() not null,
  UPDATEDBY               BIGINT not null,
  CO_USECASE_ID           BIGINT not null,
  CO_USER_ID              BIGINT not null
);

alter table CO_USER_USECASE_ACSS
  add constraint PK_CO_USECASE_USER primary key (CO_USER_USECASE_ACSS_ID);
alter table CO_USER_USECASE_ACSS
  add constraint UN_CO_USR_USCAS_USER_USC unique (CO_USER_ID, CO_USECASE_ID);
alter table CO_USER_USECASE_ACSS
  add constraint FK_CO_USECASE_USER_USECASE_ID foreign key (CO_USECASE_ID)
  references CO_USECASE (CO_USECASE_ID) on delete cascade;
alter table CO_USER_USECASE_ACSS
  add constraint FK_CO_USR_USCAS_ACSS_CO_USR foreign key (CO_USER_ID)
  references CO_USER (CO_USER_ID) on delete cascade;
/*----------------------------- CO_USR_USCS_ACTN_ACCS -----------------------------------*/
  
  create table CO_USR_USCS_ACTN_ACCS
(
  CO_USR_USCS_ACTN_ACCS_ID BIGINT not null,
  CREATED                  DATETIME DEFAULT NOW() NOT NULL,
  CREATEDBY                BIGINT,
  UPDATED                  DATETIME DEFAULT NOW() NOT NULL,
  UPDATEDBY                BIGINT,
  CO_USER_ID               BIGINT not null,
  CO_USECASE_ACTION_ID     BIGINT not null
);
alter table CO_USR_USCS_ACTN_ACCS
  add constraint PK_CO_USR_USCS_ACTN primary key (CO_USR_USCS_ACTN_ACCS_ID);
alter table CO_USR_USCS_ACTN_ACCS
  add constraint UN_USR_USCS_ACTN unique (CO_USER_ID, CO_USECASE_ACTION_ID);
alter table CO_USR_USCS_ACTN_ACCS
  add constraint FK_USR_USCS_ACTN_ACCS_USER foreign key (CO_USER_ID)
  references CO_USER (CO_USER_ID);
alter table CO_USR_USCS_ACTN_ACCS
  add constraint FK_USR_USCS_ATN_ACCS_USCS_ACTN foreign key (CO_USECASE_ACTION_ID)
  references CO_USECASE_ACTION (CO_USECASE_ACTION_ID) ;

/*----------------------------- CM_BANK -----------------------------------*/
create table CM_BANK
(
  CM_BANK_ID   BIGINT not null,
  CREATED      DATETIME default NOW() not null,
  CREATEDBY    BIGINT not null,
  UPDATED      DATETIME default NOW() not null,
  UPDATEDBY    BIGINT not null,
  CODE         VARCHAR(10),
  NAME         VARCHAR(50),
  LATINNAME    VARCHAR(50),
  DESCRIPTIONS TEXT,
  DELETED      BIT default 0
);
alter table CM_BANK
  add constraint PK_CM_BANK primary key (CM_BANK_ID);
  
/*----------------------------- CM_BPARTNER -----------------------------------*/  
  create table CM_BPARTNER
(
  CREATED        DATETIME default NOW() not null,
  CREATEDBY      BIGINT not null,
  CODE           VARCHAR(10),
  CM_BPARTNER_ID BIGINT not null,
  NAME           VARCHAR(200) not null,
  SECOUND_NAME   VARCHAR(200) not null,
  UPDATED        DATETIME default NOW() not null,
  UPDATEDBY      BIGINT not null,
  ADDERSS        BIGINT,
  EMAILADDRESS   VARCHAR(4000),
  PERSONTYPE     TINYINT,
  DELETED        BIT default 0
);
alter table CM_BPARTNER
  add constraint PK_CM_BPARTNER4 primary key (CM_BPARTNER_ID);

/*----------------------------- CM_BANK_BRANCH -----------------------------------*/
  create table CM_BANK_BRANCH
(
  CM_BANK_BRANCH_ID BIGINT not null,
  CREATED           DATETIME default NOW() not null,
  CREATEDBY         BIGINT not null,
  UPDATED           DATETIME default NOW() not null,
  UPDATEDBY         BIGINT not null,
  CODE              VARCHAR(10),
  NAME              VARCHAR(50),
  LATINNAME         VARCHAR(50),
  DESCRIPTIONS      TEXT,
  CM_BANK_ID        BIGINT,
  CM_PROVINCE_ID    BIGINT,
  TELEPHONE         VARCHAR(20),
  ADDRESS           VARCHAR(4000),
  DELETED           TINYINT default 0
);
alter table CM_BANK_BRANCH
  add constraint PK_CM_BANK_BRANCH primary key (CM_BANK_BRANCH_ID);
alter table CM_BANK_BRANCH
  add constraint FK_CM_BANK foreign key (CM_BANK_ID)
  references CM_BANK (CM_BANK_ID);
/*----------------------------- CM_CITY -----------------------------------*/
create table CM_CITY
(
  CM_CITY_ID    BIGINT not null,
  CREATED       DATETIME default NOW() not null,
  CREATEDBY     BIGINT not null,
  UPDATED       DATETIME default NOW() not null,
  UPDATEDBY     BIGINT not null,
  NAME          VARCHAR(50) not null,
  AREACODE      VARCHAR(10),
  CM_COUNTRY_ID BIGINT not null,
  CM_REGION_ID  BIGINT,
  CODE          VARCHAR(10),
  DESCRIPTION   TEXT,
  DELETED       BIT default 0
);
alter table CM_CITY
  add constraint PK_CM_CITY primary key (CM_CITY_ID);

/*----------------------------- CM_COMPANY_BPARTNER -----------------------------------*/ 
  create table CM_COMPANY_BPARTNER
(
  CM_COMPANY_BPARTNER_ID BIGINT not null,
  CREATED                DATETIME default NOW() not null,
  CREATEDBY              BIGINT default 1 not null,
  UPDATED                DATETIME default NOW() not null,
  UPDATEDBY              BIGINT default 1 not null,
  CM_BPARTNER_ID         BIGINT,
  WEBSITE                VARCHAR(200),
  PHONENO                VARCHAR(20),
  ESTABLISHED_DATE       DATE,
  ESTABLISHED_CODE       VARCHAR(20),
  ZIP_CODE               VARCHAR(10),
  DESCRIPTION            TEXT,
  PARENT_COMPANY         BIGINT,
  CM_PERSON_BPARTNER_ID  BIGINT,
  DELETED                BIT default 0
);
alter table CM_COMPANY_BPARTNER
  add constraint PK_CM_COMPANY_BPARTNER primary key (CM_COMPANY_BPARTNER_ID);
alter table CM_COMPANY_BPARTNER
  add constraint FK_CM_COMPANY_PARENT foreign key (PARENT_COMPANY)
  references CM_COMPANY_BPARTNER (CM_COMPANY_BPARTNER_ID);
alter table CM_COMPANY_BPARTNER
  add constraint FK_CM_COMP_BPART_CM_BPARTNER foreign key (CM_BPARTNER_ID)
  references CM_BPARTNER (CM_BPARTNER_ID);
/*----------------------------- CM_COUNTRY -----------------------------------*/
  create table CM_COUNTRY
(
  CM_COUNTRY_ID  BIGINT not null,
  CREATED        DATETIME default NOW() not null,
  CREATEDBY      BIGINT not null,
  UPDATED        DATETIME default NOW() not null,
  UPDATEDBY      BIGINT not null,
  NAME           VARCHAR(60) not null,
  DESCRIPTION    VARCHAR(255),
  CM_CURRENCY_ID BIGINT,
  CODE           VARCHAR(10),
  DELETED        BIT default 0
);

alter table CM_COUNTRY
  add constraint PK_CM_COUNTRY primary key (CM_COUNTRY_ID);
/*----------------------------- CM_COUNTRY -----------------------------------*/
create table CM_CURRENCY
(
  CM_CURRENCY_ID BIGINT not null,
  CREATED        DATETIME default NOW() not null,
  CREATEDBY      BIGINT not null,
  UPDATED        DATETIME default NOW() not null,
  UPDATEDBY      BIGINT not null,
  DESCRIPTION    TEXT not null,
  CODE           CHAR(3) not null,
  SYMBOL         VARCHAR(50),
  NAME           VARCHAR(50),
  DELETED        BIT default 0
);

alter table CM_CURRENCY
  add constraint PK_CM_CURRENCY primary key (CM_CURRENCY_ID);
/*----------------------------- CM_CUSTOMER -----------------------------------*/
  create table CM_CUSTOMER
(
  CM_CUSTOMER_ID BIGINT not null,
  CREATED        DATETIME default NOW() not null,
  UPDATED        DATETIME default NOW() not null,
  UPDATEDBY      BIGINT not null,
  CREATEDBY      BIGINT not null,
  CM_BPARTNER_ID BIGINT not null,
  DELETED        BIT default 0
);

alter table CM_CUSTOMER
  add constraint PK_CM_CUSTOMER primary key (CM_CUSTOMER_ID);
alter table CM_CUSTOMER
  add constraint FK_CM_CUSTOMER_BPARTNER_ID foreign key (CM_BPARTNER_ID)
  references CM_BPARTNER (CM_BPARTNER_ID) on delete cascade;

/*----------------------------- CM_DOCTYPE -----------------------------------*/
  create table CM_DOCTYPE
(
  CM_DOCTYPE_ID        BIGINT not null,
  NAME                 VARCHAR(200),
  CO_USECASE_ACTION_ID BIGINT,
  CM_FISCALYEAR_ID     BIGINT,
  CODE                 VARCHAR(20),
  CREATEDBY            BIGINT not null,
  UPDATED              DATETIME DEFAULT NOW() not null,
  UPDATEDBY            BIGINT not null,
  CREATED              DATETIME DEFAULT NOW() not null,
  CO_USECASE_ID        BIGINT not null,
  DELETED              BIT default 0
);
alter table CM_DOCTYPE
  add constraint PK_CM_DOCTYPE primary key (CM_DOCTYPE_ID);
alter table CM_DOCTYPE
  add constraint UN_CM_DOCTYPE_USC_ID unique (CO_USECASE_ID, CO_USECASE_ACTION_ID, CM_FISCALYEAR_ID);
alter table CM_DOCTYPE
  add constraint CM_DOC_USECASRE_ACTION_ID foreign key (CO_USECASE_ACTION_ID)
  references CO_USECASE_ACTION (CO_USECASE_ACTION_ID);
alter table CM_DOCTYPE
  add constraint FK_CM_DOC_USECASE_ID foreign key (CO_USECASE_ID)
  references CO_USECASE (CO_USECASE_ID) ;
/*----------------------------- CM_DOCTYPE_DIMENSION -----------------------------------*/
  create table CM_DOCTYPE_DIMENSION
(
  CM_DOCTYPE_DIMENSION_ID BIGINT not null,
  CM_DOCTYPE_ID           BIGINT not null,
  CM_SYSTEM_DIMENSION_ID  BIGINT not null,
  CREATEDBY               BIGINT not null,
  UPDATED                 DATETIME default NOW() not null,
  UPDATEDBY               BIGINT not null,
  CREATED                 DATETIME default NOW() not null,
  DELETED                 BIT default 0
);
alter table CM_DOCTYPE_DIMENSION
  add constraint PK_CM_DOCTYPE_DIMENSION primary key (CM_DOCTYPE_DIMENSION_ID);
alter table CM_DOCTYPE_DIMENSION
  add constraint UN_CM_DOCTYPE_DIM_ELEM unique (CM_DOCTYPE_ID, CM_SYSTEM_DIMENSION_ID);
alter table CM_DOCTYPE_DIMENSION
  add constraint FK_CM_DOCTYPE_DIM_CM_DOCTYPE foreign key (CM_DOCTYPE_ID)
  references CM_DOCTYPE (CM_DOCTYPE_ID);
alter table CM_DOCTYPE_DIMENSION
  add constraint FK_CM_DOCTYPE_DIM_CM_SYS_DIM foreign key (CM_SYSTEM_DIMENSION_ID)
  references CM_DOCTYPE_DIMENSION (CM_DOCTYPE_DIMENSION_ID);

/*----------------------------- CM_DOCTYPE_DIMENSION -----------------------------------*/
  create table CM_DOC_STATUS
(
  CM_DOC_STATUS_ID BIGINT not null,
  STATUS_NAME      VARCHAR(50) not null,
  CM_DOCTYPE_ID    BIGINT not null,
  CREATEDBY        BIGINT not null,
  CREATED          DATETIME default NOW() not null,
  UPDATEDBY        BIGINT not null,
  UPDATED          DATETIME default NOW() not null,
  CM_FISCALYEAR_ID BIGINT,
  STATUS           TINYINT default 0 not null,
  LOCK_ABLE        BIT default 0 not null,
  SKIP_ABLE        BIT default 0 not null,
  DELETED          BIT default 0
);

alter table CM_DOC_STATUS
  add constraint PK_CM_DOC_STATUS primary key (CM_DOC_STATUS_ID);
alter table CM_DOC_STATUS
  add constraint UN_CM_DOC_STATUS_NAME unique (CM_DOCTYPE_ID, STATUS_NAME, CM_FISCALYEAR_ID);
alter table CM_DOC_STATUS
  add constraint FK_CM_DOC_STATUS_CM_DOCTYPE foreign key (CM_DOCTYPE_ID)
  references CM_DOCTYPE (CM_DOCTYPE_ID);
/*----------------------------- CM_EMPLOYEE -----------------------------------*/
create table CM_EMPLOYEE
(
  CM_EMPLOYEE_ID        BIGINT not null,
  CREATED               DATETIME default NOW() not null,
  CREATEDBY             BIGINT not null,
  UPDATED               DATETIME default NOW() not null,
  UPDATEDBY             BIGINT not null,
  CM_PERSON_BPARTNER_ID BIGINT,
  CM_ORGANIZATION_ID    BIGINT,
  CM_JOBTITLE_ID        BIGINT,
  MANAGER_ID            BIGINT,
  HIREDATE              DATE,
  SALARY                INT,
  BONUS                 INT,
  CODE                  VARCHAR(10),
  DELETED               BIT default 0
);
alter table CM_EMPLOYEE
  add constraint PK_CM_EMPLOYEE primary key (CM_EMPLOYEE_ID);
alter table CM_EMPLOYEE
  add constraint FK_CM_EMP_MANAGER foreign key (MANAGER_ID)
  references CM_EMPLOYEE (CM_EMPLOYEE_ID);
/*----------------------------- CM_FISCALYEAR -----------------------------------*/
  create table CM_FISCALYEAR
(
  CM_FISCALYEAR_ID BIGINT not null,
  STARTDATE        DATE not null,
  ENDDATE          DATE not null,
  CREATED          DATETIME default NOW() not null,
  CREATEDBY        BIGINT not null,
  UPDATED          DATETIME default NOW() not null,
  UPDATEDBY        BIGINT not null,
  NAME             VARCHAR(50),
  DELETED          BIT default 0
);

alter table CM_FISCALYEAR
  add constraint PK_CM_FISCALYEAR primary key (CM_FISCALYEAR_ID);
alter table CM_FISCALYEAR
  add constraint UN_CM_FISCAL_YEAR_NAME unique (NAME);
alter table CM_FISCALYEAR
  add constraint CH_CS_FISCAL_PERIOD_ST_EN_DATE
  check (enddate>startdate);
/*----------------------------- CM_LOCATION -----------------------------------*/
  create table CM_LOCATION
(
  CM_LOCATION_ID     BIGINT not null,
  NAME               VARCHAR(200) not null,
  PARENT_ID          BIGINT,
  DESCRIPTION        VARCHAR(2000),
  CREATED            DATETIME default NOW() NOT NULL,
  UPDATEDBY          BIGINT default 1,
  CREATEDBY          BIGINT default 1,
  UPDATED            DATETIME default NOW() NOT NULL,
  CM_ORGANIZATION_ID BIGINT,
  CODE               VARCHAR(20),
  DELETED            BIT default 0
);
alter table CM_LOCATION
  add constraint PK_CM_LOCATION primary key (CM_LOCATION_ID);
alter table CM_LOCATION
  add constraint FK_CM_LOCATION_CM_LOCATION foreign key (PARENT_ID)
  references CM_LOCATION (CM_LOCATION_ID);
alter table CM_LOCATION
  add constraint CH_CM_LOCATION_PARENT
  check (cm_location_id<>parent_id);
/*----------------------------- CM_ORGANIZATION -----------------------------------*/
  create table CM_ORGANIZATION
(
  CM_ORGANIZATION_ID BIGINT not null,
  CREATED            DATETIME default NOW() NOT NULL,
  CREATEDBY          BIGINT default 1,
  UPDATED            DATETIME default NOW() NOT NULL,
  UPDATEDBY          BIGINT default 1,
  CODE               NVARCHAR(20),
  NAME               NVARCHAR(200) not null,
  DESCRIPTION        TEXT,
  PARENT_ID          BIGINT,
  DELETED            BIT default 0
);
alter table CM_ORGANIZATION
  add constraint PK_CM_ORGANIZATION primary key (CM_ORGANIZATION_ID);
alter table CM_ORGANIZATION
  add constraint UK_CM_ORG_NAME unique (NAME, PARENT_ID);
alter table CM_ORGANIZATION
  add constraint FK_CM_ORG_PARENT foreign key (PARENT_ID)
  references CM_ORGANIZATION (CM_ORGANIZATION_ID) ;
alter table CM_ORGANIZATION
  add constraint CH_CM_ORG_PARENT
  check (cm_organization_id<>parent_id);
/*----------------------------- CM_ORGAN_LOCATION -----------------------------------*/
  create table CM_ORGAN_LOCATION
(
  CM_ORGAN_LOCATION_ID BIGINT not null,
  CM_ORGANIZATION_ID   BIGINT not null,
  CM_LOCATION_ID       BIGINT not null,
  DESCRIPTION          TEXT,
  CREATED              DATETIME default NOW() NOT NULL ,
  UPDATEDBY            BIGINT ,
  CREATEDBY            BIGINT ,
  UPDATED              DATETIME default NOW() NOT NULL,
  DELETED              BIT default 0
);
alter table CM_ORGAN_LOCATION
  add constraint PK_CM_ORG_LOC primary key (CM_ORGAN_LOCATION_ID);
alter table CM_ORGAN_LOCATION
  add constraint UK_CM_ORG_LOC unique (CM_ORGANIZATION_ID, CM_LOCATION_ID);
/*----------------------------- CM_PERSON_BPARTNER -----------------------------------*/
 create table CM_PERSON_BPARTNER
(
  CM_PERSON_BPARTNER_ID   BIGINT not null,
  CM_BPARTNER_ID          BIGINT not null,
  SEX                     BIT not null,
  CREATED                 DATETIME default NOW() not null,
  CREATEDBY               BIGINT not null,
  UPDATEDBY               BIGINT not null,
  UPDATED                 DATETIME default NOW() not null,
  CM_COMPANY_BPARTNER_ID  BIGINT,
  PHONENO                 varchar(50),
  MOBILE                  varchar(50),
  BIRTHDATE               DATE,
  BIRTHCERTIFICATE_NUMBER VARCHAR(10),
  BIRTHCERTIFICATE_SERIAL VARCHAR(20),
  MARITAL_STATUS          TINYINT,
  FATHER_NAME             VARCHAR(200),
  CM_STATE_ID             BIGINT,
  CM_PROVINCE_ID          BIGINT,
  LODGING_ADDRESS         VARCHAR(1000),
  DELETED                 BIT default 0
);
alter table CM_PERSON_BPARTNER
  add constraint PK_CM_PERSON_BPARTNER5 primary key (CM_PERSON_BPARTNER_ID);
alter table CM_PERSON_BPARTNER
  add constraint FK_CM_PERSON_BPARTNER foreign key (CM_BPARTNER_ID)
  references CM_BPARTNER (CM_BPARTNER_ID) on delete cascade;
 /*----------------------------- CM_PROVINCE -----------------------------------*/
  create table CM_PROVINCE
(
  CM_PROVINCE_ID BIGINT not null,
  CREATED        DATETIME default NOW() not null,
  CREATEDBY      BIGINT not null,
  UPDATED        DATETIME default NOW() not null,
  UPDATEDBY      BIGINT not null,
  NAME           VARCHAR(100) not null,
  DESCRIPTION    TEXT,
  CM_STATE_ID    BIGINT not null,
  CODE           VARCHAR(10),
  DELETED        BIT default 0
);
alter table CM_PROVINCE
  add constraint PK_CM_PROVINCE primary key (CM_PROVINCE_ID);
 /*----------------------------- CM_REGION -----------------------------------*/
 create table CM_REGION
(
  CM_REGION_ID   BIGINT not null,
  CREATED        DATETIME default NOW() not null,
  CREATEDBY      BIGINT not null,
  UPDATED        DATETIME default NOW() not null,
  UPDATEDBY      BIGINT not null,
  NAME           VARCHAR(50) not null,
  DESCRIPTION    TEXT,
  CM_COUNTRY_ID  BIGINT not null,
  CM_PROVINCE_ID BIGINT,
  CODE           VARCHAR(10),
  DELETED        BIT default 0
);

alter table CM_REGION
  add constraint PK_CM_REGION primary key (CM_REGION_ID);
alter table CM_REGION
  add constraint FK_CM_REGION_CM_COUNTRY foreign key (CM_COUNTRY_ID)
  references CM_COUNTRY (CM_COUNTRY_ID);
alter table CM_REGION
  add constraint FK_CM_REGION_CM_PROVINCE foreign key (CM_PROVINCE_ID)
  references CM_PROVINCE (CM_PROVINCE_ID);
/*----------------------------- CM_ROLE_DOCSTATUS_ACCESS -----------------------------------*/ 
  create table CM_ROLE_DOCSTATUS_ACCESS
(
  CM_ROLE_DOCSTATUS_ACCESS_ID BIGINT not null,
  CREATED                     DATETIME default NOW() not null,
  UPDATED                     DATETIME default NOW() not null,
  CREATEDBY                   BIGINT not null,
  UPDATEDBY                   BIGINT not null,
  CO_ROLE_ID                  BIGINT not null,
  CM_DOC_STATUS_ID            BIGINT not null,
  DELETED                     BIT default 0
);

alter table CM_ROLE_DOCSTATUS_ACCESS
  add constraint PK_CM_ROLE_DOCSTATUS_ACCESS primary key (CM_ROLE_DOCSTATUS_ACCESS_ID);
alter table CM_ROLE_DOCSTATUS_ACCESS
  add constraint UN_CM_RL_DCSTS_ACC_STATUS unique (CO_ROLE_ID, CM_DOC_STATUS_ID);
alter table CM_ROLE_DOCSTATUS_ACCESS
  add constraint FK_CM_RL_DCSTS_ACC_STATUS foreign key (CM_DOC_STATUS_ID)
  references CM_DOC_STATUS (CM_DOC_STATUS_ID) on delete cascade;
alter table CM_ROLE_DOCSTATUS_ACCESS
  add constraint FK_CM_US_DCSTS_ACC_ROLE_ID foreign key (CO_ROLE_ID)
  references CO_ROLE (CO_ROLE_ID) on delete cascade;
/*----------------------------- CM_STATE -----------------------------------*/
  create table CM_STATE
(
  CM_STATE_ID   BIGINT not null,
  CREATED       DATETIME default NOW() not null,
  CREATEDBY     BIGINT not null,
  UPDATED       DATETIME default NOW() not null,
  UPDATEDBY     BIGINT not null,
  NAME          VARCHAR(100) not null,
  DESCRIPTION   TEXT,
  CM_COUNTRY_ID BIGINT not null,
  CODE          VARCHAR(10),
  DELETED       BIT default 0
);
alter table CM_STATE
  add constraint PK_CM_STATE primary key (CM_STATE_ID);
alter table CM_STATE
  add constraint FK_CM_STATE_CM_COUNTRY foreign key (CM_COUNTRY_ID)
  references CM_COUNTRY (CM_COUNTRY_ID);
/*----------------------------- CM_SUBSYSTEM -----------------------------------*/
  create table CM_SUBSYSTEM
(
  CM_SUBSYSTEM_ID BIGINT not null,
  NAME            VARCHAR(100) not null,
  CM_SYSTEM_ID    BIGINT not null,
  CREATED         DATETIME default NOW() not null,
  CREATEDBY       BIGINT not null,
  UPDATED         DATETIME default NOW() not null,
  UPDATEDBY       BIGINT not null,
  ICON            VARCHAR(2000),
  ABBREVIATION    VARCHAR(2) not null,
  DELETED         BIT default 0
);

alter table CM_SUBSYSTEM
  add constraint PK_CM_SUBSYSTEM8 primary key (CM_SUBSYSTEM_ID);
alter table CM_SUBSYSTEM
  add constraint UN_CM_SUBSYSTEM_NAME unique (NAME, CM_SYSTEM_ID);
alter table CM_SUBSYSTEM
  add constraint UN_CM_SYUBSYSTEM_ABBREVIATION unique (CM_SYSTEM_ID, ABBREVIATION);

/*----------------------------- CM_SUPPLIER -----------------------------------*/
  create table CM_SUPPLIER
(
  CM_SUPPLIER_ID         BIGINT not null,
  CREATED                DATETIME default NOW() not null,
  CREATEDBY              BIGINT default 1 not null,
  UPDATED                DATETIME default NOW() not null,
  UPDATEDBY              BIGINT default 1 not null,
  CM_COMPANY_BPARTNER_ID BIGINT,
  CM_PERSON_BPARTNER_ID  BIGINT,
  CODE                   VARCHAR(10),
  ARRIVAL_DATE           DATE,
  SUPPLIER_TYPE          TINYINT,
  DELETED                BIT default 0
);
alter table CM_SUPPLIER
  add constraint PK_CM_SUPPLIER primary key (CM_SUPPLIER_ID);
alter table CM_SUPPLIER
  add constraint FK_CM_SUPPLIER_CM_COMPANY foreign key (CM_COMPANY_BPARTNER_ID)
  references CM_COMPANY_BPARTNER (CM_COMPANY_BPARTNER_ID);
alter table CM_SUPPLIER
  add constraint FK_CM_SUPPLIER_CM_PERSON foreign key (CM_PERSON_BPARTNER_ID)
  references CM_PERSON_BPARTNER (CM_PERSON_BPARTNER_ID);
/*----------------------------- CM_SYSTEM -----------------------------------*/
create table CM_SYSTEM
(
  CM_SYSTEM_ID BIGINT not null,
  CREATED      DATETIME default NOW() not null,
  UPDATED      DATETIME default NOW() not null,
  CREATEDBY    BIGINT not null,
  UPDATEDBY    BIGINT not null,
  NAME         VARCHAR(100) not null,
  ICON         VARCHAR(2000),
  ABBREVIATION VARCHAR(2) not null,
  DELETED      BIT default 0
);
alter table CM_SYSTEM
  add constraint PK_CM_SYSTEM9 primary key (CM_SYSTEM_ID);
alter table CM_SYSTEM
  add constraint UN_CM_SYSTEM_ABBREVIATION unique (ABBREVIATION);
alter table CM_SYSTEM
  add constraint UN_CM_SYSTEM_NAME unique (NAME);
/*----------------------------- CM_SYSTEM_PARAMETER -----------------------------------*/
  create table CM_SYSTEM_PARAMETER
(
  CM_SYSTEM_PARAMETER_ID BIGINT not null,
  CREATED                DATETIME default NOW() not null,
  CREATEDBY              BIGINT not null,
  UPDATED                DATETIME default NOW() not null,
  UPDATEDBY              BIGINT not null,
  K		                 VARCHAR(200) not null,
  V                      VARCHAR(2000) not null,
  TYPE                   TINYINT not null,
  CM_SYSTEM_ID           BIGINT not null,
  DELETED                BIT default 0
);
alter table CM_SYSTEM_PARAMETER
  add constraint PK_CM_SYSTEM_PARAMETER primary key (CM_SYSTEM_PARAMETER_ID);
alter table CM_SYSTEM_PARAMETER
  add constraint UN_CM_SYS_PARAM_KEY unique (CM_SYSTEM_ID, K);
alter table CM_SYSTEM_PARAMETER
  add constraint FK_CM_SYS_PARAM_SYS_ID foreign key (CM_SYSTEM_ID)
  references CM_SYSTEM (CM_SYSTEM_ID) ;
/*----------------------------- CM_TRANSITION -----------------------------------*/
create table CM_TRANSITION
(
  CM_TRANSITION_ID     BIGINT not null,
  CM_DOC_STATUS_FROM   BIGINT not null,
  CM_DOC_STATUS_TO     BIGINT not null,
  CO_USECASE_ACTION_ID BIGINT not null,
  NAME                 VARCHAR(500) not null,
  DESCRIPTION          TEXT,
  CREATED              DATETIME default NOW() not null,
  CREATEDBY            BIGINT not null,
  UPDATED              DATETIME default NOW() not null,
  UPDATEDBY            BIGINT not null,
  DELETED              BIT default 0
);
alter table CM_TRANSITION
  add constraint PK_CM_TRANSITION_ID primary key (CM_TRANSITION_ID);
alter table CM_TRANSITION
  add constraint UN_CM_TRANSITION_UCS_ACT_ID unique (CO_USECASE_ACTION_ID, CM_DOC_STATUS_FROM);
alter table CM_TRANSITION
  add constraint FK_CM_TRANSITION_STATUS_FROM foreign key (CM_DOC_STATUS_FROM)
  references CM_DOC_STATUS (CM_DOC_STATUS_ID) ;
alter table CM_TRANSITION
  add constraint FK_CM_TRANSITION_STATUS_TO foreign key (CM_DOC_STATUS_TO)
  references CM_DOC_STATUS (CM_DOC_STATUS_ID) ;
alter table CM_TRANSITION
  add constraint FK_CM_TRANSITION_USC_ACT_ID foreign key (CO_USECASE_ACTION_ID)
  references CO_USECASE_ACTION (CO_USECASE_ACTION_ID) ;
alter table CM_TRANSITION
  add constraint CH_CM_TRANSITION_FROM_TO
  check (CM_DOC_STATUS_FROM<>CM_DOC_STATUS_TO);
/*----------------------------- CM_TRANSITION_HISTORY -----------------------------------*/
  create table CM_TRANSITION_HISTORY
(
  CM_TRANSITION_HISTORY_ID BIGINT not null,
  RECORD_ID                BIGINT not null,
  CO_USER_ID               BIGINT not null,
  CO_USECASE_ACTION_ID     BIGINT not null,
  CM_TRANSITION_ID         BIGINT,
  ACTION_DATE              DATETIME default NOW() not null,
  CO_USECASE_ID            BIGINT not null,
  DELETED                  BIT default 0
);
alter table CM_TRANSITION_HISTORY
  add constraint PK_CM_TRANSITION_HISTORY_ID primary key (CM_TRANSITION_HISTORY_ID);
alter table CM_TRANSITION_HISTORY
  add constraint FK_CM_TRANSITION_HS_TRS_ID foreign key (CM_TRANSITION_ID)
  references CM_TRANSITION (CM_TRANSITION_ID) ;
alter table CM_TRANSITION_HISTORY
  add constraint FK_CM_TRANSITION_HS_USER_ID foreign key (CO_USER_ID)
  references CO_USER (CO_USER_ID) ;
alter table CM_TRANSITION_HISTORY
  add constraint FK_CM_TRANSITION_HS_US_ACTION foreign key (CO_USECASE_ACTION_ID)
  references CO_USECASE_ACTION (CO_USECASE_ACTION_ID) ;
alter table CM_TRANSITION_HISTORY
  add constraint FK_CM_TRANSITION_USCSE_ID foreign key (CO_USECASE_ID)
  references CO_USECASE (CO_USECASE_ID) ;
/*----------------------------- CM_USER_DOCSTATUS_ACCESS -----------------------------------*/
  create table CM_USER_DOCSTATUS_ACCESS
(
  CM_USER_DOCSTATUS_ACCESS_ID BIGINT not null,
  CREATED                     DATETIME default NOW() not null,
  UPDATED                     DATETIME default NOW() not null,
  CREATEDBY                   BIGINT not null,
  UPDATEDBY                   BIGINT not null,
  CO_USER_ID                  BIGINT not null,
  CM_DOC_STATUS_ID            BIGINT not null,
  DELETED                     BIT default 0
);

alter table CM_USER_DOCSTATUS_ACCESS
  add constraint PK_CM_USER_DOCSTATUS_ACCESS primary key (CM_USER_DOCSTATUS_ACCESS_ID);
alter table CM_USER_DOCSTATUS_ACCESS
  add constraint UN_CM_US_DCSTS_ACC_STATUS unique (CO_USER_ID, CM_DOC_STATUS_ID);
alter table CM_USER_DOCSTATUS_ACCESS
  add constraint FK_CM_US_DCSTS_ACC_STATUS foreign key (CM_DOC_STATUS_ID)
  references CM_DOC_STATUS (CM_DOC_STATUS_ID) ;
alter table CM_USER_DOCSTATUS_ACCESS
  add constraint FK_CM_US_DCSTS_ACC_USER_ID foreign key (CO_USER_ID)
  references CO_USER (CO_USER_ID) ;
/*----------------------------- CONSTRAINTS -----------------------------------*/
  alter table CO_APP_REFRESH_TOKEN
  add constraint FK_CO_APP_REFRESH_TOKEN_USER foreign key (CO_USER_ID)
  references CO_USER (CO_USER_ID);

alter table CO_APP_USCS_ACCSS
  add constraint FK_APP_USCS_ACCSS_USCASE_ID foreign key (CO_USECASE_ID)
  references CO_USECASE (CO_USECASE_ID) ;
alter table CO_APP_USCS_ACCSS
  add constraint FK_CO_APP_USCS_ACCSS_APP_ID foreign key (CO_APPLICATION_ID)
  references CO_APPLICATION (CO_APPLICATION_ID) ;

alter table CO_ATTACHMENT
  add constraint FK_CO_ATTACHMENT_USECASE_ID foreign key (CO_USECASE_ID)
  references CO_USECASE (CO_USECASE_ID) ;

alter table CO_MENU
  add constraint FK_CO_MENU_CO_USECASE_ACTION foreign key (CO_USECASE_ACTION_ID)
  references CO_USECASE_ACTION (CO_USECASE_ACTION_ID) ;

alter table CO_REVISION
  add constraint FK_CO_REVISION_USECASE_ID foreign key (CO_USECASE_ID)
  references CO_USECASE (CO_USECASE_ID) ;

alter table CO_ROLE_ORGANIZATION_ACSS
  add constraint FK_CO_ROLE_ORG_ACSS_ORG_ID foreign key (CM_ORGANIZATION_ID)
  references CM_ORGANIZATION (CM_ORGANIZATION_ID) ;
alter table CO_ROLE_ORGANIZATION_ACSS
  add constraint FK_CO_ROLE_ORG_ACSS_ROLE_ID foreign key (CO_ROLE_ID)
  references CO_ROLE (CO_ROLE_ID) ;

alter table CO_ROLE_USCS_ACTN_ACCS
  add constraint FK_RLE_USCS_ATN_ACCS_USCS_ACTN foreign key (CO_USECASE_ACTION_ID)
  references CO_USECASE_ACTION (CO_USECASE_ACTION_ID);


alter table CO_ROLE_USECASE_ACSS
  add constraint FK_CO_USECASE_ID foreign key (CO_USECASE_ID)
  references CO_USECASE (CO_USECASE_ID) ;

alter table CO_SEQUENCE
  add constraint FK_SEQ_CM_SUBSYSTEM_ID foreign key (CM_SUBSYSTEM_ID)
  references CM_SUBSYSTEM (CM_SUBSYSTEM_ID) ;

alter table CO_SETTINGS
  add constraint FK_CO_SETTING_SYSTEM foreign key (CM_SYSTEM_ID)
  references CM_SYSTEM (CM_SYSTEM_ID);

alter table CO_USECASE
  add constraint FK_CO_USECASE_SUBSYSTEM foreign key (CM_SUBSYSTEM_ID)
  references CM_SUBSYSTEM (CM_SUBSYSTEM_ID) ;

alter table CO_USER
  add constraint FK_CO_USER_CM_BPARTNER_ID foreign key (CM_BPARTNER_ID)
  references CM_BPARTNER (CM_BPARTNER_ID) ;
alter table CO_USER
  add constraint FK_CO_USER_ORGANIZATION_ID foreign key (CM_ORGANIZATION_ID)
  references CM_ORGANIZATION (CM_ORGANIZATION_ID);

alter table CO_USER_ORGANIZATION_ACSS
  add constraint FK_CO_USER_ORG_ACSS_ORG_ID foreign key (CM_ORGANIZATION_ID)
  references CM_ORGANIZATION (CM_ORGANIZATION_ID) ;
alter table CM_BANK_BRANCH
  add constraint FK_CM_PROVINCE foreign key (CM_PROVINCE_ID)
  references CM_PROVINCE (CM_PROVINCE_ID);
alter table CM_CITY
  add constraint FK_CM_CITY_CM_REGION foreign key (CM_REGION_ID)
  references CM_REGION (CM_REGION_ID);
alter table CM_CITY
  add constraint FK_CM_CITY_CM_COUNTRY foreign key (CM_COUNTRY_ID)
  references CM_COUNTRY (CM_COUNTRY_ID);
alter table CM_COUNTRY
  add constraint FK_CM_COUNTRY_CM_CURRENCY foreign key (CM_CURRENCY_ID)
  references CM_CURRENCY (CM_CURRENCY_ID);
alter table CM_DOC_STATUS
  add constraint FK_CM_DOC_STATUS_FISC_YEAR_ID foreign key (CM_FISCALYEAR_ID)
  references CM_FISCALYEAR (CM_FISCALYEAR_ID) ;
alter table CM_EMPLOYEE
  add constraint FK_CM_EMP_ORGANIZATION foreign key (CM_ORGANIZATION_ID)
  references CM_ORGANIZATION (CM_ORGANIZATION_ID);
alter table CM_EMPLOYEE
  add constraint FK_CM_EMP_BPARTNER foreign key (CM_PERSON_BPARTNER_ID)
  references CM_PERSON_BPARTNER (CM_PERSON_BPARTNER_ID) ;
alter table CM_LOCATION
  add constraint FK_CM_LOCATION_CM_ORGANIZATION foreign key (CM_ORGANIZATION_ID)
  references CM_ORGANIZATION (CM_ORGANIZATION_ID);
alter table CM_PERSON_BPARTNER
  add constraint FK_CM_PERSOM_PROVINCE foreign key (CM_PROVINCE_ID)
  references CM_PROVINCE (CM_PROVINCE_ID);
alter table CM_PERSON_BPARTNER
  add constraint FK_CM_PERSON_STATE foreign key (CM_STATE_ID)
  references CM_STATE (CM_STATE_ID);
alter table CM_PROVINCE
  add constraint CM_PROVINCE_CM_STATE foreign key (CM_STATE_ID)
  references CM_STATE (CM_STATE_ID);
alter table CM_SUBSYSTEM
  add constraint FK_CM_SYSTEM_ID foreign key (CM_SYSTEM_ID)
  references CM_SYSTEM (CM_SYSTEM_ID);
alter table CO_ATTACHMENT
  add constraint FK_CO_ATTACHMENT_USACTION_ID foreign key (CO_USECASE_ACTION_ID)
  references CO_USECASE_ACTION (CO_USECASE_ACTION_ID) ;
