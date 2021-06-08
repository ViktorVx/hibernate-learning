-- liquibase formatted sql

/*** create table SM_OPERATION_VERSION ***/
-- changeset viktor-vx:LDS_CENTRAL_USER#0001 dbms:postgresql logicalFilePath:path-independent runOnChange:true splitStatements:true endDelimiter:/
DO $$
    DECLARE
        tableExists boolean;
    BEGIN
        SELECT EXISTS (SELECT FROM information_schema.columns cl
        WHERE cl.table_name = lower('LDS_CENTRAL_USER') AND cl.table_schema = lower('${schema}')) INTO tableExists;
        IF (tableExists = FALSE) THEN
            CREATE TABLE IF NOT EXISTS ${schema}.LDS_CENTRAL_USER (
                CENTRAL_USER_ID VARCHAR(255) NOT NULL,
                PHONE_NUMBER VARCHAR(255),
                TELEGRAM_USER VARCHAR(255),
                CONSTRAINT LDS_PK_CENTRAL_USER_CENTRAL_USER_ID PRIMARY KEY (CENTRAL_USER_ID) USING INDEX TABLESPACE LDS_TS_IDX,
                CONSTRAINT LDS_FK_CENTRAL_USER_TELEGRAM_USER FOREIGN KEY (TELEGRAM_USER) REFERENCES ${schema}.LDS_TELEGRAM_USER(TELEGRAM_USER_ID),
                CONSTRAINT LDS_UC_CENTRAL_USER_PHONE_NUMBER UNIQUE(PHONE_NUMBER) USING INDEX TABLESPACE LDS_TS_IDX
            ) TABLESPACE LDS_TS_DATA;

            CREATE INDEX IF NOT EXISTS LDS_IDX_LDS_CENTRAL_USER_PHONE_NUMBER ON ${schema}.LDS_CENTRAL_USER(PHONE_NUMBER) TABLESPACE LDS_TS_IDX;
            CREATE INDEX IF NOT EXISTS LDS_IDX_LDS_CENTRAL_USER_TELEGRAM_USER ON ${schema}.LDS_CENTRAL_USER(TELEGRAM_USER) TABLESPACE LDS_TS_IDX;

            COMMENT ON TABLE ${schema}.LDS_CENTRAL_USER                         IS 'Таблица объединяющая всю информацию о пользователе';
            COMMENT ON COLUMN ${schema}.LDS_CENTRAL_USER.CENTRAL_USER_ID        IS 'Уникальный идентификатор';
            COMMENT ON COLUMN ${schema}.LDS_CENTRAL_USER.PHONE_NUMBER           IS 'Телефонный номер';
            COMMENT ON COLUMN ${schema}.LDS_CENTRAL_USER.TELEGRAM_USER          IS 'Ссылка на пользователя Telegram';
        END IF;
    END;
$$;
/

-- changeset viktor-vx:LDS_CENTRAL_USER#0002 dbms:postgresql logicalFilePath:path-independent runOnChange:true splitStatements:true endDelimiter:/
DO $$
    DECLARE
        colExists boolean;
    BEGIN
        SELECT EXISTS (SELECT FROM information_schema.columns cl
                       WHERE cl.table_name = lower('LDS_CENTRAL_USER')
                         AND cl.column_name = lower('PHONE_NUMBER')
                         AND cl.table_schema = lower('${schema}')) INTO colExists;
        IF (colExists = FALSE) THEN
            ALTER TABLE IF EXISTS ${schema}.SM_OPERATION_VERSION ADD COLUMN IF NOT EXISTS PHONE_NUMBER VARCHAR(255);
            CREATE INDEX IF NOT EXISTS LDS_IDX_LDS_CENTRAL_USER_PHONE_NUMBER ON ${schema}.LDS_CENTRAL_USER(PHONE_NUMBER) TABLESPACE LDS_TS_IDX;
            COMMENT ON COLUMN ${schema}.LDS_CENTRAL_USER.PHONE_NUMBER           IS 'Телефонный номер';
        END IF;
    END;
$$;
/