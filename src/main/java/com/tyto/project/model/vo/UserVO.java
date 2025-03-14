package com.tyto.project.model.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户视图
 */
@Data
public class UserVO implements Serializable {

    private final static long serialVersionUID = 1L;

    private Long id;

    private String userName;

    private String userAccount;

    private String userRole;

    private Date createTime;

    private Date updateTime;
}
