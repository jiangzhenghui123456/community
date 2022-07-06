package com.newcoder.community.dao;

import com.newcoder.community.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 江江江
 * @version 1.0
 * @description: TODO
 * @date 2022/6/8 21:45
 */
@Mapper
public interface UserMapper {
    // 通过Id查询用户
    User selectById(int id);

    // 通过Name查询用户
    User selectByName(String name);

    // 通过邮箱查找
    User selectByEmail(String email);

    // 插入User 返回插入的条数
    int insertUser(User user);

    // 根据id更新状态
    int updateStatus(int id, String status);

    // 根据id更新头像
    int updateHeader(int id, int header);

    // 根据id更新密码
    int updatePassword(int id, String password);
}
