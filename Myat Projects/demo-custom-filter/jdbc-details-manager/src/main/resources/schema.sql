
create table users(
    id int not null,
    username varchar (45) null,
    password varchar (45) null ,
    enabled int not null,
    primary key(id));

create table authorities(
    id int not null,
    username varchar (45) null,
    authority varchar (45) null,
    primary key(id));
