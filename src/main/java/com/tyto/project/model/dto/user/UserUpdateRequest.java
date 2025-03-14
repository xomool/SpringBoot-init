package com.tyto.project.model.dto.user;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户更新请求体
 */
@Data
public class UserUpdateRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String userName;

    private String userAccount;

    /**
     * 用户角色: user, admin
     */
    private String userRole;

    private String userPassword;
}
