package com.fscommunity.platform.persist.dao;

import com.fscommunity.platform.persist.pojo.Article;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * @Description
 * @Author jing.c
 * @Date: 18-3-28
 */
public interface ArticleMapper {
    int insert(Article record);

    int insertSelective(Article record);

    int getCount(String fuzzyName);

    List<Article> list(@Param("fuzzyName") String fuzzyName, RowBounds rowBounds);

    Article selectById(@Param("id")Integer id);

    int updateById(Article record);

    int deleteById(@Param("id")Integer id);

    void updateViewsById(@Param("id")Integer integer,@Param("views") Integer views);
}
