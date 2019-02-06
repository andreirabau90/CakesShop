DROP DataBase if EXISTS cakes_shop;
create DATABASE if not exists cakes_shop;
use cakes_shop;

CREATE table group_product(
group_id int not null primary key AUTO_INCREMENT ,
group_name varchar(30) not null);

CREATE table product(
product_id int primary key not null AUTO_INCREMENT,
product_name varchar(30) not null,
price int,
product_group int,
foreign key (product_group) references  group_product(group_id));

CREATE table user(
user_id int not null primary key AUTO_INCREMENT,
user_name varchar (30) not  null,
user_pass varchar (30) not null,
user_email varchar (30) not null);

CREATE table feedback (
feedback_id int not null primary key AUTO_INCREMENT,
text varchar (250) not null,
feedback_user int,
foreign key (feedback_user) references user(user_id),
feedback_product int,
foreign key (feedback_product) references product(product_id));

insert into group_product(group_id, group_name) values
(1,"cakes"),
(2,"gringerbreads"),
(3,"sweets");


insert into product(product_id,product_name,price,product_group) values
(1,"наполеон",7,1),
(2,"медовый",5,1),
(3,"фруктовый",4,1),
(4,"кремовый",5,1),
(5,"имбирный",2,2),
(6,"с курагой",3,2),
(7,"шоколадный",3,2),
(8,"с цукатами",3,2),
(9,"сорванец",5,3),
(10,"красная шапочка",6,3),
(11,"коровка",5,3);

