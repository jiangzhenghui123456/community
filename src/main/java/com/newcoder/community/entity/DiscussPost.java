package com.newcoder.community.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author 江江江
 * @version 1.0
 * @description: 社区讨论贴功能
 * @date 2022/6/11 15:55
 */
@Data
public class DiscussPost {
    // 帖子的id
    private int id;
    // 帖子用户的id
    private int userId;
    // 帖子的标题
    private String title;
    // 帖子的内容
    private String content;
    // 帖子的类型 置顶1，不置顶0
    private int type;
    // 帖子的状态
    private int status;
    // 帖子的创建时间
    private Date createTime;
    // 帖子的评论数量
    private String commentCount;
    // 帖子的分数（热度）
    private double score;
}
