package com.fscommunity.platform.provider.wechat.voadaptor;

import com.fscommunity.platform.persist.pojo.ProjectSubTypeInfo;
import com.fscommunity.platform.provider.wechat.vo.ChannelSubTypeVo;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author liqingzhou on 18/5/6
 */
public class ChannelSubTypeVoAdapter {

    public static List<ChannelSubTypeVo> adapt(List<ProjectSubTypeInfo> list) {
        return list.stream().map(info -> {
            return new ChannelSubTypeVo(info.getSubType());
        }).collect(Collectors.toList());
    }

}
