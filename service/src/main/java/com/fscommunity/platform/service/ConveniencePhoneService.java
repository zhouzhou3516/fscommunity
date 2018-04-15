package com.fscommunity.platform.service;

import com.fscommunity.platform.persist.dao.ConveniencePhoneDao;
import com.fscommunity.platform.persist.pojo.ConveniencePhone;
import com.lxx.app.common.util.page.PageRequest;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author chao.zhu
 * @version 2018-04-15
 */
@Service
public class ConveniencePhoneService {

    @Resource
    ConveniencePhoneDao conveniencePhoneDao;

    public int savePhone(ConveniencePhone phone) {
        return conveniencePhoneDao.savePhone(phone);
    }

    public List<ConveniencePhone> queryByPage(PageRequest request) {
        return conveniencePhoneDao.queryByPage(new RowBounds(request.getOffset(), request.getLimit()));
    }

    public int updatePhone(ConveniencePhone phone) {
        return conveniencePhoneDao.updatePhone(phone);
    }

    public int countPhone() {
        return conveniencePhoneDao.countPhone();
    }

    public ConveniencePhone queryById(int id) {
        return conveniencePhoneDao.queryById(id);
    }

    public int delPhone(int id) {
        return conveniencePhoneDao.delById(id);
    }
}
