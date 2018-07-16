package com.signv.domain;

import java.util.Date;

public class OutInStatistics {
    private Integer outInId;

    private Integer outInGoodsId;

    private String outInGoodsName;

    private Integer outInNum;

    private Boolean outInStatus;

    private Double outInAmount;

    private Date outInDate;

    public Integer getOutInId() {
        return outInId;
    }

    public void setOutInId(Integer outInId) {
        this.outInId = outInId;
    }

    public Integer getOutInGoodsId() {
        return outInGoodsId;
    }

    public void setOutInGoodsId(Integer outInGoodsId) {
        this.outInGoodsId = outInGoodsId;
    }

    public String getOutInGoodsName() {
        return outInGoodsName;
    }

    public void setOutInGoodsName(String outInGoodsName) {
        this.outInGoodsName = outInGoodsName == null ? null : outInGoodsName.trim();
    }

    public Integer getOutInNum() {
        return outInNum;
    }

    public void setOutInNum(Integer outInNum) {
        this.outInNum = outInNum;
    }

    public Boolean getOutInStatus() {
        return outInStatus;
    }

    public void setOutInStatus(Boolean outInStatus) {
        this.outInStatus = outInStatus;
    }

    public Double getOutInAmount() {
        return outInAmount;
    }

    public void setOutInAmount(Double outInAmount) {
        this.outInAmount = outInAmount;
    }

    public Date getOutInDate() {
        return outInDate;
    }

    public void setOutInDate(Date outInDate) {
        this.outInDate = outInDate;
    }
}