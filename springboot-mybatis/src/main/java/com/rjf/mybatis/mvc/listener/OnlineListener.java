package com.rjf.mybatis.mvc.listener;

/*
 *
 *   Rene
 *   2020/5/26 20:54
 */


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


@WebListener(value = "onlineListener")
public class OnlineListener implements HttpSessionListener {

    private static final Logger logger = LoggerFactory.getLogger(OnlineListener.class);

    private static int count;

    public  void sessionCreated(HttpSessionEvent se) {

        logger.info("创建session sessionId : "+se.getSession().getId());
        count++;
        logger.info("在线人数监听器 当前人数 : "+count);
    }

    public  void sessionDestroyed(HttpSessionEvent se) {

        logger.info("销毁session sessionId : "+se.getSession().getId());
        count--;
        logger.info("在线人数监听器 当前人数 : "+count);
    }
}
