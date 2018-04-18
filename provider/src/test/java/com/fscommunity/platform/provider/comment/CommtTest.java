package com.fscommunity.platform.provider.comment;

import com.fscommunity.platform.persist.dao.CommentMapper;
import com.fscommunity.platform.persist.pojo.Comment;
import com.fscommunity.platform.provider.BaseJunit;
import org.apache.ibatis.session.RowBounds;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static junit.framework.TestCase.assertTrue;

/**
 * @Description
 * @Author jing.c
 * @Date: 18-3-28
 */
public class CommtTest extends BaseJunit {
    @Autowired
    CommentMapper commentMapper;

    @Test
    public void listTest() {
        List<Comment> comments = commentMapper.list(null,new RowBounds(0,5));
        for(Comment comment:comments)
            System.out.println(comment.toString());
        assertTrue(comments.size() > 0);
    }


    @Test
    public void getTest() {
        Comment comment = commentMapper.selectById(3);
        System.out.println(comment.toString());
    }

    @Test
    public void insertTest() {
        Comment comment=new Comment();
        comment.setContent("反对萨风格为");

        int rslt = commentMapper.insert(comment);
        System.out.println(rslt);
    }

    @Test
    public void updateTest() {
        Comment comment=new Comment();
        comment.setId(3);
        comment.setContent("faewtreqw");
        comment.setSid(1);
        int rslt = commentMapper.updateById(comment);
        System.out.println(rslt);
    }

    @Test
    public void updateSidTest() {
        int rslt = commentMapper.setSidById(3,2);
        System.out.println(rslt);
    }

    @Test
    public void delTest() {
        int rslt = commentMapper.deleteById(3);
        System.out.println(rslt);
    }
}
