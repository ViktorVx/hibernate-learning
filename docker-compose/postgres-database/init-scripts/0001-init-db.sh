#!/bin/bash
mkdir -p /var/lib/postgresql/tablespaces
mkdir -p /var/lib/postgresql/tablespaces/LDS_TS_DATA
mkdir -p /var/lib/postgresql/tablespaces/LDS_TS_IDX

set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" <<-EOSQL
    CREATE DATABASE ${APP_DB_NAME};
EOSQL

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" -d "$APP_DB_NAME" <<-EOSQL
    CREATE SCHEMA IF NOT EXISTS ${APP_DB_SCHEMA_NAME};
    CREATE TABLESPACE LDS_TS_DATA LOCATION '/var/lib/postgresql/tablespaces/LDS_TS_DATA';
    CREATE TABLESPACE LDS_TS_IDX LOCATION '/var/lib/postgresql/tablespaces/LDS_TS_IDX';
EOSQL