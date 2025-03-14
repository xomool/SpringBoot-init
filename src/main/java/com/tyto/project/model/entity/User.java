package com.tyto.project.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户
 * TableName user
 */
@Data
@TableName(value = "sys_user")
public class User implements Serializable {

    @TableField(exist = false)
    private final static long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Long id;

    private String userName;

    private String userAccount;

    /**
     * 用户角色: user, admin
     */
    private String userRole;

    private String userPassword;

    private Date createTime;

    private Date updateTime;

    @TableLogic
    private Integer isDelete;
}
