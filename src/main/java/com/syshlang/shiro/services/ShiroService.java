/*
 * Copyright (c) 2018. syshlang
 * @File: ShiroService.java
 * @Description:
 * @Author: sunys
 * @Date: 18-7-28 下午10:37
 * @since:
 */

package com.syshlang.shiro.services;

import java.util.Date;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.session.Session;

/**
 * @author sunys
 */
public class ShiroService {

    @RequiresRoles({"admin"})
    public void testMethod(){
        System.out.println("testMethod, time: " + new Date());

        Session session = SecurityUtils.getSubject().getSession();
        Object val = session.getAttribute("key");

        System.out.println("Service SessionVal: " + val);
    }

}
 