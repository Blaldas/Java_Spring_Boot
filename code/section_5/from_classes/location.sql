use projectdb

create table location (id int PRIMARY KEY,code varchar(20),name varchar(20),type varchar(10))

select * from location
DELETE FROM location WHERE id=0

drop table location

select type, count(type)
FROM location
group by type

select type, count(type)FROM location group by type
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

