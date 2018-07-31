/*
 * Copyright (c) 2018. Syshlang
 * @File: UpmsAuthenticationFilter.java
 * @Description:
 * @Author: sunys
 * @Date: 18-7-31 下午1:19
 * @since:
 */

package com.syshlang.framework.shiro.filter;

import org.apache.shiro.web.filter.authc.AuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 重写authc过滤器
 * @author sunys
 * @date 2018/7/31
 */
public class MyAuthenticationFilter extends AuthenticationFilter {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyAuthenticationFilter.class);

    public MyAuthenticationFilter() {
        super();
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        return super.isAccessAllowed(request, response, mappedValue);
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        return super.onAccessDenied(request, response, mappedValue);
    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        return false;
    }
}
