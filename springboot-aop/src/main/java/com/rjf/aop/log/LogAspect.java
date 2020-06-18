package com.rjf.aop.log;

/*
 *
 *   Rene
 *   2020/6/18 21:31
 */

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

    static Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("@annotation(com.rjf.aop.log.Log)")
    private void log(){}

    @Around("log()")
    public void logRecord(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        logger.warn("日志 当前方法 : "+((MethodSignature)proceedingJoinPoint.getSignature()).getMethod().getName());

        proceedingJoinPoint.proceed();
    }
}
