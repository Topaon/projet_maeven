create table compte (id number(19,0) generated as identity, label varchar2(255 char), primary key (id));
create table customer (id number(19,0) generated as identity, firstname varchar2(255 char), lastname varchar2(255 char), password varchar2(255 char), primary key (id));
create table compte (id number(19,0) generated as identity, label varchar2(255 char), primary key (id));
create table customer (id number(19,0) generated as identity, firstname varchar2(255 char), lastname varchar2(255 char), password varchar2(255 char), primary key (id));
create table compte (id bigint not null auto_increment, label varchar(255), primary key (id)) engine=InnoDB;
create table customer (id bigint not null auto_increment, firstname varchar(255), lastname varchar(255), password varchar(255), primary key (id)) engine=InnoDB;
create table compte (id bigint not null auto_increment, label varchar(255), primary key (id)) engine=InnoDB;
create table customer (id bigint not null auto_increment, firstname varchar(255), lastname varchar(255), password varchar(255), primary key (id)) engine=InnoDB;
