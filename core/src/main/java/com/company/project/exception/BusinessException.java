package com.company.project.exception;


import com.company.project.constent.Code;

/**
 * 业务异常
 */
public final class BusinessException extends BaseException {
    public BusinessException() {
    }

    public BusinessException(Code code) {
        super(code.getCode(), code.getMsg());
    }

    public BusinessException(int codeInt, String errorMsg) {
        super(codeInt, errorMsg);
    }
}
