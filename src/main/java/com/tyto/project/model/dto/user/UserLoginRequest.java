package com.tyto.project.model.dto.user;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户登录请求体
 */
@Data
public class UserLoginRequest implements Serializable {

    private final static long serialVersionUID = 1L;

    private String userAccount;

    private String userPassword;
}
