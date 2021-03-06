package com.cn.ecig.demo.comment.mapper;

import com.cn.ecig.demo.comment.entity.Comment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author liguang
 * @since 2021-07-20
 */
public interface CommentMapper extends BaseMapper<Comment> {
    List<Comment> getfeedbackunsolved (String phoneNumber);
}
