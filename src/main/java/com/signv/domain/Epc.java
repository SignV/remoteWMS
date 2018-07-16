package com.signv.domain;

import java.util.Date;

public class Epc {
    private Integer epcId;

    private String epcCode;

    private Integer epcGoodsId;

    private Integer outInNum;

    private Integer epcStatus;

    private Date epcDate;

    public Integer getEpcId() {
        return epcId;
    }

    public void setEpcId(Integer epcId) {
        this.epcId = epcId;
    }

    public String getEpcCode() {
        return epcCode;
    }

    public void setEpcCode(String epcCode) {
        this.epcCode = epcCode == null ? null : epcCode.trim();
    }

    public Integer getEpcGoodsId() {
        return epcGoodsId;
    }

    public void setEpcGoodsId(Integer epcGoodsId) {
        this.epcGoodsId = epcGoodsId;
    }

    public Integer getOutInNum() {
        return outInNum;
    }

    public void setOutInNum(Integer outInNum) {
        this.outInNum = outInNum;
    }

    public Integer getEpcStatus() {
        return epcStatus;
    }

    public void setEpcStatus(Integer epcStatus) {
        this.epcStatus = epcStatus;
    }

    public Date getEpcDate() {
        return epcDate;
    }

    public void setEpcDate(Date epcDate) {
        this.epcDate = epcDate;
    }
}