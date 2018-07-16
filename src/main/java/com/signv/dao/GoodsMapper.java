package com.signv.dao;

import com.signv.domain.Goods;
import com.signv.domain.GoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsMapper {
    long countByExample(GoodsExample example);

    int deleteByExample(GoodsExample example);

    int deleteByPrimaryKey(Integer goodsId);

    int insert(Goods record);

    int insertSelective(Goods record);

    List<Goods> selectByExample(GoodsExample example);

    Goods selectByPrimaryKey(Integer goodsId);

    int updateByExampleSelective(@Param("record") Goods record, @Param("example") GoodsExample example);

    int updateByExample(@Param("record") Goods record, @Param("example") GoodsExample example);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);

    List<Goods> getGoodsList();

    List<Goods> getGoodsPage(Integer start);

    List<Goods> getGoodsListByRepositoryNum(Integer repositoryNum);

    List<Goods> getGoodsPageRepository(@Param(value = "repositoryNum") Integer repositoryNum,@Param(value = "start") Integer start);
}