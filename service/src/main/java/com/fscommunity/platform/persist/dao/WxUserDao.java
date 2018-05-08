package com.fscommunity.platform.persist.dao;

import com.fscommunity.platform.persist.pojo.WxUser;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * @author lixiaoxiong
 * @version 2018-02-01
 */
@Repository
public interface WxUserDao {
    int saveWxUser(WxUser wxUser);
    WxUser queryWxUserByOpenId(String openid);
    List<WxUser> queryByOpenIds(List<String> openIds);
}
