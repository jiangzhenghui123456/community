package com.newcoder.community.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author 江江江
 * @version 1.0
 * @description: User实体类
 * @date 2022/6/8 20:56
 */
@Data
public class User {
    // id
    private int id;
    //姓名
    private String username;
    //密码
    private String password;
    //密码盐
    private String salt;
    //邮箱
    private String email;
    //类型 管理员、普通用户等
    private int type;
    //状态
    private String status;
    //激活码
    private String activationCode;
    //创建时间
    private Date createTime;
    // 头像路径
    private String headerUrl;
}
