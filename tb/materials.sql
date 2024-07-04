-- 参赛的材料信息表
-- auto-generated definition
create table materials
(
    team1             varchar(512) null comment '第一个团队视频',
    team2             varchar(512) null comment '第二个团队视频',
    team3             varchar(512) null comment '第三个团队视频',
    team4             varchar(512) null comment '第四个团队视频',
    teaching_thing    varchar(512) null comment '教案文件地址',
    teaching_report   varchar(512) null comment '教学实施报告地址',
    person_program    varchar(512) null comment '专业人才培养方案地址',
    class_information varchar(512) null comment '课程标准信息地址',
    Textbook          varchar(512) null comment '教材选用说明',
    materials_id      bigint       not null comment '材料id'
        primary key,
    work_id           bigint       null comment '所属参赛id组名'
)
    comment '参赛的材料信息表';