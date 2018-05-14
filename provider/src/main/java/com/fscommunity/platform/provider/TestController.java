package com.fscommunity.platform.provider;

import com.fscommunity.platform.common.util.AliOssMediaClient;
import com.fscommunity.platform.persist.pojo.ConsultListeningInfo;
import com.fscommunity.platform.provider.backoffice.adapter.MgrConsultListeningVoAdapter;
import com.fscommunity.platform.provider.backoffice.vo.MgrConsultListeningVo;
import com.fscommunity.platform.service.ConsultListeningService;
import com.lxx.app.common.web.spring.annotation.JsonBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @author lixiaoxiong
 * @version 2018-03-15
 */
@RequestMapping("/fscommunity/test")
@Controller
public class TestController {
    private final static Logger logger = LoggerFactory.getLogger(TestController.class);

    @Resource
    AliOssMediaClient aliOssMediaClient;

    @Resource
    private ConsultListeningService consultListeningService;


    @RequestMapping("/demo")
    @JsonBody
    public void test() {
        logger.info("demo");
    }


    @RequestMapping("/presignedUrl")
    public void testSnap(String objectName) {
        String presignedUrl = aliOssMediaClient.queryPresignedUrl(aliOssMediaClient.submitVideoSnap(objectName));
        logger.info("pre signed url:{}", presignedUrl);
    }

    @RequestMapping("/lis")
    @JsonBody
    public MgrConsultListeningVo list(int id) {
        logger.info("info");
        ConsultListeningInfo consultListeningInfo = consultListeningService.queryById(id);

        MgrConsultListeningVo vo = MgrConsultListeningVoAdapter.adaptToVo(consultListeningInfo);
        return  vo;
    }
}
