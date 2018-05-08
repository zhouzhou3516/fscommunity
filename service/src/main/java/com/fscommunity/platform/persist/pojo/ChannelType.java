package com.fscommunity.platform.persist.pojo;

/**
 * @author liqingzhou on 18/4/29
 */
public enum ChannelType {
    ANNOUNCEMENT(0,"通知公告"),
    LISTENING(1,"你说我听"),
    AGENDA_ROOM(2,"议事厅"),
    SERVICE_STATION(3, "服务工作站"),
    PARTY_WORK(4, "党建工作"),
    CONSULT(5, "社区咨询");
    private int idx;
    private String desc;

    ChannelType(int idx, String desc) {
        this.idx = idx;
        this.desc = desc;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
