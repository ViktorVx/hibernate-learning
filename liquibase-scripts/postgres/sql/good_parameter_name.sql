-- liquibase formatted sql

/*** create table SM_OPERATION_VERSION ***/
-- changeset viktor-vx:LDS_GOOD_PARAMETER_NAME#0001 dbms:postgresql logicalFilePath:path-independent runOnChange:true splitStatements:true endDelimiter:/
DO $$
    DECLARE
        tableExists boolean;
    BEGIN
        SELECT EXISTS (SELECT FROM information_schema.columns cl
        WHERE cl.table_name = lower('LDS_GOOD_PARAMETER_NAME') AND cl.table_schema = lower('${schema}')) INTO tableExists;
        IF (tableExists = FALSE) THEN
            CREATE TABLE IF NOT EXISTS ${schema}.LDS_GOOD_PARAMETER_NAME (
                GOOD_PARAM_NAME_ID  VARCHAR(255) NOT NULL,
                PARAM_NAME          VARCHAR(255),
                PARAM_DESCRIPTION   VARCHAR(1000),
                CONSTRAINT LDS_PK_GOOD_PARAM_NAME_GOOD_PARAM_NAME_ID PRIMARY KEY (GOOD_PARAM_NAME_ID) USING INDEX TABLESPACE LDS_TS_IDX
            ) TABLESPACE LDS_TS_DATA;

            COMMENT ON TABLE ${schema}.LDS_GOOD_PARAMETER_NAME                          IS 'Таблица наименований параметров товаров';
            COMMENT ON COLUMN ${schema}.LDS_GOOD_PARAMETER_NAME.PARAM_NAME              IS 'Наименование параметра';
            COMMENT ON COLUMN ${schema}.LDS_GOOD_PARAMETER_NAME.PARAM_DESCRIPTION       IS 'Описание параметра';
        END IF;
    END;
$$;
/