-- 创建测试数据库
create database tytoInitTest_DB
       character set utf8mb4
       collate utf8mb4_unicode_ci;

-- 建立用户表
create table if not exists tytoInitTest_DB.`sys_user`
(
    `id`           bigint                             not null auto_increment              comment '用户id' primary key,
    `userName`     varchar(256)                       null                                 comment '用户昵称 ',
    `userAccount`  varchar(256)                       not null                             comment '用户账号',
    `userRole`     varchar(256) default 'user'        not null                             comment '用户角色 user/admin',
    `userPassword` varchar(256)                       not null                             comment '用户密码',
    `createTime`   datetime default CURRENT_TIMESTAMP not null                             comment '创建时间',
    `updateTime`   datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    `isDelete`     tinyint  default 0                 not null                             comment '逻辑删除(0-未删, 1-已删)'
) comment '用户表';