package com.tyto.project.model.dto.user;

import com.tyto.project.common.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户查询请求提
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserQueryRequest extends PageRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String userName;

    private String userAccount;

    private String userRole;

    private Date createTime;

    private Date updateTime;
}
