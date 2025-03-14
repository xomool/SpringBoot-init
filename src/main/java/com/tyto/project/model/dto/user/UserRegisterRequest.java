package com.tyto.project.model.dto.user;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户注册 请求体
 */
@Data
public class UserRegisterRequest implements Serializable {

    private final static long serialVersionUID = 1L;

    private String userAccount;

    private String userPassword;

    private String checkPassword;
}
