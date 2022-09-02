use projectdb

create table location (id int PRIMARY KEY,code varchar(20),name varchar(20),type varchar(10))

select * from location

drop table location

create table vendor(
id int PRIMARY KEY,
code varchar(20),
name varchar(20),
type varchar(20),
email varchar(20),
phone varchar(20),
addressm varchar(20)
)

select * from vendor

