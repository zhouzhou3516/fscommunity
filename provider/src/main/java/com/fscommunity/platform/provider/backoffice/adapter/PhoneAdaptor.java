package com.fscommunity.platform.provider.backoffice.adapter;

import com.fscommunity.platform.persist.pojo.ConveniencePhone;
import com.fscommunity.platform.provider.backoffice.req.AddPhoneReq;
import com.fscommunity.platform.provider.backoffice.vo.MgrPhoneDetailVo;
import com.fscommunity.platform.provider.backoffice.vo.MgrPhoneListItemVo;
import org.apache.commons.collections.CollectionUtils;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chao.zhu
 * @version 2018-04-15
 */
public class PhoneAdaptor {
    public static ConveniencePhone adaptCPhone(AddPhoneReq req) {
        ConveniencePhone phone = new ConveniencePhone();
        phone.setOwner(req.getOwner());
        phone.setPhoneDesc(req.getDesc());
        phone.setPhone(req.getPhone());

        Date current = new Date();
        phone.setCreateTime(current);
        phone.setUpdateTime(current);
        return phone;
    }

    public static MgrPhoneListItemVo adaptItemVo(ConveniencePhone phone) {
        MgrPhoneListItemVo vo = new MgrPhoneListItemVo();
        vo.setId(phone.getId());
        vo.setOwner(phone.getOwner());
        vo.setPhone(phone.getPhone());
        vo.setDesc(phone.getPhoneDesc());
        return vo;
    }

    public static List<MgrPhoneListItemVo> adaptItemVos(List<ConveniencePhone> phones) {
        if (CollectionUtils.isEmpty(phones)) {
            return Collections.EMPTY_LIST;
        }

        return phones.stream().map(PhoneAdaptor::adaptItemVo).collect(Collectors.toList());
    }

    public static MgrPhoneDetailVo adaptDetailVo(ConveniencePhone phone) {
        MgrPhoneDetailVo vo = new MgrPhoneDetailVo();
        vo.setId(phone.getId());
        vo.setOwner(phone.getOwner());
        vo.setPhone(phone.getPhone());
        vo.setDesc(phone.getPhoneDesc());
        return vo;
    }
}
