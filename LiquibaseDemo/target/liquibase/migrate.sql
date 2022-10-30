-- *********************************************************************
-- Update Database Script
-- *********************************************************************
-- Change Log: src/main/resources/db/changelog/master-changelog.xml
-- Ran at: 24/04/22, 3:40 PM
-- Against: liquibase@jdbc:derby://localhost:1527/sample;create=true
-- Liquibase version: 3.6.1
-- *********************************************************************

-- Lock Database
UPDATE DATABASECHANGELOGLOCK SET LOCKED = TRUE, LOCKEDBY = 'DESKTOP-5HI3COU (192.168.33.1)', LOCKGRANTED = TIMESTAMP('2022-04-24 15:40:56.928000') WHERE ID = 1 AND LOCKED = FALSE;

-- Changeset src/main/resources/db/changelog/changelog1.xml::change_1::bhim
CREATE TABLE Emp (EmpId INTEGER, EmpName VARCHAR(10));

UPDATE DATABASECHANGELOG SET DATEEXECUTED = CURRENT_TIMESTAMP, DEPLOYMENT_ID = '0795059184', EXECTYPE = 'RERAN', MD5SUM = '8:67a28ab776110a5baf75b790b600ded0', ORDEREXECUTED = 3 WHERE ID = 'change_1' AND AUTHOR = 'bhim' AND FILENAME = 'src/main/resources/db/changelog/changelog1.xml';

-- Release Database Lock
UPDATE DATABASECHANGELOGLOCK SET LOCKED = FALSE, LOCKEDBY = NULL, LOCKGRANTED = NULL WHERE ID = 1;

