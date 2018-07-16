package com.signv.service.serviceimpl;

import com.signv.dao.CentigradeMapper;
import com.signv.domain.Centigrade;
import com.signv.service.CentigradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service(value = "CentigradeService")
public class CentigradeServiceImpl implements CentigradeService {
    @Autowired
    private CentigradeMapper centigradeMapper;

    public List<Integer> getPageSize() {
        List<Centigrade> centigradeList = centigradeMapper.getCentigradeList();
        int size = centigradeList.size();
        int page = size/10;
        List<Integer> pageSize = new ArrayList<Integer>();
        for (int i = 1;i <= page;i++){
            pageSize.add(i+1);
        }
        return pageSize;
    }

    public List<Centigrade> getPage(int first) {
        Integer start = (first-1) * 10;
        List<Centigrade> centigradePageList = centigradeMapper.getCentigradePage(start);
        return centigradePageList;
    }
}
