package com.company.project.annotation;

import java.lang.annotation.*;

/**
 * @author :Libi
 * @version :1.0
 * @date :2020-10-21 15:46
 * 这个注解只能放在controller的参数上，如果一个controller的
 * 方法带有这个参数，就说明这个方法需要鉴权，鉴权的类型也可以自己指定
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER})
@Documented
@Inherited
public @interface RequestToken {
}
