package com.signv.service;

import com.signv.domain.Goods;

import java.util.List;

public interface GoodsService {
    List<Goods> getGoodsList();

    List<Goods> getGoodsPage(Integer start);

    Goods getGoods(int goodsId);
    //更新货物信息
    void updateGoodsByGoodsId(Goods goods);
    //添加货物信息
    void insertGoods(Goods goods);
    //根据仓库号获取货物列表
    List<Goods> getGoodsListByRepositoryNum(Integer repositoryNum);
    //根据仓库号分页显示货物列表
    List<Goods> getGoodsPageRepositoryNum(Integer repositoryNum,Integer start);

    void deleteGoods(int goodsId);
}
