package com.company.project.core.response;

import com.alibaba.fastjson.JSONObject;
import com.company.project.core.constent.Code;

/**
 * Created by superlee on 2017/11/6.
 */
@SuppressWarnings("unchecked")
public final class BaseResult<T> {
    private int code;
    private String message;
    private T data;

    public BaseResult() {
        //空对象json串
        this.data = (T) JSONObject.toJSON(new Object());
    }

    public BaseResult(String msg) {
        this();
        this.code = 200;
        this.message = msg;
    }

    public BaseResult(int code, String message) {
        this();
        this.code = code;
        this.message = message;
    }

    public BaseResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    // 与Code码交互
    public BaseResult(Code code) {
        this();
        this.code = code.getCode();
        this.message = code.getMsg();
    }

    /**
     * 返回结果代码code和消息msg，不需要返回值
     *
     * @param code 结果类型
     */
    public final void returnWithoutValue(Code code) {
        this.code = code.getCode();
        this.message = code.getMsg();
    }

    /**
     * 返回结果代码code和消息msg，并返回值
     *
     * @param code   结果类型
     * @param object 返回值
     */
    public final void returnWithValue(Code code, T object) {
        returnWithoutValue(code);
        this.data = object;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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

    @Override
    public String toString() {
        return "BaseResult{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
