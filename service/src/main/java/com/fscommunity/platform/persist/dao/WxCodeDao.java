package com.fscommunity.platform.persist.dao;

import com.fscommunity.platform.persist.pojo.WxToken;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author lixiaoxiong
 * @version 2018-02-01
 */
@Repository
public interface WxCodeDao {
    int saveWxToken(WxToken token);
    WxToken queryToken(String wxCode);
    int updateInterfaceToken(@Param("token") String token, @Param("wxCode") String wxCode);
    int updateWebToken(@Param("token") String token, @Param("wxCode") String wxCode);
    int updateWebRefreshToken(@Param("token") String token, @Param("wxCode") String wxCode);
    int updateTicketToken(@Param("token") String token, @Param("wxCode") String wxCode);
}
