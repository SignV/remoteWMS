package com.signv.controller.goods;

import com.alibaba.fastjson.JSONObject;
import com.signv.domain.Goods;
import com.signv.domain.OutInStatistics;
import com.signv.service.GoodsService;
import com.signv.service.OutInStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/goods")
public class GoodsController {
   @Autowired
   private GoodsService goodsService;
   @Autowired
   private OutInStatisticsService outInStatisticsService;

    @RequestMapping(value = "/goodsList")
    public String goodsList(HttpServletRequest request){
        HttpSession session = request.getSession();
        List<Goods> goodsList = goodsService.getGoodsList();

        int size = goodsList.size();
        int page = size/10;
        List<Integer> pageSize = new ArrayList<Integer>();
        for (int i = 1;i <= page;i++){
            pageSize.add(i+1);
        }
        session.setAttribute("goodsList",goodsList.subList(0,10));
        session.setAttribute("pageSize",pageSize);
        return "goods/goodsList";
    }
//分页显示商品
    @RequestMapping(value = "/goodsPageList")
    public String goodsPageList(Integer first,HttpServletRequest request){
        HttpSession session = request.getSession();
        //获取分页的页数
        List<Goods> goodsList = goodsService.getGoodsList();
        int size = goodsList.size();
        int page = size/10;
        List<Integer> pageSize = new ArrayList<Integer>();
        for (int i = 1;i <= page;i++){
            pageSize.add(i+1);
        }
        //分页操作
        Integer start = (first-1) * 10;
        List<Goods> goodsPageList = goodsService.getGoodsPage(start);
        //保存分页列表
        session.setAttribute("goodsList",goodsPageList);
        //保存选中的页数
        session.setAttribute("num",first);
        //保存分页的页数
        session.setAttribute("pageSize",pageSize);
        return "goods/goodsList";
    }

    //获取修改货品的信息
    @RequestMapping(value = "/getEditGoods")
    public String getEditGoods(@RequestParam(value = "goodsId")int goodsId,HttpServletRequest request){
        Goods goods = goodsService.getGoods(goodsId);
        request.setAttribute("goods",goods);
        return "goods/getEditGoods";
    }

    //修改货品的信息
    @RequestMapping(value = "/editGoods")
    @ResponseBody
    public String editGoods(@RequestParam(value = "goods") String goodsJSON,
                            @RequestParam(value = "outInStatus") String outInStatus,
                            @RequestParam(value = "outInNum") String outInNum,
                            HttpServletResponse response,
                            HttpServletRequest request) throws Exception {

        Goods goods = JSONObject.parseObject(goodsJSON,Goods.class);
        //如果传入的出入货值为0 则不进行出入货记录
        int num = Integer.parseInt(outInNum);
        if(num != 0){
            if(outInStatus.equals("out")){
                //出库货物信息设置
                OutInStatistics outInStatistics = new OutInStatistics();
                outInStatistics.setOutInGoodsId(goods.getGoodsId());
                outInStatistics.setOutInGoodsName(goods.getGoodsName());
                //出库数量
                outInStatistics.setOutInNum(num);
                //更改状态为出库
                outInStatistics.setOutInStatus(true);
                //出库的总金额
                outInStatistics.setOutInAmount(goods.getSalePrice() * Integer.parseInt(outInNum));
                //修改库存数量，出库多少需要在商品信息库存数量中减少相应的数量 修改库存总价格,库存数量 * 入库单价
                goods.setReserveNum(goods.getReserveNum() - num);
                goods.setTotalPrice(goods.getStockPrice() * goods.getReserveNum());
                //添加出库记录
                outInStatisticsService.insertSelective(outInStatistics);
            }else {
                //入库
                //入库货物信息设置
                OutInStatistics outInStatistics = new OutInStatistics();
                outInStatistics.setOutInGoodsId(goods.getGoodsId());
                outInStatistics.setOutInGoodsName(goods.getGoodsName());
                //入库数量
                outInStatistics.setOutInNum(num);
                //更改状态为入库
                outInStatistics.setOutInStatus(false);
                //入库的总金额
                outInStatistics.setOutInAmount(goods.getStockPrice() * Integer.parseInt(outInNum));
                //修改库存数量，入库多少需要在商品信息库存数量中加上相应的数量 修改库存总价格,库存数量 * 入库单价
                goods.setReserveNum(goods.getReserveNum() + num);
                goods.setTotalPrice(goods.getStockPrice() * goods.getReserveNum());
                //添加入库记录
                outInStatisticsService.insertSelective(outInStatistics);
            }
        }
        //修改货物信息
        goodsService.updateGoodsByGoodsId(goods);
        //保存操作成功信息
        request.setAttribute("goods",goods);
        return "success";
    }

    //分页显示出入库记录
    @RequestMapping(value = "/getOutInStatisticsPageList")
    public String getOutInStatisticsPageList(Integer first,HttpServletRequest request){
        HttpSession session = request.getSession();
        //获取分页的页数
        List<OutInStatistics> outInStatisticsList = outInStatisticsService.getOutInList();
        int size = outInStatisticsList.size();
        int page = size/10;
        List<Integer> pageSize = new ArrayList<Integer>();
        for (int i = 1;i <= page;i++){
            pageSize.add(i+1);
        }
        //分页操作
        Integer start = (first-1) * 10;
        List<OutInStatistics> outInStatisticsPageList = outInStatisticsService.getOutInPage(start);
        //保存分页列表
        session.setAttribute("outInStatisticsList",outInStatisticsPageList);
        //保存选中的页数
        session.setAttribute("num",first);
        //保存分页的页数
        session.setAttribute("pageSize",pageSize);
        return "goods/outInStatisticsList";
    }

    @RequestMapping(value = "/goodsInsert")
    public String goodsInsert(){
        return "goods/goodsInsert";
    }

    //修改货品的信息
    @RequestMapping(value = "/goodsInsertAdd")
    @ResponseBody
    @Transactional
    public String goodsInsertAdd(@RequestParam(value = "goods") String goodsJSON,
                            @RequestParam(value = "outInStatus") String outInStatus,
                            @RequestParam(value = "outInNum") String outInNum,
                            HttpServletResponse response,
                            HttpServletRequest request) throws Exception {

        Goods goods = JSONObject.parseObject(goodsJSON,Goods.class);
        //如果传入的出入货值为0 则不进行出入货记录
        int num = Integer.parseInt(outInNum);
        if(num != 0){
            if(outInStatus.equals("out")){
                //出库货物信息设置
                OutInStatistics outInStatistics = new OutInStatistics();
                outInStatistics.setOutInGoodsId(goods.getGoodsId());
                outInStatistics.setOutInGoodsName(goods.getGoodsName());
                //出库数量
                outInStatistics.setOutInNum(num);
                //更改状态为出库
                outInStatistics.setOutInStatus(true);
                //出库的总金额
                outInStatistics.setOutInAmount(goods.getSalePrice() * Integer.parseInt(outInNum));

                goods.setReserveNum(goods.getReserveNum() - num);
                goods.setTotalPrice(goods.getStockPrice() * goods.getReserveNum());
                //添加出库记录
                outInStatisticsService.insertSelective(outInStatistics);
            }else {
                //入库
                //入库货物信息设置
                OutInStatistics outInStatistics = new OutInStatistics();
                outInStatistics.setOutInGoodsId(goods.getGoodsId());
                outInStatistics.setOutInGoodsName(goods.getGoodsName());
                //入库数量
                outInStatistics.setOutInNum(num);
                //更改状态为入库
                outInStatistics.setOutInStatus(false);
                //入库的总金额
                outInStatistics.setOutInAmount(goods.getStockPrice() * Integer.parseInt(outInNum));

                goods.setReserveNum(goods.getReserveNum() + num);
                goods.setTotalPrice(goods.getStockPrice() * goods.getReserveNum());
                //添加入库记录
                outInStatisticsService.insertSelective(outInStatistics);
            }
        }
        //修改货物信息
        goodsService.insertGoods(goods);
        //保存操作成功信息
        request.setAttribute("goods",goods);
        return "success";
    }

    //删除货品的信息
    @RequestMapping(value = "/deleteGoods")
    @ResponseBody
    public String deleteGoods(@RequestParam(value = "goodsId")int goodsId,HttpServletRequest request){
        goodsService.deleteGoods(goodsId);
        return "success";
    }
}
