package com.fscommunity.platform.persist.dao;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import com.fscommunity.platform.persist.pojo.ConveniencePhone;

import java.util.List;

/**
 * @author chao.zhu
 * @version 2018-04-15
 */
@Repository
public interface ConveniencePhoneDao {
    int savePhone(ConveniencePhone phone);
    ConveniencePhone queryById(int id);

    List<ConveniencePhone> queryByPage(RowBounds rowBounds);
    int countPhone();
    int updatePhone(ConveniencePhone phone);
    int delById(int id);
}
