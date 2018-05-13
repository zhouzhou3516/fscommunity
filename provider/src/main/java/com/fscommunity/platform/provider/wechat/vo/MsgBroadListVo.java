package com.fscommunity.platform.provider.wechat.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chao.zhu
 * @version 2018-05-13
 */
public class MsgBroadListVo {
    private int totalCount;
    private List<MsgBroadVo> msgs = new ArrayList<>();

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<MsgBroadVo> getMsgs() {
        return msgs;
    }

    public void setMsgs(List<MsgBroadVo> msgs) {
        this.msgs = msgs;
    }
}
