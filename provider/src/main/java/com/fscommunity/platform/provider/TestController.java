package com.fscommunity.platform.provider;

import com.lxx.app.common.web.spring.annotation.JsonBody;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lixiaoxiong
 * @version 2018-03-15
 */
@RequestMapping("/fscommunity/test")
@Controller
public class TestController {
    private final static Logger logger = LoggerFactory.getLogger(TestController.class);

    @RequestMapping("/demo")
    @JsonBody
    public void test() {
        logger.info("demo");
    }
}
