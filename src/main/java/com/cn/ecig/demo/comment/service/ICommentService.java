package com.cn.ecig.demo.comment.service;

import com.cn.ecig.demo.comment.entity.Comment;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liguang
 * @since 2021-07-20
 */
public interface ICommentService extends IService<Comment> {
    //用户反馈
    void insertComment(String rate,String context,String name);

    //获取用户反馈列表
   List<Comment> getUserComment(String name);
}