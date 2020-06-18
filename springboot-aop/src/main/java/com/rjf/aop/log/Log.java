package com.rjf.aop.log;

/*
 *
 *   Rene
 *   2020/6/18 21:29
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Log {

    public String value() default "";
}
