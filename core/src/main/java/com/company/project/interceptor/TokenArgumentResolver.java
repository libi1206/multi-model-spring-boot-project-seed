package com.company.project.interceptor;

import com.company.project.annotation.RequestToken;
import com.company.project.model.TokenInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * @author :Libi
 * @version :1.0
 * @date :2020-10-21 15:56
 * 用来拦截需要解析token的操作权限认证就在这里了
 */
@Slf4j
@Component
public class TokenArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        //这里可以根据methodParameter对象来判断是否命中需要拦截的部分。如果返回true，则会进入到resolveArgument方法中进行处理
        return methodParameter.hasParameterAnnotation(RequestToken.class) &&
                methodParameter.getParameterType().isAssignableFrom(TokenInfo.class);
    }

    @Override
    public TokenInfo resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        log.info("进入权限校验，uri:{} 方法名: {} 参数名: {}",nativeWebRequest.getContextPath(), methodParameter.getMethod().getName(), methodParameter.getParameterName());
        //获取参数上的注解，可以用来进行深层次的权限校验
        RequestToken methodAnnotation = methodParameter.getMethodAnnotation(RequestToken.class);

        //获取Token字段并且解析成对象返回
//        String jwtStr = nativeWebRequest.getHeader(BaseConstant.X_ACCESS_TOKEN);
        TokenInfo tokenInfo = TokenInfo.builder().userId("123").userName("libi1206").build();
        return tokenInfo;
    }


}
