package com.signv.service.serviceimpl;

import com.signv.dao.EpcMapper;
import com.signv.dao.GoodsMapper;
import com.signv.domain.Epc;
import com.signv.domain.Goods;
import com.signv.domain.OutInStatistics;
import com.signv.service.EpcService;
import com.signv.service.GoodsService;
import com.signv.service.OutInStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "EpcService")
public class EpcServiceImpl implements EpcService{
    @Autowired
    private EpcMapper epcMapper;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private OutInStatisticsService outInStatisticsService;

    public List<Integer> getPageSize() {
        List<Epc> epcList = epcMapper.getEpcList();
        int size = epcList.size();
        int page = size/10;
        List<Integer> pageSize = new ArrayList<Integer>();
        for (int i = 1;i <= page;i++){
            pageSize.add(i+1);
        }
        return pageSize;
    }

    public List<Epc> getPage(Integer first) {
        Integer start = (first-1) * 10;
        List<Epc> epcPageList = epcMapper.getEpcPage(start);
        return epcPageList;
    }

    public void epcInsert(Epc epc) {
        epcMapper.insertSelective(epc);
    }

    public Boolean epcSocket(String epcCode) {
        Epc epc = epcMapper.getEpcByEpcCode(epcCode);
        if(epc == null){
            return false;
        }
        int epcStatus = epc.getEpcStatus();
        if(epcStatus == 3){
            return false;
        }
        int goodsId = epc.getEpcGoodsId();
        int num = epc.getOutInNum();
        Goods goods = goodsService.getGoods(goodsId);
        if(epcStatus == 2){  //epcStatus为2 入库状态 则需要出库
            //出库货物信息设置
            OutInStatistics outInStatistics = new OutInStatistics();
            outInStatistics.setOutInGoodsId(goods.getGoodsId());
            outInStatistics.setOutInGoodsName(goods.getGoodsName());
            //出库数量
            outInStatistics.setOutInNum(num);
            //更改状态为出库
            outInStatistics.setOutInStatus(true);
            //出库的总金额
            outInStatistics.setOutInAmount(goods.getSalePrice() * num);

            //修改库存数量，出库多少需要在商品信息库存数量中减少相应的数量 修改库存总价格,库存数量 * 入库单价
            goods.setReserveNum(goods.getReserveNum() - num);
            goods.setTotalPrice(goods.getStockPrice() * goods.getReserveNum());
            //添加出库记录
            outInStatisticsService.insertSelective(outInStatistics);
            //修改状态为出库已完成 并保存信息
            epc.setEpcStatus(3);
            epcMapper.updateByPrimaryKeySelective(epc);
        }else {        //epcStatus为1 未入库状态 则需要入库
            //入库货物信息设置
            OutInStatistics outInStatistics = new OutInStatistics();
            outInStatistics.setOutInGoodsId(goods.getGoodsId());
            outInStatistics.setOutInGoodsName(goods.getGoodsName());
            //入库数量
            outInStatistics.setOutInNum(num);
            //更改状态为入库
            outInStatistics.setOutInStatus(false);
            //入库的总金额
            outInStatistics.setOutInAmount(goods.getStockPrice() * num);

            //修改库存数量，入库多少需要在商品信息库存数量中加上相应的数量 修改库存总价格,库存数量 * 入库单价
            goods.setReserveNum(goods.getReserveNum() + num);
            goods.setTotalPrice(goods.getStockPrice() * goods.getReserveNum());
            //添加入库记录
            outInStatisticsService.insertSelective(outInStatistics);
            //修改状态为入库 并保存信息
            epc.setEpcStatus(2);
            epcMapper.updateByPrimaryKeySelective(epc);
        }
        //更新货物信息
        goodsService.updateGoodsByGoodsId(goods);
        return true;
    }
}
