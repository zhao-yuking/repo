-- 参赛作品信息表
-- auto-generated definition
create table work
(
    work_id          bigint(7)    not null comment '作品id号'
        primary key,
    work_name        varchar(512) null comment '作品名称',
    work_group       varchar(512) not null comment '参赛组别',
    work_school      varchar(512) not null comment '参赛学校',
    work_team        varchar(512) null comment '参赛团队',
    work_eligibility varchar(512) null comment '参赛资格',
    work_entry       varchar(512) null comment '参赛报名表存储地址',
    work_publicity   varchar(512) null comment '参赛表信息公示文件地址',
    phone            varchar(128) null comment '联系方式',
    creat_time       varchar(128) null comment '上传时间',
    user_id          bigint(11)   null comment '所属教师',
    work_scord       double(4, 2) null comment '评分',
    work_opinion     varchar(255) null comment '评委意见'
)
    comment '参赛作品信息表';