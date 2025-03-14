package com.tyto.project.exception;

import com.tyto.project.common.ErrorCode;

/**
 * 自定义异常类
 */
public class BusinessException extends RuntimeException{

    private final int code;

    /**
     * 自定义异常
     * @param code 自定义状态码
     * @param message 自定义信息
     */
    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
    }

    /**
     * 自定义异常
     * @param errorCode 错误码(应用错误码、信息)
     */
    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
    }

    /**
     * 自定义异常
     * @param errorCode 错误码
     * @param message 自定义信息
     */
    public BusinessException(ErrorCode errorCode, String message) {
        super(message);
        this.code = errorCode.getCode();
    }

    public int getCode() {
        return code;
    }
}
