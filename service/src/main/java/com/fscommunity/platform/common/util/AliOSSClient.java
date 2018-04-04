package com.fscommunity.platform.common.util;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.auth.sts.AssumeRoleRequest;
import com.aliyuncs.auth.sts.AssumeRoleResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.lxx.app.common.util.DateFormatUtil;
import com.lxx.app.common.util.json.JsonUtil;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author lixiaoxiong
 * @version 2018-03-30
 */
@Service
public class AliOSSClient {
    private final static Logger logger = LoggerFactory.getLogger(AliOSSClient.class);

    @Value("${aliyun.oss.endpoint}")
    private String ossEndpoint;

    @Value("${aliyun.oss.accessKeyId}")
    private String accessKeyId;

    @Value("${aliyun.oss.accessKeySecret}")
    private String accessKeySecret;

    private String roleArn = "acs:ram::1036309158609856:role/aliyunosstokengeneratorrole";
    private String roleSessionName = "external-username";

    public AssumeRoleResponse querySTSToken() {
        String policy = "{\n" +
                "    \"Version\": \"1\", \n" +
                "    \"Statement\": [\n" +
                "        {\n" +
                "            \"Action\": [\n" +
                "                \"oss:*\"\n" +
                "            ], \n" +
                "            \"Resource\": [\n" +
                "                \"acs:oss:*:*:*\" \n" +
                "            ], \n" +
                "            \"Effect\": \"Allow\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";

        try {
            DefaultProfile.addEndpoint("", "cn-beijing", "Sts", "sts.cn-beijing.aliyuncs.com");
            IClientProfile profile = DefaultProfile.getProfile("cn-beijing", accessKeyId, accessKeySecret);
            DefaultAcsClient client = new DefaultAcsClient(profile);

            final AssumeRoleRequest request = new AssumeRoleRequest();
            request.setMethod(MethodType.POST);
            request.setRoleArn(roleArn);
            request.setRoleSessionName(roleSessionName);

            final AssumeRoleResponse response = client.getAcsResponse(request);
            logger.info("oss sts token res:{}", JsonUtil.of(response));
            return response;
        } catch (ClientException e) {
            logger.error("获取oss sts token异常", e);
            return null;
        }
    }

    public static void main(String[] args) {
        String test = "2018-03-30T08:00:20Z";
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        try {
            Date parse = df.parse(test);
            System.out.println(parse);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
