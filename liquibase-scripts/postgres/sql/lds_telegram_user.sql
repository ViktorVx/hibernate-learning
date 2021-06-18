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
                TELEGRAM_USER_ID    VARCHAR(256) NOT NULL,
                FIRST_NAME          VARCHAR(256),
                LAST_NAME           VARCHAR(256),
                USER_NAME           VARCHAR(256),
                LANGUAGE_CODE       VARCHAR(64),
                IS_BOT              VARCHAR(1),
                CONSTRAINT LDS_PK_TELEGRAM_USER_TELEGRAM_USER_ID PRIMARY KEY (TELEGRAM_USER_ID) USING INDEX TABLESPACE LDS_TS_IDX
            ) TABLESPACE LDS_TS_DATA;

            COMMENT ON TABLE ${schema}.LDS_TELEGRAM_USER                    IS 'Table with telegram-user info';
            COMMENT ON COLUMN ${schema}.LDS_TELEGRAM_USER.TELEGRAM_USER_ID  IS 'Unique identifier';
            COMMENT ON COLUMN ${schema}.LDS_TELEGRAM_USER.FIRST_NAME        IS 'First name';
            COMMENT ON COLUMN ${schema}.LDS_TELEGRAM_USER.LAST_NAME         IS 'Last name';
            COMMENT ON COLUMN ${schema}.LDS_TELEGRAM_USER.USER_NAME         IS 'User name';
            COMMENT ON COLUMN ${schema}.LDS_TELEGRAM_USER.LANGUAGE_CODE     IS 'Language code';
            COMMENT ON COLUMN ${schema}.LDS_TELEGRAM_USER.IS_BOT            IS 'Bot flag';
        END IF;
    END;
$$;
/