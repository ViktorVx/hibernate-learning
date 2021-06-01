-- liquibase formatted sql

/*** create table SM_OPERATION_VERSION ***/
-- changeset viktor-vx:LDS_STORED_IMAGE#0001 dbms:postgresql logicalFilePath:path-independent runOnChange:true splitStatements:true endDelimiter:/
DO $$
    DECLARE
        tableExists boolean;
    BEGIN
        SELECT EXISTS (SELECT FROM information_schema.columns cl
        WHERE cl.table_name = lower('LDS_STORED_IMAGE') AND cl.table_schema = lower('${schema}')) INTO tableExists;
        IF (tableExists = FALSE) THEN
            CREATE TABLE IF NOT EXISTS ${schema}.LDS_STORED_IMAGE (
                STORED_IMAGE_ID         VARCHAR(255) NOT NULL,
                STORED_IMAGE            VARCHAR(255),
                CONSTRAINT LDS_PK_STORED_IMAGE_STORED_IMAGE_ID PRIMARY KEY (STORED_IMAGE_ID) USING INDEX TABLESPACE LDS_TS_IDX
            ) TABLESPACE LDS_TS_DATA;

            COMMENT ON TABLE ${schema}.LDS_STORED_IMAGE                     IS 'Таблица изображений';
            COMMENT ON COLUMN ${schema}.LDS_STORED_IMAGE.STORED_IMAGE_ID    IS 'Идентификатор изображения';
            COMMENT ON COLUMN ${schema}.LDS_STORED_IMAGE.STORED_IMAGE       IS 'Изображение';
        END IF;
    END;
$$;
/