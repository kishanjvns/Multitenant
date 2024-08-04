create schema dukes;

create schema jack;

create table dukes.instrument(
id  UUID primary key,
name varchar(255) not null,
type varchar(255)
)

create table jack.instrument(
id  UUID primary key,
name varchar(255) not null,
type varchar(255)
)