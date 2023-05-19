package com.example.demogradle.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 接口返回数据格式
 * @param <T>
 */
public class Result<T> {

    private int code;       // 状态码
    private String msg;     // 返回的信息
    private T data;         // 返回的数据

    /**
     * 成功时候的调用（有数据）
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result<T> success(T data){
        return new Result<T>(data);
    }

    /**
     * 成功时候的调用（无数据）
     * @param <T>
     * @return
     */
    public static <T> Result<T> success(){
        return new Result<T>();
    }

    /**
     * 异常时候的调用（有msg参数）
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> Result<T> error(String msg){
        return new Result<T>(msg);
    }

    /**
     * 异常时候的调用（无msg参数）
     * @param <T>
     * @return
     */
    public static <T> Result<T> error(){
        return new Result<T>("error");
    }

    /**
     * 配合ResultEnum错误枚举类使用，如果没有ResultEnum枚举类，需要删除此方法
     * @param resultEnum
     * @param <T>
     * @return
     */
    public static <T> Result<T> error(ResultEnum resultEnum){
        Result result = new Result();
        result.setCode(resultEnum.getCode());
        result.setMsg(resultEnum.getMsg());
        return result;
    }

    /**
     * 增强版，增加把error级别日志输出到日志文件，但是很鸡肋，纯属闲的，没卵用
     * 配合ResultEnum错误枚举类使用，如果没有ResultEnum枚举类，需要删除此方法
     * @param resultEnum
     * @param <T>
     * @return
     */
    public static <T> Result<T> error(ResultEnum resultEnum,Class cl){
        Result result = new Result();
        result.setCode(resultEnum.getCode());
        result.setMsg(resultEnum.getMsg());
        Logger logger = LoggerFactory.getLogger(cl);
        logger.error(resultEnum.getMsg());
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
