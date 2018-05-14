package com.fscommunity.platform.persist.pojo;

/**
 * @author chao.zhu
 * @version 2018-05-13
 */
public enum ConsultType {
    FAN_KONG_XIAN_SUO(0, "反恐线索"),
    XIN_FANG_JIE_DAI(1, "信访接待"),
    AN_QUAN_YIN_HUAN(2, "安全隐患"),
    SHE_QU_ZHI_AN(3, "社区治安"),
    MAO_DUN_JIU_FEN(4, "矛盾纠纷"),
    LIU_DONG_RENKOU_CHUZU_GUANLI(5, "流动人口与出租屋管理"),
    TU_FA_SHI_JIAN(6, "突发事件"),
    MIN_YI_SU_QIU(7, "民意诉求"),
    JIAN_YAN_XIAN_CE(8, "建言献策"),
    YI_JIAN_SHOU_JI(9, "意见收集"),
    QITA(10, "其他");
    private int code;
    private String desc;

    ConsultType(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
