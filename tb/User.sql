
-- 用户账号表
-- auto-generated definition
create table user
(
    user_account  varchar(512)  not null comment '用户账号',
    user_password varchar(512)  not null,
    user_image    varchar(512)  null comment '用户头像连接',
    user_id       bigint        not null comment '用户id'
        primary key,
    status        int default 0 not null comment '用于判断登录账号身份 0：评委 1：教师 2：管理'
)
    comment '用户账号表';

