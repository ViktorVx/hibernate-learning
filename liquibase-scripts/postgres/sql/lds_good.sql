-- liquibase formatted sql

/*** create table SM_OPERATION_VERSION ***/
-- changeset viktor-vx:LDS_GOOD#0001 dbms:postgresql logicalFilePath:path-independent runOnChange:true splitStatements:true endDelimiter:/
DO $$
    DECLARE
        tableExists boolean;
    BEGIN
        SELECT EXISTS (SELECT FROM information_schema.columns cl
        WHERE cl.table_name = lower('LDS_GOOD') AND cl.table_schema = lower('${schema}')) INTO tableExists;
        IF (tableExists = FALSE) THEN
            CREATE TABLE IF NOT EXISTS ${schema}.LDS_GOOD (
                GOOD_ID VARCHAR(255) NOT NULL,
                GTIN VARCHAR(255) NOT NULL,
                GOOD_TITLE VARCHAR(255),
                GOOD_DESCRIPTION VARCHAR(1024),
                GOOD_PRICE NUMERIC(38),
                CONSTRAINT LDS_PK_GOOD_ID PRIMARY KEY (GOOD_ID) USING INDEX TABLESPACE LDS_TS_IDX
            ) TABLESPACE LDS_TS_DATA;

            COMMENT ON TABLE ${schema}.LDS_GOOD                    IS 'Данные о товаре';
            COMMENT ON COLUMN ${schema}.LDS_GOOD.GTIN              IS 'Глобальный номер товара';
            COMMENT ON COLUMN ${schema}.LDS_GOOD.GOOD_TITLE        IS 'Краткое наименование товара';
            COMMENT ON COLUMN ${schema}.LDS_GOOD.GOOD_DESCRIPTION  IS 'Описание товара';
            COMMENT ON COLUMN ${schema}.LDS_GOOD.GOOD_PRICE        IS 'Цена товара';
        END IF;
    END;
$$;