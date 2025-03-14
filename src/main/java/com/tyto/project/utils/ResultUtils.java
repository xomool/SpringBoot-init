package com.tyto.project.utils;

import com.tyto.project.common.BaseResponse;
import com.tyto.project.common.ErrorCode;

/**
 * 返回工具
 */
public class ResultUtils {

    /**
     * 成功
     * @param data 返回数据
     */
    public static <T> BaseResponse<T> success(T data) {
        return new BaseResponse<>(0, data, "ok");
    }

    /**
     * 失败 使用错误吗返回
     * @param errorCode 错误码
     */
    public static BaseResponse error(ErrorCode errorCode) {
        return new BaseResponse(errorCode);
    }

    /**
     * 失败
     * @param code 自定义错误码
     * @param message 自定义错误信息
     */
    public static BaseResponse error(int code, String message) {
        return new BaseResponse(code, null, message);
    }

    /**
     * 失败
     * @param errorCode 选择错误码
     * @param message 自定义错误信息
     */
    public static BaseResponse error(ErrorCode errorCode, String message) {
        return new BaseResponse(errorCode.getCode(), null, message);
    }
}
