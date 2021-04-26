package com.yinxf.springcore7;

import java.lang.annotation.*;

/**
 * @author yinxf
 * @date 2020-04-29
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface GPRequestParam {
    String value() default "";
}
