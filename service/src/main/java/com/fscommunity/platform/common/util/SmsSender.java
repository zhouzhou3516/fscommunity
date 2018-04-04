package com.fscommunity.platform.common.util;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.fscommunity.platform.common.pojo.VerifyCodeTemp;
import com.lxx.app.common.util.json.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author lixiaoxiong
 * @version 2018-01-20
 */
@Service
public class SmsSender {
    private static final Logger logger = LoggerFactory.getLogger(SmsSender.class);
    private static final String product = "Dysmsapi";//短信API产品名称（短信产品名固定，无需修改）
    private static final String domain = "dysmsapi.aliyuncs.com";//短信API产品域名（接口地址固定，无需修改）
    private static final String accessKeyId = "LTAImlhQkum6Sisx";//你的accessKeyId,参考本文档步骤2
    private static final String accessKeySecret = "UHsOV8sOSzM97PxQN1RcQ8L2kcESjR";//你的accessKeySecret，参考本文档步骤2


    public void sendSms(String phone, String smsTempContent) throws ClientException {
        //初始化ascClient,暂时不支持多region（请勿修改）
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId,
                accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);
        //请求失败这里会抛ClientException异常
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(buildSmsRequest(phone, smsTempContent));
        if(sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
            logger.info("发送短信成功, 短信回执:{}", JsonUtil.of(sendSmsResponse));
        }
    }

    public void sendVerifyCode(String phone, VerifyCodeTemp temp) {
        try {
            sendSms(phone, JsonUtil.of(temp));
        } catch (ClientException e) {
            throw new RuntimeException(e);
        }
    }

    private SendSmsRequest buildSmsRequest(String phone, String template) {
        //组装请求对象
        SendSmsRequest request = new SendSmsRequest();
        //使用post提交
        request.setMethod(MethodType.POST);
        //必填:待发送手机号。支持以逗号分隔的形式进行批量调用，批量上限为1000个手机号码,批量调用相对于单条调用及时性稍有延迟,验证码类型的短信推荐使用单条调用的方式
        request.setPhoneNumbers(phone);
        //必填:短信签名-可在短信控制台中找到
        request.setSignName("燕山总工会");
        //必填:短信模板-可在短信控制台中找到
        request.setTemplateCode("SMS_107445056");
        //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
        //友情提示:如果JSON中需要带换行符,请参照标准的JSON协议对换行符的要求,比如短信内容中包含\r\n的情况在JSON中需要表示成\\r\\n,否则会导致JSON在服务端解析失败
        //request.setTemplateParam("{\"code\":\"123\"}");
        request.setTemplateParam(template);
        //可选-上行短信扩展码(扩展码字段控制在7位或以下，无特殊需求用户请忽略此字段)
        //request.setSmsUpExtendCode("90997");
        //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
        request.setOutId("0000");
        return request;
    }

    private void init() {
        //设置超时时间-可自行调整
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
    }
}
