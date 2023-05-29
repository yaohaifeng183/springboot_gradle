package com.example.demogradle.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 接口返回数据格式
 * @author yaohaifeng
 * @param <T>
 */
public class Result<T> {

    /**
     * 状态码
     */
    private int code;

    /**
     * 返回的信息
     */
    private String msg;

    /**
     * 返回的数据
     */
    private T data;

    /**
     * 成功时候的调用（有数据）
     * @param data 数据对象
     * @param <T>
     * @return
     */
    public static <T> Result<T> success(T data){
        return new Result<T>(data);
    }

    /**
     * 成功时候的调用（无数据）
     *
     * @param <T>
     * @return 警告消息
     */
    public static <T> Result<T> success(){
        return new Result<T>();
    }

    /**
     * 异常时候的调用（有msg参数）
     * @param msg 错误信息
     * @return 警告消息
     */
    public static <T> Result<T> error(String msg){
        return new Result<T>(msg);
    }

    /**
     * 异常时候的调用（无msg参数）
     * @return 警告消息
     */
    public static <T> Result<T> error(){
        return new Result<T>("error");
    }

    /**
     * 配合ResultEnum错误枚举类使用，如果没有ResultEnum枚举类，需要删除此方法
     * @param resultEnum 错误信息枚举类对象
     * @return 警告消息
     */
    public static <T> Result<T> error(ResultEnum resultEnum){
        Result result = new Result();
        result.setCode(resultEnum.getCode());
        result.setMsg(resultEnum.getMsg());
        return result;
    }

    private Result(T data) {
        this.code = 200;
        this.msg = "success";
        this.data = data;
    }

    public Result() {
        this.code = 200;
        this.msg = "success";
    }

    private Result(String msg) {
        this.code = 400;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(T data) {
        this.data = data;
    }
}
