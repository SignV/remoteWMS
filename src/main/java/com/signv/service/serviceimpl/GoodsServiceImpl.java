package com.signv.service.serviceimpl;

import com.signv.dao.GoodsMapper;
import com.signv.domain.Goods;
import com.signv.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service(value = "goodsService")
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    public List<Goods> getGoodsList() {
        List<Goods> goodsList = goodsMapper.getGoodsList();
        return goodsList;
    }

    public List<Goods> getGoodsPage(Integer start) {
        return goodsMapper.getGoodsPage(start);
    }

    public Goods getGoods(int goodsId) {
        return goodsMapper.selectByPrimaryKey(goodsId);
    }

    public void updateGoodsByGoodsId(Goods goods) {
        goodsMapper.updateByPrimaryKey(goods);
    }

    public void insertGoods(Goods goods) {
        goodsMapper.insertSelective(goods);
    }

    public List<Goods> getGoodsListByRepositoryNum(Integer repositoryNum) {
        return goodsMapper.getGoodsListByRepositoryNum(repositoryNum);
    }

    public List<Goods> getGoodsPageRepositoryNum(Integer repositoryNum,Integer start) {
        return goodsMapper.getGoodsPageRepository(repositoryNum,start);
    }

    public void deleteGoods(int goodsId) {
        goodsMapper.deleteByPrimaryKey(goodsId);
    }
}
