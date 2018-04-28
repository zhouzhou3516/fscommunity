package com.fscommunity.platform.common.util;

import com.alibaba.fastjson.JSONObject;
import com.aliyun.oss.HttpMethod;
import com.aliyun.oss.OSSClient;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.mts.model.v20140618.SearchPipelineRequest;
import com.aliyuncs.mts.model.v20140618.SearchPipelineResponse;
import com.aliyuncs.mts.model.v20140618.SubmitSnapshotJobRequest;
import com.aliyuncs.mts.model.v20140618.SubmitSnapshotJobResponse;
import com.aliyuncs.profile.DefaultProfile;
import com.fscommunity.platform.persist.pojo.OssObjectPresignedUrlnfo;
import com.fscommunity.platform.service.OssObjectPresignUrlService;
import com.lxx.app.common.util.pojo.BizException;
import java.io.File;
import org.apache.commons.lang3.tuple.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;


/**
 * @author chao.zhu
 * @version 2018-04-09
 */
@Service
public class AliOssMediaClient {
    private final static Logger logger = LoggerFactory.getLogger(AliOssMediaClient.class);
    @Value("${aliyun.oss.endpoint.master}")
    private String ossMasterEndPoint;

    @Value("${aliyun.oss.accessKeyId.master}")
    private String ossMasterKeyId;

    @Value("${aliyun.oss.accessKeySecret.master}")
    private String ossMasterKeySecret;

    @Value("${aliyun.oss.region.id}")
    private String ossRegionId;

    @Value("${aliyun.oss.default.bucket}")
    private String defaultBucket;

    private String mediaProcessPipelineId;
    private OSSClient ossClient;

    @Resource
    OssObjectPresignUrlService ossObjectPresignUrlService;

    /**
     * oss object 获取预览url
     * @param objectName oss对象名称
     * @return 返回预览url
     */
    public String queryPresignedUrl(String objectName) {
        //没有过期，则返回数据库存在的url
        OssObjectPresignedUrlnfo presignedUrlnfo = ossObjectPresignUrlService.queryByBNameAndObName("fs-community-store", objectName);
        if (presignedUrlnfo != null && presignedUrlnfo.getExpireTime().before(new Date())) {
            return presignedUrlnfo.getPresignedUrl();
        }
        //如果过期（默认20天过期）
        Date expiration = new Date(new Date().getTime() + 3600 * 1000  * 24  * 20);
        URL url = ossClient.generatePresignedUrl("fs-community-store", objectName, expiration, HttpMethod.GET);
        ossObjectPresignUrlService.saveOssObjectUrl(initOssObjectUrl(objectName, expiration, url.toString()));
        return url.toString();
    }

    private OssObjectPresignedUrlnfo initOssObjectUrl(String objectName, Date expire, String url) {
        OssObjectPresignedUrlnfo info = new OssObjectPresignedUrlnfo();
        info.setBucketName(defaultBucket);
        Date current = new Date();
        info.setCreateTime(current);
        info.setUpdateTime(current);
        info.setExpireTime(expire);
        info.setObjectName(objectName);
        info.setPresignedUrl(url);
        return info;
    }

    /**
     * 截图视频的一帧，并保存为图片
     * @param objectName 要截图的视频名称
     * @return 截图后的图片名称
     */
    public String submitVideoSnap(String objectName) {
        String ossLocation = "oss-cn-beijing";
        String outputObject = objectName + "-{Count}.jpg";
        try {
            DefaultProfile.addEndpoint(ossRegionId, ossRegionId, "Mts", "mts."+ossRegionId+".aliyuncs.com");
            DefaultProfile profile = DefaultProfile.getProfile(ossRegionId, ossMasterKeyId, ossMasterKeySecret);
            DefaultAcsClient client = new DefaultAcsClient(profile);

            SubmitSnapshotJobRequest request=new SubmitSnapshotJobRequest();
            JSONObject input = new JSONObject();
            input.put("Location", ossLocation);
            input.put("Bucket", defaultBucket);
            try {
                input.put("Object", URLEncoder.encode(objectName, "utf-8"));
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException("input URL encode failed");
            }
            request.setInput(input.toJSONString());
            JSONObject snapshotConfig = new JSONObject();
            JSONObject output = new JSONObject();
            output.put("Location", ossLocation);
            output.put("Bucket", defaultBucket);
            try {
                output.put("Object", URLEncoder.encode(outputObject, "utf-8"));
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException("input URL encode failed");
            }
            snapshotConfig.put("OutputFile", output);
            snapshotConfig.put("Time", "2000");
            snapshotConfig.put("Interval", "10");
            snapshotConfig.put("Num", "1");
            snapshotConfig.put("FrameType", "normal");
            snapshotConfig.put("Width", "800");
            snapshotConfig.put("Height", "800");
            request.setSnapshotConfig(snapshotConfig.toJSONString());
            request.setPipelineId(mediaProcessPipelineId);
            SubmitSnapshotJobResponse response=client.getAcsResponse(request);

            String id = response.getSnapshotJob().getId();
            return objectName+"-00001.jpg";
        } catch (ClientException e) {
            logger.error("阿里云媒体处理截图操作异常", e );
            return null;
        }
    }
    public String uploadVoice(File file){
        ossClient.putObject(defaultBucket, file.getName(),file);
        return file.getName();
    }

    private Pair<String, String> queryPipeline() {
        DefaultProfile profile = DefaultProfile.getProfile(
                ossRegionId,      // 地域ID
                ossMasterKeyId,      // RAM账号的AccessKey ID
                ossMasterKeySecret); // RAM账号Access Key Secret
        IAcsClient client = new DefaultAcsClient(profile);
        // 创建API请求并设置参数
        SearchPipelineRequest request = new SearchPipelineRequest();
        // 发起请求并处理应答或异常
        SearchPipelineResponse response;
        try {
            response = client.getAcsResponse(request);
            return Pair.of(response.getPipelineList().get(0).getName(),
            response.getPipelineList().get(0).getId());
        } catch (ClientException e) {
            logger.error("请求阿里云媒体处理管道异常", e);
            throw new BizException(e);
        }
    }

    @PostConstruct
    private void init() {
        Pair<String, String> pair = queryPipeline();
        mediaProcessPipelineId = pair.getRight();
        ossClient = new OSSClient(ossMasterEndPoint, ossMasterKeyId, ossMasterKeySecret);
    }
}
