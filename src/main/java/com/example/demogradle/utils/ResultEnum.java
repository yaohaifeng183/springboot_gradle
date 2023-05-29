package com.example.demogradle.utils;

/**
 *常用异常状态参数
 *
 * @author yaohaifeng
 */
public enum ResultEnum {

    /**
     * SUCCESS:成功
     * ERROR：失败
     */
    ERROR(0, "error"),
    SUCCESS(200, "success"),
    BAD_REQUEST(400, "参数错误"),
    UNAUTHORIZED(401, "未授权"),

    /**
     * 系统错误返回码
     */
    UNKNOWN_ERROR(-1, "未知错误"),
    FAIL(10001, "系统失败"),
    UNAUTHENTICATED(10002, "您还未登录"),
    SERVER_ERROR(99999, "系统繁忙");

    private final Integer code;
    private final String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }
}