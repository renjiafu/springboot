package com.rjf.aop.aspect;

import com.rjf.aop.web.AopController;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ControllerAspect {

    static Logger logger = LoggerFactory.getLogger(AopController.class);

    @Pointcut("execution(* com.rjf.aop.web.AopController.test(..))")
    public void aopControllerAspect(){
    }

    @Around("aopControllerAspect()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        logger.warn("环绕通知 !!!");

        proceedingJoinPoint.proceed();
    }


}
