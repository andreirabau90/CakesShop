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
description varchar (250),
product_group int,
foreign key (product_group) references  group_product(group_id),
product_basket int,
foreign key (product_basket) references basket(basket_id));

CREATE table user(
user_id int not null primary key AUTO_INCREMENT,
user_name varchar (30) not  null,
user_pass varchar (30) not null,
user_email varchar (30) not null,
user_basket int,
FOREIGN KEY (user_basket) references basket(basket_id));

CREATE table feedback (
feedback_id int not null primary key AUTO_INCREMENT,
text varchar (250) not null,
feedback_user int,
foreign key (feedback_user) references user(user_id),
feedback_product int,
foreign key (feedback_product) references product(product_id));

CREATE TABLE basket(
basket_id int  not null primary key AUTO_INCREMENT,
quantity double not null
);

insert into group_product(group_id, group_name) values
(1,"cakes"),
(2,"biscuit"),
(3,"sweets");


insert into product(product_id,product_name,price,description,product_group) values
(1,"napoleon ",7,"good cake",1),
(2,"honey",5,"good cake",1),
(3,"fruit ",4,"good cake",1),
(4,"gringerbreads",2,"good biscuit",2),
(5,"marshmallow",3,"good biscuit",2),
(6,"red hat",6,"good sweets",3),
(7,"cow",5,"good sweets",3);

