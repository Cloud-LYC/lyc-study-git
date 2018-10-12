-- auto-generated definition
create table user
(
  id            int auto_increment
  comment '数据库自增ID',
  user_name     varchar(30) not null
  comment '用户名',
  user_password varchar(30) not null
  comment '用户登录密码',
  constraint user_id_uindex
  unique (id)
)
  comment '用户信息表'
  charset = utf8;

alter table user
  add primary key (id);


INSERT INTO `lycstudy`.`user` (`user_name`, `user_password`) VALUES ('lyc', '123456')