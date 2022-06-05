package com.newcoder.community.dao;

import org.springframework.stereotype.Repository;

/**
 * @author 江江江
 * @version 1.0
 * @description: TODO
 * @date 2022/6/4 13:09
 */

@Repository
public class AlphaDaoImp implements AlphaDao {
    @Override
    public String select() {
        return "nihao";
    }
}
