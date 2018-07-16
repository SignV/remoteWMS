package com.signv.controller.epc;

import com.alibaba.fastjson.JSONObject;
import com.signv.domain.Epc;
import com.signv.service.EpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "/epc")
public class EpcController {
    @Autowired
    private EpcService epcService;

    //分页显示epc码
    @RequestMapping(value = "/epcPageList")
    public String epcPageList(Integer first,HttpServletRequest request){
        HttpSession session = request.getSession();
        List<Integer> epcPageSize = epcService.getPageSize();
        List<Epc> epcPageList = epcService.getPage(first);
        session.setAttribute("epcPageList",epcPageList);
        session.setAttribute("epcNum",first);
        session.setAttribute("epcPageSize",epcPageSize);
        return "epc/epcOperate";
    }

    //登记epc码
    @RequestMapping(value = "/epcInsert")
    @ResponseBody
    public String epcInsert(@RequestParam(value = "epc")String epcJSON, HttpServletRequest request){
        Epc epc = JSONObject.parseObject(epcJSON,Epc.class);
        epcService.epcInsert(epc);
        return "success";
    }
}
