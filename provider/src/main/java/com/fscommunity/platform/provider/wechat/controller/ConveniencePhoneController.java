package com.fscommunity.platform.provider.wechat.controller;

import com.fscommunity.platform.persist.pojo.ConveniencePhone;
import com.fscommunity.platform.provider.wechat.vo.PhoneListItemVo;
import com.fscommunity.platform.provider.wechat.voadaptor.PhoneWechatAdaptor;
import com.fscommunity.platform.service.ConveniencePhoneService;
import com.lxx.app.common.util.page.PageRequest;
import com.lxx.app.common.web.spring.annotation.JsonBody;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fscommunity.platform.provider.wechat.vo.PhoneListVo;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * @author chao.zhu
 * @version 2018-04-16
 */
@RequestMapping("/fscommunity/wechat/phone")
@Controller
public class ConveniencePhoneController {

    @Resource
    ConveniencePhoneService conveniencePhoneService;

    @RequestMapping("/list")
    @JsonBody
    public PhoneListVo queryPhoneList(int currentPage, int pageSize) {
        List<ConveniencePhone> phoneList = conveniencePhoneService.queryByPage(new PageRequest(currentPage, pageSize));

        PhoneListVo vo = new PhoneListVo();
        if (CollectionUtils.isEmpty(phoneList)) {
            vo.setCount(0);
            vo.setItems(Collections.EMPTY_LIST);
            return vo;
        }

        List<PhoneListItemVo> voList = PhoneWechatAdaptor.adaptItemVos(phoneList);
        vo.setItems(voList);
        vo.setCount(conveniencePhoneService.countPhone());
        return vo;
    }
}
