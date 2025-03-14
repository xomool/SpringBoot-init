package com.tyto.project.model.dto.user;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户创建请求体
 */
@Data
public class UserAddRequest implements Serializable {

    private final static long serialVersionUID = 1L;

    private String userName;

    private String userAccount;

    private String userRole;

    private String userPassword;
}
