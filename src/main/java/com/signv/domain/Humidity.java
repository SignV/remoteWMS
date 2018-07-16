package com.signv.domain;

import java.util.Date;

public class Humidity {
    private Integer humidityNum;

    private Integer repositoryNum;

    private Integer sensorNum;

    private Date humRecordDate;

    public Humidity(Integer humidityNum, Integer repositoryNum, Integer sensorNum) {
        this.humidityNum = humidityNum;
        this.repositoryNum = repositoryNum;
        this.sensorNum = sensorNum;
    }

    public Humidity() {
    }

    public Integer getHumidityNum() {
        return humidityNum;
    }

    public void setHumidityNum(Integer humidityNum) {
        this.humidityNum = humidityNum;
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

    public Date getHumRecordDate() {
        return humRecordDate;
    }

    public void setHumRecordDate(Date humRecordDate) {
        this.humRecordDate = humRecordDate;
    }
}