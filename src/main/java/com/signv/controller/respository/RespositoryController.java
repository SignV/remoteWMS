package com.signv.controller.respository;

import com.alibaba.fastjson.JSONObject;
import com.signv.domain.Goods;
import com.signv.domain.Repository;
import com.signv.listener.MyRunnable;
import com.signv.listener.SocketOperate;
import com.signv.service.GoodsService;
import com.signv.service.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "respository")
public class RespositoryController {
    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private GoodsService goodsService;

    //分页显示仓库信息
    @RequestMapping(value = "/showRespository")
    public String showRespository(Integer first,HttpServletRequest request){
        HttpSession session = request.getSession();
        //获取分页的页数
        List<Repository> repositoryList = repositoryService.getRepositoryList();
        int size = repositoryList.size();
        int page = size/10;
        List<Integer> pageSize = new ArrayList<Integer>();
        for (int i = 1;i <= page;i++){
            pageSize.add(i+1);
        }
        //分页操作
        Integer start = (first-1) * 10;
        List<Repository> repositoryPageList = repositoryService.getRepositoryPage(start);
        //保存分页列表
        session.setAttribute("repositoryList",repositoryPageList);
        //保存选中的页数
        session.setAttribute("num",first);
        //保存分页的页数
        session.setAttribute("pageSize",pageSize);
        return "respository/showRespository";
    }

    @RequestMapping(value = "/editRespository")
    @ResponseBody
    public String editRespository(@RequestParam(value = "repository") String repositoryJson){
        Repository repository = JSONObject.parseObject(repositoryJson,Repository.class);
        String builtArea = repository.getBuiltArea();
        String m2 = builtArea.substring(builtArea.length()-1);
        if(!m2.equals("㎡")){
            builtArea += "㎡";
        }
        repository.setBuiltArea(builtArea);
        repositoryService.updataRepository(repository);
        return "success";
    }

    @RequestMapping(value = "/respositoryInsert")
    public String respositoryInsert(){
        return "respository/respositoryInsert";
    }

    @RequestMapping(value = "/repositoryInsertAdd")
    @ResponseBody
    public String repositoryInsertAdd(@RequestParam(value = "respository") String repositoryJson){
        Repository repository = JSONObject.parseObject(repositoryJson,Repository.class);
        repository.setBuiltArea(repository.getBuiltArea() + "㎡");
        repositoryService.insertRepository(repository);
        return "success";
    }

    //按仓库分页显示商品
    @RequestMapping(value = "/goodsPageList")
    public String goodsPageList(Integer first,Integer repositoryNum,HttpServletRequest request){
        HttpSession session = request.getSession();
        //根据仓库号获取的货物列表的分页的页数
        List<Goods> goodsList = goodsService.getGoodsListByRepositoryNum(repositoryNum);
        int size = goodsList.size();
        int page = size/10;
        List<Integer> pageSize = new ArrayList<Integer>();
        for (int i = 1;i <= page;i++){
            pageSize.add(i+1);
        }
        //分页操作
        Integer start = (first-1) * 10;
        List<Goods> goodsPageList = goodsService.getGoodsPageRepositoryNum(repositoryNum,start);
        //保存分页列表
        session.setAttribute("goodsList",goodsPageList);
        //保存选中的仓库号
        session.setAttribute("repositoryNum",repositoryNum);
        //保存选中的页数
        session.setAttribute("num",first);
        //保存分页的页数
        session.setAttribute("pageSize",pageSize);
        return "respository/goodsList";
    }

    //删除仓库的信息
    @RequestMapping(value = "/deleteRespository")
    @ResponseBody
    public String deleteRespository(@RequestParam(value = "respositoryNum")int respositoryNum,HttpServletRequest request){
        repositoryService.deleteRespository(respositoryNum);
        return "success";
    }

    //开启仓库管理
    @RequestMapping(value = "/openRespository")
    @ResponseBody
    public String openRespository(@RequestParam(value = "respositoryNum")int respositoryNum,HttpServletRequest request){
        MyRunnable runnable = SocketOperate.runnables.get("this");
        if(runnable != null){
            System.out.println(runnable);
            System.out.println(runnable.num);
            runnable.setNum(1);
        }
        return "success";
    }

    //关闭仓库管理
    @RequestMapping(value = "/closeRespository")
    @ResponseBody
    public String closeRespository(@RequestParam(value = "respositoryNum")int respositoryNum,HttpServletRequest request){
        MyRunnable runnable = SocketOperate.runnables.get("this");
        if(runnable != null){
            System.out.println(runnable);
            System.out.println(runnable.num);
            runnable.setNum(2);
        }
        return "success";
    }
}
