package com.fscommunity.platform.provider.wechat.voadaptor;

import com.fscommunity.platform.persist.pojo.ConveniencePhone;
import com.fscommunity.platform.provider.backoffice.adapter.PhoneAdaptor;
import com.fscommunity.platform.provider.wechat.vo.PhoneListItemVo;
import org.apache.commons.collections.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chao.zhu
 * @version 2018-04-16
 */
public class PhoneWechatAdaptor {
    public static PhoneListItemVo adaptItemVo(ConveniencePhone phone) {
        PhoneListItemVo vo = new PhoneListItemVo();
        vo.setId(phone.getId());
        vo.setOwner(phone.getOwner());
        vo.setPhone(phone.getPhone());
        vo.setDesc(phone.getPhoneDesc());
        return vo;
    }

    public static List<PhoneListItemVo> adaptItemVos(List<ConveniencePhone> phones) {
        if (CollectionUtils.isEmpty(phones)) {
            return Collections.EMPTY_LIST;
        }

        return phones.stream().map(PhoneWechatAdaptor::adaptItemVo).collect(Collectors.toList());
    }
}
