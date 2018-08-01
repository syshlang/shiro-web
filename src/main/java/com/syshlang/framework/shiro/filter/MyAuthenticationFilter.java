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

    /**
     * 表示是否允许访问；
     * @param request
     * @param response
     * @param mappedValue mappedValue就是[urls]配置中拦截器参数部分
     * @return 如果允许访问返回true，否则false；
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        return super.isAccessAllowed(request, response, mappedValue);
    }

    /**
     * 表示当访问拒绝时是否已经处理了；
     * @param request
     * @param response
     * @param mappedValue
     * @return  如果返回true表示需要继续处理；
     *          如果返回false表示该拦截器实例已经处理了，将直接返回即可。
     * @throws Exception
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        return super.onAccessDenied(request, response, mappedValue);
    }

    /**
     * 表示当访问拒绝时是否已经处理了；
     * @param servletResponse
     * @param servletRequest
     * @return  如果返回true表示需要继续处理；
     *          如果返回false表示该拦截器实例已经处理了，将直接返回即可。
     * @throws Exception
     */
    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        return false;
    }
}
