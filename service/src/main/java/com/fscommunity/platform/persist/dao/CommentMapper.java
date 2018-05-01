package com.fscommunity.platform.persist.dao;

import com.fscommunity.platform.persist.pojo.Comment;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

/**
 * @Description
 * @Author jing.c
 * @Date: 18-3-28
 */
@Repository
public interface CommentMapper {

    int insert(Comment record);
    List<Comment> queryCommentsByIds(List<Integer> ids);

    Comment selectById(@Param("id") Integer id);

    int updateById(Comment record);

    int updateAuthStatus(@Param("commentId") int commentId, @Param("status") int status);

    int deleteById(@Param("id") Integer id);

    List<Comment> getCmmtByArticleId(@Param("articleId") Integer articleId,
            RowBounds rowBounds);

    int getCountByArticleId(int articleId);

    List<Comment> list(@Param("articleId") Integer articleId, @Param("authStatus") Integer authStatus,
            @Param("replyStatus") Integer replyStatus,
            RowBounds rowBounds);
    int countList(@Param("articleId") Integer articleId, @Param("authStatus") int authStatus, int replyStatus);

    int setSidById(@Param("id") Integer integer, @Param("sid") Integer sid);

    Comment getByCommentId(@Param("id") int commentId);
}
