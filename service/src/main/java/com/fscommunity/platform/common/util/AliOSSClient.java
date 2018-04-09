package com.fscommunity.platform.common.util;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.auth.sts.AssumeRoleRequest;
import com.aliyuncs.auth.sts.AssumeRoleResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.lxx.app.common.util.json.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author lixiaoxiong
 * @version 2018-03-30
 */
@Service
public class AliOSSClient {
    private final static Logger logger = LoggerFactory.getLogger(AliOSSClient.class);


    @Value("${aliyun.oss.endpoint.sts}")
    private String ossEndpoint;

    @Value("${aliyun.oss.accessKeyId.ram}")
    private String accessKeyId;

    @Value("${aliyun.oss.accessKeySecret.ram}")
    private String accessKeySecret;

    @Value("${aliyun.oss.endpoint.master}")
    private String ossMasterEndPoint;

    @Value("${aliyun.oss.accessKeyId.master}")
    private String ossMasterKeyId;

    @Value("${aliyun.oss.accessKeySecret.master}")
    private String ossMasterKeySecret;

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




//    public String submitJobId() {
//        String region = "cn-beijing";
//        String pipelineId = "7944e0efe7e64c17bbb5b86781e7d7fe";
//        String inputBucket = "fs-community-store";
//        String ossLocation = "oss-cn-beijing";
//        String inputObject = "aaaaaa.mp4";
//        String outputBucket = "fs-community-store";
//        String outputObject = "aaaaaa-{Count}.jpg";
//
//
//        try {
//            DefaultProfile.addEndpoint(region, region, "Mts", "mts."+region+".aliyuncs.com");
//            DefaultProfile profile = DefaultProfile.getProfile(region, "LTAImlhQkum6Sisx", "UHsOV8sOSzM97PxQN1RcQ8L2kcESjR");
//            DefaultAcsClient client = new DefaultAcsClient(profile);
//
//            SubmitSnapshotJobRequest request=new SubmitSnapshotJobRequest();
//            JSONObject input = new JSONObject();
//            input.put("Location", ossLocation);
//            input.put("Bucket", inputBucket);
//            try {
//                input.put("Object", URLEncoder.encode(inputObject, "utf-8"));
//            } catch (UnsupportedEncodingException e) {
//                throw new RuntimeException("input URL encode failed");
//            }
//            request.setInput(input.toJSONString());
//            JSONObject snapshotConfig = new JSONObject();
//            JSONObject output = new JSONObject();
//            output.put("Location", ossLocation);
//            output.put("Bucket", outputBucket);
//            try {
//                output.put("Object", URLEncoder.encode(outputObject, "utf-8"));
//            } catch (UnsupportedEncodingException e) {
//                throw new RuntimeException("input URL encode failed");
//            }
//            snapshotConfig.put("OutputFile", output);
//            snapshotConfig.put("Time", "2000");
//            snapshotConfig.put("Interval", "10");
//            snapshotConfig.put("Num", "1");
//            snapshotConfig.put("FrameType", "normal");
//            snapshotConfig.put("Width", "200");
//            snapshotConfig.put("Height", "200");
//            request.setSnapshotConfig(snapshotConfig.toJSONString());
//            request.setPipelineId(pipelineId);
//            SubmitSnapshotJobResponse response=client.getAcsResponse(request);
//
//            String id = response.getSnapshotJob().getId();
//            System.out.println("snap id:" + id);
//            return id;
//        } catch (ClientException e) {
//            e.printStackTrace();
//            return null;
//        }
//
//    }



//    private void querySnap() {
//        String region = "cn-beijing";
//        String accessKeyId = "LTAImlhQkum6Sisx";
//        String accessKeySecret = "UHsOV8sOSzM97PxQN1RcQ8L2kcESjR";
//        // 已知的截图jobId，多个截图任务用','分隔
//        String jobIds = "f37229db0a29402abd63bb4b31ab30e7";
//        DefaultProfile profile = DefaultProfile.getProfile(region, accessKeyId, accessKeySecret);
//        DefaultAcsClient client = new DefaultAcsClient(profile);
//        try{
//            QuerySnapshotJobListRequest request=new QuerySnapshotJobListRequest();
//            request.setSnapshotJobIds(jobIds);
//            QuerySnapshotJobListResponse response=client.getAcsResponse(request);
//            List<QuerySnapshotJobListResponse.SnapshotJob> jobList=response.getSnapshotJobList();
//            System.out.println(JsonUtil.of(jobList.get(0)));
//        } catch (ClientException e) {
//            System.out.println(e.getErrMsg());
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }
}
