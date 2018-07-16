package com.signv.domain;

import java.util.Date;

public class Centigrade {
    private Integer centigradeNum;

    private Integer repositoryNum;

    private Integer sensorNum;

    private Date cenRecordDate;

    public Centigrade(Integer centigradeNum, Integer repositoryNum, Integer sensorNum) {
        this.centigradeNum = centigradeNum;
        this.repositoryNum = repositoryNum;
        this.sensorNum = sensorNum;
    }

    public Centigrade() {
    }

    public Integer getCentigradeNum() {
        return centigradeNum;
    }

    public void setCentigradeNum(Integer centigradeNum) {
        this.centigradeNum = centigradeNum;
    }

    public Integer getRepositoryNum() {
        return repositoryNum;
    }

    public void setRepositoryNum(Integer repositoryNum) {
        this.repositoryNum = repositoryNum;
    }

    public Integer getSensorNum() {
        return sensorNum;
    }

    public void setSensorNum(Integer sensorNum) {
        this.sensorNum = sensorNum;
    }

    public Date getCenRecordDate() {
        return cenRecordDate;
    }

    public void setCenRecordDate(Date cenRecordDate) {
        this.cenRecordDate = cenRecordDate;
    }
}