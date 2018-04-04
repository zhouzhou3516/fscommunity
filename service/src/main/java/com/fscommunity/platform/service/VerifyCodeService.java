package com.fscommunity.platform.service;

import com.fscommunity.platform.persist.dao.VerifyCodeDao;
import com.fscommunity.platform.persist.pojo.VerifyBizType;
import com.fscommunity.platform.persist.pojo.VerifyCode;
import com.google.common.base.Strings;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author lixiaoxiong
 * @version 2018-01-20
 */
@Service
public class VerifyCodeService {

    @Resource
    VerifyCodeDao verifyCodeDao;

    public int saveVerifyCode(VerifyCode code) {
        if (code == null) {
            return 0;
        }
        return verifyCodeDao.saveVerifyCode(code);
    }

    public VerifyCode queryVerifyCode(String phone, VerifyBizType bizType) {
        if (Strings.isNullOrEmpty(phone) || bizType == null) {
            return null;
        }
        return verifyCodeDao.queryValidCode(phone, bizType);
    }

    public int updateCodeStatus(VerifyCode code){
        if (code == null) {
            return 0;
        }
        return verifyCodeDao.updateStatus(code);
    }
}
