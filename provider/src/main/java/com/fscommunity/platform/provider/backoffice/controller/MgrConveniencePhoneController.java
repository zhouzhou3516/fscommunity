package com.fscommunity.platform.provider.backoffice.controller;

import com.fscommunity.platform.persist.pojo.ConveniencePhone;
import com.fscommunity.platform.provider.backoffice.adapter.PhoneAdaptor;
import com.fscommunity.platform.provider.backoffice.req.AddPhoneReq;
import com.fscommunity.platform.provider.backoffice.req.UpdatePhoneReq;
import com.fscommunity.platform.provider.backoffice.vo.MgrPhoneDetailVo;
import com.fscommunity.platform.provider.backoffice.vo.MgrPhoneListVo;
import com.fscommunity.platform.service.ConveniencePhoneService;
import com.lxx.app.common.util.page.PageRequest;
import com.lxx.app.common.web.spring.annotation.JsonBody;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * @author chao.zhu
 * @version 2018-04-15
 */
@RequestMapping("/fscommunity/man/phone")
@Controller
public class MgrConveniencePhoneController {

    @Resource
    ConveniencePhoneService conveniencePhoneService;

    @RequestMapping("/add")
    public void addPhone(@RequestBody AddPhoneReq req) {
        ConveniencePhone phone = PhoneAdaptor.adaptCPhone(req);
        conveniencePhoneService.savePhone(phone);
    }

    @RequestMapping("/list")
    @JsonBody
    public MgrPhoneListVo queryPhoneList(int currentPage, int pageSize) {
        List<ConveniencePhone> phoneList = conveniencePhoneService.queryByPage(new PageRequest(currentPage, pageSize));

        MgrPhoneListVo vo = new MgrPhoneListVo();
        if (CollectionUtils.isEmpty(phoneList)) {
            vo.setCount(0);
            vo.setItems(Collections.EMPTY_LIST);
            return vo;
        }

        vo.setCount(conveniencePhoneService.countPhone());
        vo.setItems(PhoneAdaptor.adaptItemVos(phoneList));
        return vo;
    }

    @RequestMapping("/detail")
    @JsonBody
    public MgrPhoneDetailVo queryPhoneDetai(int phoneId) {
        ConveniencePhone phone = conveniencePhoneService.queryById(phoneId);
        return PhoneAdaptor.adaptDetailVo(phone);
    }

    @RequestMapping("/update")
    @JsonBody
    public void updatePhone(@RequestBody UpdatePhoneReq req) {
        ConveniencePhone phone = conveniencePhoneService.queryById(req.getPhoneId());
        phone.setOwner(req.getOwner());
        phone.setPhoneDesc(req.getDesc());
        phone.setPhone(req.getPhone());
        conveniencePhoneService.updatePhone(phone);
    }

    @RequestMapping("/del")
    @JsonBody
    public void delPhone(int phoneId) {
        conveniencePhoneService.delPhone(phoneId);
    }
}
