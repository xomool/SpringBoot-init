package com.tyto.project.common;

import lombok.Data;

import java.io.Serializable;

/**
 * 通用返回类
 */
@Data
public class BaseResponse<T> implements Serializable {

    private final static long serialVersionUID = 1L;

    // 返回状态码
    private int code;
    // 返回数据
    private T data;
    // 返回信息
    private String message;

    public BaseResponse(int code, T data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }
    // 无返回信息
    public BaseResponse(int code, T data) {
        this(code, data, "");
    }
    // 根据错误码返回信息
    public BaseResponse(ErrorCode errorCode) {
        this(errorCode.getCode(), null, errorCode.getMessage());
    }
}
