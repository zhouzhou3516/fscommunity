package com.fscommunity.platform.persist.pojo;

/**
 * @author liqingzhou on 18/4/29
 */
public enum ProjectType {
    SERVICE_STATION(0, "服务工作站"),
    PARTY_WORK(1, "党建工作"),
    CONSULT(2, "社区咨询");
    private int idx;
    private String desc;

    ProjectType(int idx, String desc) {
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
