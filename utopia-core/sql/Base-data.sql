use core;
---------------------------------------- ZERO-PORTAL AND System User AND Bpartner ------------------------------------------
INSERT INTO co_portal
(`ID`,`CREATEDBY`,`UPDATEDBY`,`NAME`,`DOMAIN_NAME`)
VALUES(0,0,0,'zero-portal','');
INSERT INTO cm_bpartner
(`ID`,`CREATEDBY`,`CODE`,`NAME`,`SECOUND_NAME`,`UPDATEDBY`,`PERSONTYPE`)
VALUES(0,0,'0','system','system',0,0);
INSERT INTO co_user(`ID`,`USERNAME`,`PASSWORD`,`CREATEDBY`,`UPDATEDBY`,`CM_BPARTNER_ID`,`CO_PORTAL_ID`)
VALUES(0,'system','s1st3m',0,0,0,0);
---------------------------------------- CO_SEQUENCE ------------------------------------------
INSERT INTO CO_SEQUENCE(ID,TABLE_NAME,CURRENT_ID) VALUES(1,'CM_BPARTNER',1000);
INSERT INTO CO_SEQUENCE(ID,TABLE_NAME,CURRENT_ID) VALUES(2,'CM_CITY',1000);
INSERT INTO CO_SEQUENCE(ID,TABLE_NAME,CURRENT_ID) VALUES(3,'CM_COMPANY_BPARTNER',1000);
INSERT INTO CO_SEQUENCE(ID,TABLE_NAME,CURRENT_ID) VALUES(4,'CM_COUNTRY',1000);
INSERT INTO CO_SEQUENCE(ID,TABLE_NAME,CURRENT_ID) VALUES(5,'CM_CURRENCY',1000);
INSERT INTO CO_SEQUENCE(ID,TABLE_NAME,CURRENT_ID) VALUES(6,'CM_CUSTOMER',1000);
INSERT INTO CO_SEQUENCE(ID,TABLE_NAME,CURRENT_ID) VALUES(7,'CM_DOCTYPE',1000);
INSERT INTO CO_SEQUENCE(ID,TABLE_NAME,CURRENT_ID) VALUES(8,'CM_DOCTYPE_DIMENSION',1000);
INSERT INTO CO_SEQUENCE(ID,TABLE_NAME,CURRENT_ID) VALUES(9,'CM_DOC_STATUS',1000);
INSERT INTO CO_SEQUENCE(ID,TABLE_NAME,CURRENT_ID) VALUES(10,'CM_EMPLOYEE',1000);
INSERT INTO CO_SEQUENCE(ID,TABLE_NAME,CURRENT_ID) VALUES(11,'CM_FISCALYEAR',1000);
INSERT INTO CO_SEQUENCE(ID,TABLE_NAME,CURRENT_ID) VALUES(12,'CM_LOCATION',1000);
INSERT INTO CO_SEQUENCE(ID,TABLE_NAME,CURRENT_ID) VALUES(13,'CM_ORGANIZATION',1000);
INSERT INTO CO_SEQUENCE(ID,TABLE_NAME,CURRENT_ID) VALUES(14,'CM_PERSON_BPARTNER',1000);
INSERT INTO CO_SEQUENCE(ID,TABLE_NAME,CURRENT_ID) VALUES(15,'CM_PROVINCE',1000);
INSERT INTO CO_SEQUENCE(ID,TABLE_NAME,CURRENT_ID) VALUES(16,'CM_REGION',1000);
INSERT INTO CO_SEQUENCE(ID,TABLE_NAME,CURRENT_ID) VALUES(17,'CM_STATE',1000);
INSERT INTO CO_SEQUENCE(ID,TABLE_NAME,CURRENT_ID) VALUES(18,'CM_SUBSYSTEM',1000);
INSERT INTO CO_SEQUENCE(ID,TABLE_NAME,CURRENT_ID) VALUES(19,'CM_SUPPLIER',1000);
INSERT INTO CO_SEQUENCE(ID,TABLE_NAME,CURRENT_ID) VALUES(20,'CM_SYSTEM',1000);
INSERT INTO CO_SEQUENCE(ID,TABLE_NAME,CURRENT_ID) VALUES(21,'CM_TRANSITION',1000);
INSERT INTO CO_SEQUENCE(ID,TABLE_NAME,CURRENT_ID) VALUES(22,'CM_TRANSITION_HISTORY',1000);
INSERT INTO CO_SEQUENCE(ID,TABLE_NAME,CURRENT_ID) VALUES(23,'CO_ACTION',1000);
INSERT INTO CO_SEQUENCE(ID,TABLE_NAME,CURRENT_ID) VALUES(24,'CO_APPLICATION',1000);
INSERT INTO CO_SEQUENCE(ID,TABLE_NAME,CURRENT_ID) VALUES(25,'CO_APP_REFRESH_TOKEN',1000);
INSERT INTO CO_SEQUENCE(ID,TABLE_NAME,CURRENT_ID) VALUES(26,'CO_APP_USCS_ACCSS',1000);
INSERT INTO CO_SEQUENCE(ID,TABLE_NAME,CURRENT_ID) VALUES(27,'CO_ATTACHMENT',1000);
INSERT INTO CO_SEQUENCE(ID,TABLE_NAME,CURRENT_ID) VALUES(28,'CO_MENU',1000);
INSERT INTO CO_SEQUENCE(ID,TABLE_NAME,CURRENT_ID) VALUES(29,'CO_PORTAL',1000);
INSERT INTO CO_SEQUENCE(ID,TABLE_NAME,CURRENT_ID) VALUES(30,'CO_PORTAL_SYS_ACCSS',1000);
INSERT INTO CO_SEQUENCE(ID,TABLE_NAME,CURRENT_ID) VALUES(31,'CO_REVISION',1000);
INSERT INTO CO_SEQUENCE(ID,TABLE_NAME,CURRENT_ID) VALUES(32,'CO_ROLE',1000);
INSERT INTO CO_SEQUENCE(ID,TABLE_NAME,CURRENT_ID) VALUES(33,'CO_ROLE_ORGANIZATION_ACSS',1000);
INSERT INTO CO_SEQUENCE(ID,TABLE_NAME,CURRENT_ID) VALUES(34,'CO_ROLE_SUBSYSTEM_ACSS',1000);
INSERT INTO CO_SEQUENCE(ID,TABLE_NAME,CURRENT_ID) VALUES(35,'CO_ROLE_USCS_ACTN_ACCS',1000);
INSERT INTO CO_SEQUENCE(ID,TABLE_NAME,CURRENT_ID) VALUES(36,'CO_ROLE_USECASE_ACSS',1000);
INSERT INTO CO_SEQUENCE(ID,TABLE_NAME,CURRENT_ID) VALUES(37,'CO_SETTINGS',1000);
INSERT INTO CO_SEQUENCE(ID,TABLE_NAME,CURRENT_ID) VALUES(38,'CO_USECASE',1000);
INSERT INTO CO_SEQUENCE(ID,TABLE_NAME,CURRENT_ID) VALUES(39,'CO_USECASE_ACTION',1000);
INSERT INTO CO_SEQUENCE(ID,TABLE_NAME,CURRENT_ID) VALUES(40,'CO_USER',1000);
INSERT INTO CO_SEQUENCE(ID,TABLE_NAME,CURRENT_ID) VALUES(41,'CO_USER_APP_TOKEN',1000);
INSERT INTO CO_SEQUENCE(ID,TABLE_NAME,CURRENT_ID) VALUES(42,'CO_USER_LOG',1000);
INSERT INTO CO_SEQUENCE(ID,TABLE_NAME,CURRENT_ID) VALUES(43,'CO_USER_LOG_DTL',1000);
INSERT INTO CO_SEQUENCE(ID,TABLE_NAME,CURRENT_ID) VALUES(44,'CO_USER_ORGANIZATION_ACSS',1000);
INSERT INTO CO_SEQUENCE(ID,TABLE_NAME,CURRENT_ID) VALUES(45,'CO_USER_ROLES',1000);
INSERT INTO CO_SEQUENCE(ID,TABLE_NAME,CURRENT_ID) VALUES(46,'CO_USER_USECASE_ACSS',1000);
INSERT INTO CO_SEQUENCE(ID,TABLE_NAME,CURRENT_ID) VALUES(47,'CO_USR_USCS_ACTN_ACCS',1000);
