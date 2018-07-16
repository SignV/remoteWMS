package com.signv.domain;

public class Goods {
    private Integer goodsId;

    private String goodsName;

    private String goodsType;

    private Double stockPrice;

    private Double salePrice;

    private Integer reserveNum;

    private Double totalPrice;

    private Integer upperLimit;

    private String remark;

    private Integer repositoryNumGoods;

    private Long goodsEpc;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType == null ? null : goodsType.trim();
    }

    public Double getStockPrice() {
        return stockPrice;
    }

    public void setStockPrice(Double stockPrice) {
        this.stockPrice = stockPrice;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public Integer getReserveNum() {
        return reserveNum;
    }

    public void setReserveNum(Integer reserveNum) {
        this.reserveNum = reserveNum;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getUpperLimit() {
        return upperLimit;
    }

    public void setUpperLimit(Integer upperLimit) {
        this.upperLimit = upperLimit;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getRepositoryNumGoods() {
        return repositoryNumGoods;
    }

    public void setRepositoryNumGoods(Integer repositoryNumGoods) {
        this.repositoryNumGoods = repositoryNumGoods;
    }

    public Long getGoodsEpc() {
        return goodsEpc;
    }

    public void setGoodsEpc(Long goodsEpc) {
        this.goodsEpc = goodsEpc;
    }
}