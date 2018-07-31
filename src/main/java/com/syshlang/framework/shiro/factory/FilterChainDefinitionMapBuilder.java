/*
 * Copyright (c) 2018. syshlang
 * @File: FilterChainDefinitionMapBuilder.java
 * @Description:
 * @Author: sunys
 * @Date: 18-7-28 下午10:37
 * @since:
 */

package com.syshlang.framework.shiro.factory;

import java.util.LinkedHashMap;

/**
 * @author sunys
 */
public class FilterChainDefinitionMapBuilder {
    public LinkedHashMap<String, String> buildFilterChainDefinitionMap() {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("/login.jsp", "anon");
        map.put("/shiro/login", "anon");
        map.put("/shiro/logout", "logout");
        map.put("/user.jsp", "sessionForceLogout,authc,roles[user]");
        map.put("/admin.jsp", "sessionForceLogout,authc,roles[admin]");
        map.put("/list.jsp", "user");
        map.put("/**", "sessionForceLogout,authc");
        return map;
    }
}
