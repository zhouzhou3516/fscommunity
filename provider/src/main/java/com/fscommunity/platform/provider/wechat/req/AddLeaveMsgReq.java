package com.fscommunity.platform.provider.wechat.req;

/**
 * @author chao.zhu
 * @version 2018-04-17
 */
public class AddLeaveMsgReq {
    /**
     * 被回复的留言id
     */
    private int replyedId;

    /**
     * 被回复留言的用户id
     */
    private int replyedUserid;

    /**
     * 留言内容
     */
    private String content;

    /**
     * 新留言还是回复的别人留言，值为true表示新留言
     */
    private boolean newMsg;

    public int getReplyedId() {
        return replyedId;
    }

    public void setReplyedId(int replyedId) {
        this.replyedId = replyedId;
    }

    public int getReplyedUserid() {
        return replyedUserid;
    }

    public void setReplyedUserid(int replyedUserid) {
        this.replyedUserid = replyedUserid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isNewMsg() {
        return newMsg;
    }

    public void setNewMsg(boolean newMsg) {
        this.newMsg = newMsg;
    }
}
