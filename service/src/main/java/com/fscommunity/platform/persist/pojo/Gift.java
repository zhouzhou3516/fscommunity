package com.fscommunity.platform.persist.pojo;

import java.io.Serializable;
import java.util.Date;

public class Gift implements Serializable {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 图像url
     */
    private String pic;

    /**
     * 礼品名称
     */
    private String name;

    /**
     * 礼品描述
     */
    private String content;

    /**
     * 礼品剩余数量
     */
    private Integer available;

    /**
     * 礼品总数
     */
    private Integer total;

    /**
     * 上架时间
     */
    private Date putonTime;

    /**
     * 下架时间
     */
    private Date pulloffTime;

    /**
     * 支付方式：0积分，1金币
     */
    private Integer payMethod;

    /**
     * 兑换 积分/金币 数量
     */
    private Integer cost;

    /**
     * 礼品状态：0已下架，1未下架
     */
    private Integer giftState;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    public Date getPutonTime() {
        return putonTime;
    }

    public void setPutonTime(Date putonTime) {
        this.putonTime = putonTime;
    }

    public Date getPulloffTime() {
        return pulloffTime;
    }

    public void setPulloffTime(Date pulloffTime) {
        this.pulloffTime = pulloffTime;
    }

    public Integer getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(Integer payMethod) {
        this.payMethod = payMethod;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getGiftState() {
        return giftState;
    }

    public void setGiftState(Integer giftState) {
        this.giftState = giftState;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Gift other = (Gift) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getPic() == null ? other.getPic() == null : this.getPic().equals(other.getPic()))
                && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
                && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
                && (this.getAvailable() == null ? other.getAvailable() == null : this.getAvailable().equals(other.getAvailable()))
                && (this.getPutonTime() == null ? other.getPutonTime() == null : this.getPutonTime().equals(other.getPutonTime()))
                && (this.getPulloffTime() == null ? other.getPulloffTime() == null : this.getPulloffTime().equals(other.getPulloffTime()))
                && (this.getPayMethod() == null ? other.getPayMethod() == null : this.getPayMethod().equals(other.getPayMethod()))
                && (this.getCost() == null ? other.getCost() == null : this.getCost().equals(other.getCost()))
                && (this.getGiftState() == null ? other.getGiftState() == null : this.getGiftState().equals(other.getGiftState()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPic() == null) ? 0 : getPic().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getAvailable() == null) ? 0 : getAvailable().hashCode());
        result = prime * result + ((getPutonTime() == null) ? 0 : getPutonTime().hashCode());
        result = prime * result + ((getPulloffTime() == null) ? 0 : getPulloffTime().hashCode());
        result = prime * result + ((getPayMethod() == null) ? 0 : getPayMethod().hashCode());
        result = prime * result + ((getCost() == null) ? 0 : getCost().hashCode());
        result = prime * result + ((getGiftState() == null) ? 0 : getGiftState().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", pic=").append(pic);
        sb.append(", name=").append(name);
        sb.append(", content=").append(content);
        sb.append(", available=").append(available);
        sb.append(", putonTime=").append(putonTime);
        sb.append(", pulloffTime=").append(pulloffTime);
        sb.append(", payMethod=").append(payMethod);
        sb.append(", cost=").append(cost);
        sb.append(", giftState=").append(giftState);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }


}