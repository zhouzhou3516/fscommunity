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

    int insertSelective(Comment record);

    int getCount();

    List<Comment> list(@Param("condition") String conditiion, RowBounds rowBounds);

    Comment selectById(@Param("id") Integer id);

    int updateById(Comment record);

    int deleteById(@Param("id") Integer id);

    void updateViewsById(@Param("id") Integer integer, @Param("views") Integer views);

    List<Comment> getCmmtByArticleId(@Param("condition") String condition, Integer integer, RowBounds rowBounds);

    int displayCmmt(Integer integer);

    int setSidById(@Param("id")Integer integer,@Param("sid") Integer sid);
}
