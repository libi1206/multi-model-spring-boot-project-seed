package com.company.project.core.constent;

public enum Code {
    //通用部分
    UNDEFINED(-1, "未定义"),
    SUCCESS(0, "成功"),
    ERROR(1, "失败"),




    UNKNOWN_ABNORMAL(9999,"未知异常");


    private int code;
    private String msg;

    // 构造方法
    Code(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }

    public static String getMsgByCodeInt(int codeInt) {
        for (Code e : Code.values()) {
            if (e.getCode() == codeInt) {
                return e.msg;
            }
        }
        throw new IllegalArgumentException("未定义的code码:" + codeInt);
    }

    public static Code getCodeByCodeInt(int codeInt) {
        for (Code code : Code.values()) {
            if (code.getCode() == codeInt) {
                return code;
            }
        }
        throw new IllegalArgumentException("未定义的code码:" + codeInt);
    }

}
