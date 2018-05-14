package com.fscommunity.platform.provider.wechat.controller;

import com.fscommunity.platform.common.constant.WxMediaType;
import com.fscommunity.platform.common.util.AliOssMediaClient;
import com.fscommunity.platform.common.web.AccessTokenCache;
import com.fscommunity.platform.common.web.WxInvoker;
import com.fscommunity.platform.persist.pojo.ConsultType;
import com.fscommunity.platform.provider.wechat.req.AddNewListingReq;
import com.fscommunity.platform.provider.wechat.req.AddVoiceRequest;
import com.fscommunity.platform.provider.wechat.vo.LabelVo;
import com.fscommunity.platform.provider.wechat.vo.VoiceUrlVo;
import com.fscommunity.platform.provider.wechat.voadaptor.ConsultListeningVoAdapt;
import com.fscommunity.platform.service.ConsultListeningService;
import com.google.common.base.Strings;
import com.lxx.app.common.util.pojo.BizException;
import com.lxx.app.common.web.spring.annotation.JsonBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 你说我听
 *
 * @author liqingzhou on 18/4/28
 */
@Controller("listeningController")
@RequestMapping("/fscommunity/wechat/listening")
public class ConsultListeningController {

    Logger logger = LoggerFactory.getLogger(getClass());
    @Resource
    private AliOssMediaClient aliOssMediaClient;
    @Resource
    private WxInvoker wxInvoker;
    @Resource
    private AccessTokenCache accessTokenCache;
    @Resource
    private ConsultListeningService consultListeningService;

    /**
     * 交互
     * 1. 微信前端负责录音，并上传是微信服务器
     * 2. 微信前端回传后端mediaId (/upload/void接口)
     * 3. 后端根据mediaId下载音频文件
     * 4. 后端上传音频文件到ali oss服务器
     * 5. 后端生成预览url反给微信前端
     */
    @RequestMapping("/upload/voice")
    @JsonBody
    public VoiceUrlVo uploadVoice(@RequestBody AddVoiceRequest request) {
        String token = accessTokenCache.getToken();
        File file = wxInvoker.dowloadWxMedia(token, request.getMediaId(), WxMediaType.valueOf(request.getType()));
        aliOssMediaClient.uploadVoice(file);
        String presignedUrl = aliOssMediaClient.queryPresignedUrl(file.getName());
        VoiceUrlVo voiceUrlVo = new VoiceUrlVo();
        voiceUrlVo.setVoiceUrl(presignedUrl);
        return voiceUrlVo;
    }

    @RequestMapping("/presignedUrl")
    @JsonBody
    public String testSnap(String objectName) {
        String presignedUrl = aliOssMediaClient.queryPresignedUrl(aliOssMediaClient.submitVideoSnap(objectName));
        logger.info("pre signed url:{}", presignedUrl);
        return presignedUrl;
    }

    @RequestMapping("save")
    @JsonBody
    public String addListing(@RequestBody AddNewListingReq req) {
        try {
            String token = accessTokenCache.getToken();

            String voiceUrl = "";
            if (!Strings.isNullOrEmpty(req.getVoiceWxMediaId())) {
                File file = wxInvoker.dowloadWxMedia(token, req.getVoiceWxMediaId(), WxMediaType.VOICE);
                aliOssMediaClient.uploadVoice(file);
                voiceUrl = aliOssMediaClient.queryPresignedUrl(file.getName());
            }

            String videoUrl = "";
            if (!Strings.isNullOrEmpty(req.getVideoOssObjectName())) {
                videoUrl = aliOssMediaClient.queryPresignedUrl(req.getVideoOssObjectName());
            }

            consultListeningService.saveConsultListening(ConsultListeningVoAdapt.adapt(req, voiceUrl, videoUrl));
            // wx notify
            return "success";
        } catch (Exception e) {
            logger.error("你说我听，保存失败，req={}", req, e);
            throw new BizException("保存失败");
        }
    }

    @RequestMapping("/types")
    @JsonBody
    public List<LabelVo> consultTypes() {
        List<LabelVo> vos = new ArrayList<>();
        for (ConsultType type : ConsultType.values()) {
            LabelVo vo = new LabelVo();
            vo.setText(type.getDesc());
            vo.setValue(type.name());
            vos.add(vo);
        }
        return vos;
    }
}
