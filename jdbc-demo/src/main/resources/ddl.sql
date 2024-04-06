create database mydb;
use mydb;
create table user
(
    `id`   int(10) auto_increment,
    `name` varbinary(64) not null,
    primary key (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;