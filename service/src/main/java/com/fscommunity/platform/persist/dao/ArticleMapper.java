package com.fscommunity.platform.persist.dao;

import com.fscommunity.platform.persist.pojo.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description
 * @Author jing.c
 * @Date: 18-3-28
 */
public interface ArticleMapper {
    int insert(Article record);

    int insertSelective(Article record);

    List<Article> list(@Param("condition") String conditiion);

    Article selectById(@Param("id")Integer id);

    int updateById(Article record);

    int deleteById(Integer id);
}
