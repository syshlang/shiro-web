/*
 * Copyright (c) 2018. Syshlang
 * @File: SessionForceLogoutFilter.java
 * @Description:
 * @Author: sunys
 * @Date: 18-7-31 下午1:31
 * @since:
 */

package com.syshlang.framework.shiro.filter;

import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 *  强制退出会话过滤器
 * @author sunys
 * @date 2018/7/31
 */
public class SessionForceLogoutFilter extends AccessControlFilter {
    private static final Logger LOGGER = LoggerFactory.getLogger(SessionForceLogoutFilter.class);

    /**
     * 强制退出后重定向的地址
     */
    /*@Value("${shiro.user.loginUrl}")
    private String loginUrl;*/

    /**
     *
     * @param servletRequest
     * @param servletResponse
     * @param mappedValue
     * @return
     * @throws Exception
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object mappedValue) throws Exception {
        Subject subject = getSubject(servletRequest, servletResponse);
        if (subject == null || subject.getSession() == null)
        {
            return true;
        }

        Session session = getSubject(servletRequest, servletResponse).getSession(false);
        if(session == null) {
            return true;
        }
        boolean forceout = session.getAttribute("FORCE_LOGOUT") == null;
        return  forceout;
    }

    /**
     *
     * @param servletRequest
     * @param servletResponse
     * @return
     * @throws Exception
     */
    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        getSubject(servletRequest, servletResponse).logout();
        String loginUrl = getLoginUrl() + (getLoginUrl().contains("?") ? "&" : "?") + "forceLogout=1";
        WebUtils.issueRedirect(servletRequest, servletResponse, loginUrl);
        return false;
    }

    /**
     * 跳转到登录页
     * @param request
     * @param response
     * @throws IOException
     */
    @Override
    protected void redirectToLogin(ServletRequest request, ServletResponse response) throws IOException
    {
        WebUtils.issueRedirect(request, response, getLoginUrl());
    }
}
