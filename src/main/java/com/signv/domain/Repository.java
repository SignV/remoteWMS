package com.signv.domain;

public class Repository {
    private Integer repositoryNum;

    private String repositoryName;

    private String repositoryAddress;

    private String goodsType;

    private String nearbyTransportPoint;

    private String saveType;

    private String builtArea;

    private Boolean repositoryStatus;

    public Integer getRepositoryNum() {
        return repositoryNum;
    }

    public void setRepositoryNum(Integer repositoryNum) {
        this.repositoryNum = repositoryNum;
    }

    public String getRepositoryName() {
        return repositoryName;
    }

    public void setRepositoryName(String repositoryName) {
        this.repositoryName = repositoryName == null ? null : repositoryName.trim();
    }

    public String getRepositoryAddress() {
        return repositoryAddress;
    }

    public void setRepositoryAddress(String repositoryAddress) {
        this.repositoryAddress = repositoryAddress == null ? null : repositoryAddress.trim();
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType == null ? null : goodsType.trim();
    }

    public String getNearbyTransportPoint() {
        return nearbyTransportPoint;
    }

    public void setNearbyTransportPoint(String nearbyTransportPoint) {
        this.nearbyTransportPoint = nearbyTransportPoint == null ? null : nearbyTransportPoint.trim();
    }

    public String getSaveType() {
        return saveType;
    }

    public void setSaveType(String saveType) {
        this.saveType = saveType == null ? null : saveType.trim();
    }

    public String getBuiltArea() {
        return builtArea;
    }

    public void setBuiltArea(String builtArea) {
        this.builtArea = builtArea == null ? null : builtArea.trim();
    }

    public Boolean getRepositoryStatus() {
        return repositoryStatus;
    }

    public void setRepositoryStatus(Boolean repositoryStatus) {
        this.repositoryStatus = repositoryStatus;
    }
}