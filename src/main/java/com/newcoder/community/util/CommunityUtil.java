package com.newcoder.community.util;

/**
 * @author 江江江
 * @version 1.0
 * @description: TODO
 * @date 2022/7/5 14:48
 */

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.DigestUtils;

import java.util.UUID;

/**
 * 工具类
 */
public class CommunityUtil {
    // 生成随机字符串
    public static String generateUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    // MD5加密
    // key包含了密码和随机的盐
    public static String md5(String key) {
        // 是空
        if (StringUtils.isBlank(key)) {
            return null;
        }
        return DigestUtils.md5DigestAsHex(key.getBytes());
    }
}
