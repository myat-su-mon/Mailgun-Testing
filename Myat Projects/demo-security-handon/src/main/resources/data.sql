insert ignore into `spring`.`user`(`id`, `username`, `password`, `algorithm`) values
('1', 'john','$2y$12$VyhL2PlidPy1.TtZN3cTqOziV7X8gbcE9cgfBayZDp8SQ4HDQh8Qm','BCRYPT');

insert ignore into `spring`.`authority`(`id`,`name`,`user`) values ('1', 'READ', '1');
insert ignore into `spring`.`authority`(`id`,`name`,`user`) values ('2', 'WRITE', '1');

insert ignore into `spring`.`product`(`id`,`name`,`price`,`currency`) values ('1', 'Chocolate', '10', 'USD');