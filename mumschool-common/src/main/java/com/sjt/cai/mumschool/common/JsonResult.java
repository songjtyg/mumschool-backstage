package com.sjt.cai.mumschool.common;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by houwanhua on 2018/02/23.
 * @author houwanhua
 */
@Data
@AllArgsConstructor
public class JsonResult<T> implements Serializable {
    /**
     * 操作是否成功，默认为true
     */
    private boolean isSuccess = true;
    /**
     * 提示给用户看的信息，不管是成功还是失败的
     */
    private String message;
    /**
     * 错误码
     */
    private String errCode;
    /**
     * 返回给前端的数据对象
     */
    private T data;

    public JsonResult() {
    }

    public JsonResult(boolean isSuccess, String message) {
        this.isSuccess = isSuccess;
        this.message = message;
    }

    public JsonResult(boolean isSuccess,String message,T data){
        this.isSuccess = isSuccess;
        this.message = message;
        this.data = data;
    }

    /**
     * 返回一条信息，自定义成功或失败状态
     * @param success
     * @param message
     * @return
     */
    public static JsonResult message(boolean success, String message) {
        return new JsonResult(success, message);
    }

    /**
     * 失败，自定义错误提示
     * @param message
     * @return
     */
    public static JsonResult faultMessage(String message) {
        return new JsonResult(false, message = message);
    }

    /**
     * 失败，使用默认提示
     * @return
     */
    public static JsonResult faultMessage() {
        return new JsonResult(false, "操作失败");
    }

    /**
     * 成功：有需要返回Date信息,自定义成功提示
     * @param data
     * @param message
     * @return
     */
    public static<T> JsonResult success(T data, String message) {
        return new JsonResult(true, message,data);
    }

    /**
     * 成功：有需要返回Date信息
     * @param data
     * @return
     */
    public static<T> JsonResult success(T data) {
        return new JsonResult(true, "操作成功",data);
    }

    /**
     * 失败：返回错误信息
     * @param errCode
     * @param message
     * @return
     */
    public static JsonResult errorsInfo(String errCode, String message) {
        return new JsonResult(false, message, errCode, null);
    }
}
