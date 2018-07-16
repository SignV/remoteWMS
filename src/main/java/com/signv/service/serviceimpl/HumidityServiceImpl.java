package com.signv.service.serviceimpl;

import com.signv.dao.HumidityMapper;
import com.signv.domain.Humidity;
import com.signv.service.HumidityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service(value = "HumidityService")
public class HumidityServiceImpl implements HumidityService {
    @Autowired
    private HumidityMapper humidityMapper;

    public List<Integer> getPageSize() {
        List<Humidity> humidityList = humidityMapper.getHumidityList();
        int size = humidityList.size();
        int page = size/10;
        List<Integer> pageSize = new ArrayList<Integer>();
        for (int i = 1;i <= page;i++){
            pageSize.add(i+1);
        }
        return pageSize;
    }

    public List<Humidity> getPage(Integer first) {
        Integer start = (first-1) * 10;
        List<Humidity> humidityPageList = humidityMapper.getHumidityPage(start);
        return humidityPageList;
    }
}
