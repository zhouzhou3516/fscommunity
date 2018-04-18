package com.fscommunity.platform.service;

import com.fscommunity.platform.persist.dao.CommentMapper;
import com.fscommunity.platform.persist.pojo.Comment;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.lxx.app.common.util.Base64Util;
import com.lxx.app.common.util.page.PageRequest;
import org.apache.commons.collections.CollectionUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @Description
 * @Author jing.c
 * @Date: 18-4-11
 */
@Service
public class CommentService {
    @Autowired
    CommentMapper commentMapper;

    public List<Comment> list(String condition, PageRequest pageRequest) {

        List<Comment> comments = commentMapper.list(condition,
                new RowBounds(pageRequest.getOffset(),pageRequest.getLimit())
        );
        for(Comment comment: comments){
            comment.setContent(Base64Util.encode(comment.getContent()));
        }
        return comments;
    }

    public int updateAuthStatus(int id, boolean status) {
        return commentMapper.updateAuthStatus(!status ?0:1, id);
    }

    public List<Comment> getByArticleId(int articleId, PageRequest pageRequest) {
        List<Comment> comments = commentMapper.getCmmtByArticleId(articleId,
                new RowBounds(pageRequest.getOffset(),pageRequest.getLimit())
        );
        for(Comment comment: comments){
            comment.setContent(comment.getContent());
        }
        return comments;
    }

    public List<Comment> queryCommentsByIds(List<Integer> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return Collections.EMPTY_LIST;
        }

        return commentMapper.queryCommentsByIds(ids);
    }

    public void add(Comment comment) {
        Preconditions.checkNotNull(comment);
        commentMapper.insert(comment);
    }

    public Comment selectById(String id) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(id));
        Comment article = commentMapper.selectById(Integer.valueOf(id));
        article.setContent(Base64Util.decode(article.getContent()));
        return article;
    }

    public void delById(String id) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(id));
        commentMapper.deleteById(Integer.valueOf(id));
    }

    public void updateById(Comment comment) {
        Preconditions.checkNotNull(comment);
        comment.setContent(Base64Util.encode(comment.getContent()));
        commentMapper.updateById(comment);
    }

//    public void updateViewsById(String id,String views) {
//        Preconditions.checkArgument(!Strings.isNullOrEmpty(id));
//        Preconditions.checkArgument(!Strings.isNullOrEmpty(views));
//        commentMapper.updateViewsById(Integer.valueOf(id),Integer.valueOf(views));
//    }

    public int getCount(int articleId) {
        return commentMapper.getCountByArticleId(articleId);
    }

//    public int displayCmmt(String id) {
//        Preconditions.checkArgument(!Strings.isNullOrEmpty(id));
//        return commentMapper.displayCmmt(Integer.valueOf(id));
//    }

    public int setSidById(String id,String sid) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(id));
        Preconditions.checkArgument(!Strings.isNullOrEmpty(sid));
        return commentMapper.setSidById(Integer.valueOf(id),Integer.valueOf(sid));
    }
}
