package com.rjf.mybatis.quickstart.mvc;

/*
 *
 *   Rene
 *   2020/5/26 20:54
 */


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class OnlineListener implements HttpSessionListener {

    private static final Logger logger = LoggerFactory.getLogger(OnlineListener.class);

    private static int count;

    public  void sessionCreated(HttpSessionEvent se) {
        count++;
        logger.info("在线人数监听器 当前人数 : "+count);
    }

    public  void sessionDestroyed(HttpSessionEvent se) {
        count--;
        logger.info("在线人数监听器 当前人数 : "+count);
    }
}
