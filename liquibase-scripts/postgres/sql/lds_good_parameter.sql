-- liquibase formatted sql

/*** create table SM_OPERATION_VERSION ***/
-- changeset viktor-vx:LDS_GOOD_PARAMETER#0001 dbms:postgresql logicalFilePath:path-independent runOnChange:true splitStatements:true endDelimiter:/
DO $$
    DECLARE
        tableExists boolean;
    BEGIN
        SELECT EXISTS (SELECT FROM information_schema.columns cl
                       WHERE cl.table_name = lower('LDS_GOOD_PARAMETER') AND cl.table_schema = lower('${schema}')) INTO tableExists;
        IF (tableExists = FALSE) THEN
            CREATE TABLE IF NOT EXISTS ${schema}.LDS_GOOD_PARAMETER (
              GOOD_PARAM_ID         VARCHAR(255)    NOT NULL,
              GOOD_ID               VARCHAR(255)    NOT NULL,
              GOOD_PARAM_NAME       VARCHAR(255)    NOT NULL,
              GOOD_PARAM_DATA_TYPE  VARCHAR(255),
              GOOD_DESCRIPTION      VARCHAR(1024),
              GOOD_PARAM_VALUE      VARCHAR(512),
              CONSTRAINT LDS_PK_GOOD_PARAM_ID PRIMARY KEY (GOOD_PARAM_ID) USING INDEX TABLESPACE LDS_TS_IDX
            ) TABLESPACE LDS_TS_DATA;

            COMMENT ON TABLE ${schema}.LDS_GOOD_PARAMETER                         IS 'Характеристики товаров}';
            COMMENT ON COLUMN ${schema}.LDS_GOOD_PARAMETER.GOOD_PARAM_ID          IS 'Идентификатор характеристики';
            COMMENT ON COLUMN ${schema}.LDS_GOOD_PARAMETER.GOOD_ID                IS 'Идентификатор товара';
            COMMENT ON COLUMN ${schema}.LDS_GOOD_PARAMETER.GOOD_PARAM_NAME        IS 'Наименование параметра';
            COMMENT ON COLUMN ${schema}.LDS_GOOD_PARAMETER.GOOD_PARAM_DATA_TYPE   IS 'Тип данных параметра';
            COMMENT ON COLUMN ${schema}.LDS_GOOD_PARAMETER.GOOD_DESCRIPTION       IS 'Описание характеристики';
            COMMENT ON COLUMN ${schema}.LDS_GOOD_PARAMETER.GOOD_PARAM_VALUE       IS 'Значение характеристики';
        END IF;
    END;
$$;