/*
 * Copyright (c) 2018. Syshlang
 * @File: sessionDao.java
 * @Description:
 * @Author: sunys
 * @Date: 18-7-31 下午1:52
 * @since:
 */

package com.syshlang.framework.shiro.session;

import com.syshlang.framework.util.SerializableUtil;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.CachingSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * 基于redis的sessionDao，缓存共享session
 * Created by sunys on 2018/7/31.
 */
public class sessionDao extends CachingSessionDAO {
    private static final Logger LOGGER = LoggerFactory.getLogger(sessionDao.class);
    @Override
    protected void doUpdate(Session session) {

    }

    @Override
    protected void doDelete(Session session) {

    }

    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = generateSessionId(session);
        assignSessionId(session, sessionId);
        //放入redis缓存
        LOGGER.debug("doCreate >>>>> sessionId={}", sessionId);
        return sessionId;
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        //从redis中读取session
        String session="";
        LOGGER.debug("doReadSession >>>>> sessionId={}", sessionId);
        return SerializableUtil.deserialize(session);
    }
}
