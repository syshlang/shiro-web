/*
 * Copyright (c) 2018. Syshlang
 * @File: MySessionFactory.java
 * @Description:
 * @Author: sunys
 * @Date: 18-7-31 下午2:00
 * @since:
 */

package com.syshlang.framework.shiro.session;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SessionContext;
import org.apache.shiro.session.mgt.SessionFactory;

/**
 * Created by sunys on 2018/7/31.
 */
public class MySessionFactory implements SessionFactory {
    @Override
    public Session createSession(SessionContext sessionContext) {
        return null;
    }
}
