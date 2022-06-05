package com.newcoder.community.service;

import com.newcoder.community.dao.AlphaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 江江江
 * @version 1.0
 * @description: TODO
 * @date 2022/6/4 13:09
 */
@Service
public class AlphaService {

    @Autowired
    private AlphaDao alphaDao;

    public String find() {
        return alphaDao.select();
    }
}
