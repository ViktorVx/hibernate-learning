--liquibase formatted sql

--changeset person:001 author:ViktorVx runOnChange:true endDelimiter:/
create table telegram_user (
telegram_user_id varchar(255) not null,
user_name varchar(255),
user_info varchar(255)
);
/