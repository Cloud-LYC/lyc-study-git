package com.helpdocument.dto;

import java.io.Serializable;

/**
 * create by IntelliJ IDEA.
 * Date: 18/1/10
 * Time: 15:02
 *
 */
public class CommonResponse<T> implements Serializable {

    private static final long serialVersionUID = -7502579798933626192L;

    private boolean result;

    /**
     * 结果码  成功:200 失败:500
     */
    private int code;

    /**
     * 结果描述信息
     */
    private String message;

    /**
     * 返回结果
     */
    T data;

    public CommonResponse(boolean result, int code, T data, String message) {
        this.result = result;
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public static <T> CommonResponse<T> buildSuccessResponse(T data) {
        return new CommonResponse<T>(true, 200, data, "success");
    }

    public static <T> CommonResponse<T> buildSuccessResponse(T data, String message) {
        return new CommonResponse<T>(true, 200, data, message);
    }

    public static <T> CommonResponse<T> buildFailResponse(String message) {
        return new CommonResponse<T>(false, 500, null, message);
    }

    public static <T> CommonResponse<T> buildFailResponse(int code, String message) {
        return new CommonResponse<T>(false, code, null, message);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

