package com.imooc.uaa.common;

public class Constants {
    public static final String PROBLEM_BASE_URI = "https://imooc.com";
    // ---- 正则表达式相关 ----
    public static final String PATTERN_MOBILE = "^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\\d{8}$";
    public static final String PATTERN_USERNAME = "^[a-z0-9_-]{3,50}$";
    public static final String PATTERN_ROLE_NAME = "^[a-zA-Z0-9_]{3,50}$";
    // ---- 授权相关 ----
    public static final String ROLE_PREFIX = "ROLE_";
    public static final String AUTHORITY_USER = "USER";
    public static final String AUTHORITY_STAFF = "STAFF";
    public static final String AUTHORITY_MANAGER = "MANAGER";
    public static final String AUTHORITY_ADMIN = "ADMIN";
    public static final String ROLE_USER = ROLE_PREFIX + AUTHORITY_USER;
    public static final String ROLE_STAFF = ROLE_PREFIX + AUTHORITY_STAFF;
    public static final String ROLE_MANAGER = ROLE_PREFIX + AUTHORITY_MANAGER;
    public static final String ROLE_ADMIN = ROLE_PREFIX + AUTHORITY_ADMIN;
    public static final String AUTHORITY_USER_ADMIN = "USER_ADMIN";
    public static final String AUTHORITY_USER_UPDATE = "USER_UPDATE";
    public static final String AUTHORITY_USER_CREATE = "USER_CREATE";
    public static final String AUTHORITY_USER_READ = "USER_READ";
    // ---- 缓存相关 ----
    public static final String CACHE_MFA = "cacheMfa";
    public static final String CACHE_ALL_PERMISSIONS = "cacheAllPermissions";
    public static final String CACHE_ALL_ROLES = "cacheAllRoles";
}
