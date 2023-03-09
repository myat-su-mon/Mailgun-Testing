create table if not exists `spring`.`user`(
    `id` int not null auto_increment,
    `username` varchar (45) not null,
    `password` text not null,
    `algorithm` varchar (45) not null,
    primary key (`id`)
);

create table if not exists `spring`.`authority`(
    `id` int not null auto_increment,
    `name` varchar (45) not null,
    `user` int not null,
    primary key (`id`)
);

create table if not exists `spring`.`product`(
    `id` int not null auto_increment,
    `name` varchar (45) not null,
    `price` varchar (45) not null,
    `currency` varchar (45) not null,
    primary key (`id`)
);

