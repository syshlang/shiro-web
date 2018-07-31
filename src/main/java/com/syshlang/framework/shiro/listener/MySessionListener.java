/*
 * Copyright (c) 2018. Syshlang
 * @File: SessionListener.java
 * @Description:
 * @Author: sunys
 * @Date: 18-7-31 下午1:59
 * @since:
 */

package com.syshlang.framework.shiro.listener;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author sunys
 * @date 2018/7/31
 */
public class MySessionListener  implements SessionListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(MySessionListener.class);

    @Override
    public void onStart(Session session) {
        LOGGER.debug("会话创建：" + session.getId());
    }

    @Override
    public void onStop(Session session) {
        LOGGER.debug("会话停止：" + session.getId());
    }

    @Override
    public void onExpiration(Session session) {
        LOGGER.debug("会话过期：" + session.getId());
    }
}
