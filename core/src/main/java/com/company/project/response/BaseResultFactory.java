package com.company.project.response;


import com.company.project.constent.Code;

public final class BaseResultFactory {


    public static BaseResult produceEmptyResult(Code code) {
        return new BaseResult(code);
    }

    public static BaseResult produceEmptyResult(int codeInt, String msg) {
        return new BaseResult(codeInt, msg);
    }

    public static BaseResult produceResult(int codeInt, String msg, Object data) {
        return new BaseResult(codeInt, msg, data);
    }

    public static BaseResult produceResult(Code code, Object data) {
        return new BaseResult(code.getCode(), code.getMsg(), data);
    }


}
