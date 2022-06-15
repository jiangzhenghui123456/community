package com.newcoder.community.dao;

import com.newcoder.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {

    // 查询帖子，如果传入用户Id则查此用户的帖子，没传入则查询所有，后面的offset和limit是分页的条件，offset是指数据的起始行数，limit是指一页多少条数据
    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);

    /**
     * @param userId
     * @return
     * @Param注解用于给参数起别名 如果方法只有一个参数，并且在sql的动态语句中使用，怎必须加上别名
     */
    int selectDiscussPostRows(@Param("userId") int userId);

}
