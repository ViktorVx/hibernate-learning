-- liquibase formatted sql

/*** create table SM_OPERATION_VERSION ***/
-- changeset viktor-vx:LDS_TELEGRAM_USER#0001 dbms:postgresql logicalFilePath:path-independent runOnChange:true splitStatements:true endDelimiter:/
DO $$
    DECLARE
        tableExists boolean;
    BEGIN
        SELECT EXISTS (SELECT FROM information_schema.columns cl
        WHERE cl.table_name = lower('LDS_TELEGRAM_USER') AND cl.table_schema = lower('${schema}')) INTO tableExists;
        IF (tableExists = FALSE) THEN
            CREATE TABLE IF NOT EXISTS ${schema}.LDS_TELEGRAM_USER (
                TELEGRAM_USER_ID VARCHAR(255) NOT NULL,
                USER_NAME VARCHAR(255),
                USER_INFO VARCHAR(255),
                CONSTRAINT LDS_PK_TELEGRAM_USER_TELEGRAM_USER_ID PRIMARY KEY (TELEGRAM_USER_ID) USING INDEX TABLESPACE LDS_TS_IDX
            ) TABLESPACE LDS_TS_DATA;

            COMMENT ON TABLE ${schema}.LDS_TELEGRAM_USER                   IS 'Данные о пользователе Telegram';
            COMMENT ON COLUMN ${schema}.LDS_TELEGRAM_USER.USER_NAME        IS 'Имя пользователя';
            COMMENT ON COLUMN ${schema}.LDS_TELEGRAM_USER.USER_INFO        IS 'Телефонный номер';
        END IF;
    END;
$$;
/