package com.fscommunity.platform.provider.wechat.controller;

import com.fscommunity.platform.common.constant.WxMediaType;
import com.fscommunity.platform.common.util.AliOssMediaClient;
import com.fscommunity.platform.common.web.AccessTokenCache;
import com.fscommunity.platform.common.web.WxInvoker;
import com.fscommunity.platform.provider.wechat.req.AddVoiceRequest;
import com.fscommunity.platform.provider.wechat.vo.VoiceUrlVo;
import com.lxx.app.common.web.spring.annotation.JsonBody;
import java.io.File;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 你说我听
 * @author liqingzhou on 18/4/28
 */
@Component
@RequestMapping("/fscommunity/listening")
public class HeartListeningController {

    @Resource
    private AliOssMediaClient aliOssMediaClient;
    @Resource
    private WxInvoker wxInvoker;
    @Resource
    private AccessTokenCache accessTokenCache;

    /**
     * 交互
     * 1. 微信前端负责录音，并上传是微信服务器
     * 2. 微信前端回传后端mediaId (/upload/void接口)
     * 3. 后端根据mediaId下载音频文件
     * 4. 后端上传音频文件到ali oss服务器
     * 5. 后端生成预览url反给微信前端
     * @param request
     * @return
     */
    @RequestMapping("/upload/voice")
    @JsonBody
    public VoiceUrlVo uploadVoice(AddVoiceRequest request) {
        String token = accessTokenCache.getToken();
        File file = wxInvoker.dowloadWxMedia(token, request.getMediaId(), WxMediaType.valueOf(request.getType()));
        aliOssMediaClient.uploadVoice(file);
        String presignedUrl = aliOssMediaClient.queryPresignedUrl(file.getName());
        VoiceUrlVo voiceUrlVo = new VoiceUrlVo();
        voiceUrlVo.setVoiceUrl(presignedUrl);
        return voiceUrlVo;
    }

}
