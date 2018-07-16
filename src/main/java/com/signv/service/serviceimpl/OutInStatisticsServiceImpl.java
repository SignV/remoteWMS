package com.signv.service.serviceimpl;

import com.signv.dao.OutInStatisticsMapper;
import com.signv.domain.OutInStatistics;
import com.signv.service.OutInStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "outInStatisticsService")
public class OutInStatisticsServiceImpl implements OutInStatisticsService {
    @Autowired
    private OutInStatisticsMapper outInStatisticsMapper;
    public void insertSelective(OutInStatistics outInStatistics) {
        outInStatisticsMapper.insertSelective(outInStatistics);
    }

    public List<OutInStatistics> getOutInList(){
        return outInStatisticsMapper.getOutInList();
    }
    public List<OutInStatistics> getOutInPage(Integer start) {
        return outInStatisticsMapper.getOutInPage(start);
    }
}
