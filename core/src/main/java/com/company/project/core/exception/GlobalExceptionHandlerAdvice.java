package com.company.project.core.exception;


import com.company.project.core.constent.Code;
import com.company.project.core.response.BaseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 *
 * @author superlee
 * @date 2017/11/6
 * 全局异常处理
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandlerAdvice {

    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public BaseResult handleBusinessException(BusinessException be) {
        log.error(be.getMsg());
        be.printStackTrace();
        return be.getBaseResult();
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public BaseResult handleDefaultException(Exception be) {
        log.error(be.getMessage());
        be.printStackTrace();
        return new BaseResult(Code.UNKNOWN_ABNORMAL.getCode(), Code.UNKNOWN_ABNORMAL.getMsg(), be.getMessage());
    }


}
