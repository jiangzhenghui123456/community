package com.newcoder.community.util;

/**
 * @author 江江江
 * @version 1.0
 * @description: TODO
 * @date 2022/7/5 16:53
 */

// 一些常量
public interface CommunityConstant {
    /**
     * 激活成功
     */
    int ACTIVATION_SUCCESS = 0;

    /**
     * 激活失败
     */
    int ACTIVATION_FAIL = 2;

    /**
     * 激活成功
     */
    int ACTIVATION_REPEAT = 1;

    /**
     * 默认状态的登录凭证超时时间
     */
    int DEFAULT_EXPIRED_SECONDE = 3600 * 12;

    /**
     * 记录状态的登录凭证超时时间
     */
    int REMEMBER_EXPIRED_SECONDS = 3600 * 24 * 100;
}
