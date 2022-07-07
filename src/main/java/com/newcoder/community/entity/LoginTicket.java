package com.newcoder.community.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author 江江江
 * @version 1.0
 * @description: TODO
 * @date 2022/7/7 15:22
 */
@Data
public class LoginTicket {
    // id
    private int id;

    // 用户id
    private int userId;

    // 凭证
    private String ticket;

    // 登录状态
    private int status;

    // 过期时间
    private Date expired;
}
