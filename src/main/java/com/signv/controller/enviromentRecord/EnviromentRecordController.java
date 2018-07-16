package com.signv.controller.enviromentRecord;

import com.alibaba.fastjson.JSONObject;
import com.signv.domain.Centigrade;
import com.signv.domain.Humidity;
import com.signv.service.CentigradeService;
import com.signv.service.HumidityService;
import com.signv.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@RequestMapping(value = "/enviroment")
@Controller
public class EnviromentRecordController {
    @Autowired
    private CentigradeService centigradeService;
    @Autowired
    private HumidityService humidityService;

    //分页显示温度湿度
    @RequestMapping(value = "/showEnvironment")
    public String showEnvironment(Integer first,HttpServletRequest request){
        HttpSession session = request.getSession();
        //获取温度分页的页数
        List<Integer> cenPageSize = centigradeService.getPageSize();
        int maxCen = cenPageSize.size()+1;
        cenPageSize = cenPageSize.subList(0,9);
        //温度分页操作
        List<Centigrade> centigradePageList = centigradeService.getPage(first);
        //保存温度分页列表
        session.setAttribute("cenPageList",centigradePageList);
        //保存温度选中的页数
        session.setAttribute("cenNum",first);
        //保存温度分页的页数
        session.setAttribute("cenPageSize",cenPageSize);
        //保存温度最大页数
        session.setAttribute("maxCen",maxCen);
        //获取湿度分页的页数
        List<Integer> humPageSize = humidityService.getPageSize();
        int maxHum = humPageSize.size()+1;
        humPageSize = humPageSize.subList(0,9);
        //湿度分页操作
        List<Humidity> humidityPageList = humidityService.getPage(first);
        //保存湿度分页列表
        session.setAttribute("humPageList",humidityPageList);
        //保存湿度选中的页数
        session.setAttribute("humNum",first);
        //保存湿度分页的页数
        session.setAttribute("humPageSize",humPageSize);
        //保存湿度最大页数
        session.setAttribute("maxHum",maxHum);
        return "respository/showEnvironment";
    }

    //温度根据页数显示商品
    @RequestMapping(value = "/showCen")
    public String showCen(@RequestParam(value = "first") Integer first,HttpServletRequest request){
        HttpSession session = request.getSession();
        //获取温度分页的页数
        List<Integer> cenPageSize = centigradeService.getPageSize();
        int max = cenPageSize.size()+1;
        if(first >= 6 && first <(max - 5) ){
            for (Integer cenPage:cenPageSize) {
                if(cenPage == first){
                    cenPageSize = cenPageSize.subList(first-5,first+4);
                }
            }
        }else if(first < 6){
            cenPageSize = cenPageSize.subList(0,9);
        }else if(first >= (max - 5)){
            cenPageSize = cenPageSize.subList(max-10,max-1);
        }
        //温度分页操作
        List<Centigrade> centigradePageList = centigradeService.getPage(first);
        //保存温度分页列表
        session.setAttribute("cenPageList",centigradePageList);
        //保存温度选中的页数
        session.setAttribute("cenNum",first);
        //保存温度分页的页数
        session.setAttribute("cenPageSize",cenPageSize);
        session.setAttribute("maxCen",max);
        return "respository/showEnvironment";
    }
    //湿度根据页数显示商品
    @RequestMapping(value = "/showHum")
    public String showHum(@RequestParam(value = "first") Integer first, HttpServletRequest request,
                          HttpServletResponse response){
        HttpSession session = request.getSession();
        //获取湿度分页的页数
        List<Integer> humPageSize = humidityService.getPageSize();
        int max = humPageSize.size()+1;
        if(first >= 6 && first <(max - 5) ){
            for (Integer cenPage:humPageSize) {
                if(cenPage == first){
                    humPageSize = humPageSize.subList(first-5,first+4);
                }
            }
        }else if(first < 6){
            humPageSize = humPageSize.subList(0,9);
        }else if(first >= (max   - 5)){
            humPageSize = humPageSize.subList(max-10,max-1);
        }
        //湿度分页操作
        List<Humidity> humidityPageList = humidityService.getPage(first);
//        保存湿度分页列表
        session.setAttribute("humPageList",humidityPageList);
//        保存湿度选中的页数
        session.setAttribute("humNum",first);
//        保存湿度分页的页数
        session.setAttribute("humPageSize",humPageSize);
        session.setAttribute("maxHum",max);
        return "respository/showEnvironment";
    }

    //温度跳转页面
    @RequestMapping(value = "/jumpCen")
    public String jumpCen(@RequestParam(value = "first") Integer first,HttpServletRequest request){
        HttpSession session = request.getSession();
        //获取温度分页的页数
        List<Integer> cenPageSize = centigradeService.getPageSize();
        int max = cenPageSize.size()+1;
        if(first >= 6 && first <(max - 5) ){
            for (Integer cenPage:cenPageSize) {
                if(cenPage == first){
                    cenPageSize = cenPageSize.subList(first-5,first+4);
                }
            }
        }else if(first < 6){
            cenPageSize = cenPageSize.subList(0,9);
        }else if(first >= (max - 5)){
            cenPageSize = cenPageSize.subList(max-10,max-1);
        }
        //温度分页操作
        List<Centigrade> centigradePageList = centigradeService.getPage(first);
        //保存温度分页列表
            session.setAttribute("cenPageList",centigradePageList);
        //保存温度选中的页数
        session.setAttribute("cenNum",first);
        //保存温度分页的页数
        session.setAttribute("cenPageSize",cenPageSize);
        session.setAttribute("maxCen",max);
        return "respository/showEnvironment";
    }
}
