package com.fscommunity.platform.persist.dao;

import com.fscommunity.platform.persist.pojo.Comment;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * @Description
 * @Author jing.c
 * @Date: 18-3-28
 */
public interface CommentMapper {
    int insert(Comment record);

    int getCountByArticleId();

    List<Comment> list(@Param("condition") String conditiion, RowBounds rowBounds);

    List<Comment> queryCommentsByIds(List<Integer> ids);

    Comment selectById(@Param("id") Integer id);

    int updateById(Comment record);

    int updateAuthStatus(@Param("showed") int showed, @Param("id") int id);

    int deleteById(@Param("id") Integer id);

    List<Comment> getCmmtByArticleId(Integer articleId, RowBounds rowBounds);



    int setSidById(@Param("id")Integer integer,@Param("sid") Integer sid);
}
