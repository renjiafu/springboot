package com.rjf.mybatis.mvc.filter;

/*
 *
 *   Rene
 *   2020/5/26 20:40
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "AuthFilter", urlPatterns = {"/*"})
public class AuthFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(AuthFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("初始化 Auth过滤器 !");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        if ("666666".equals(httpServletRequest.getHeader("account")) || null == httpServletRequest.getHeader("account")) {
            logger.info("权限过滤器 account : " + httpServletRequest.getHeader("account"));
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        logger.info("销毁 Auth过滤器 !");
    }
}
