create database 'logistics_db' ;

use logistics_db;

create table user(
     id int primary key auto_increment,
     name varchar(20),
     password varchar(20)
);


insert into user(name, password) values('admin', 'admin123');


create table logistics_info (
    id int primary key auto_increment,
    number int not null comment '物流编号',
    message varchar(200) comment '物流信息',
    shipping_address varchar(200) not null comment '发货地址',
    delivery_address varchar(200) not null comment '收货地址',
    price decimal(10, 2) default 0  not null comment '价格',
    date datetime default CURRENT_TIMESTAMP not null comment '创建日期',
    courier varchar(20) comment '快递员姓名'
);
