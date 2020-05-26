package com.rjf.mybatis.quickstart.mvc;

/*
 *
 *   Rene
 *   2020/5/26 21:23
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class PerformanceInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(PerformanceInterceptor.class);


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("性能拦截器 !");
        return  true;
    }
}
