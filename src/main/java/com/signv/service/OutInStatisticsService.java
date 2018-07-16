package com.signv.service;

import com.signv.domain.OutInStatistics;

import java.util.List;

public interface OutInStatisticsService {
    void insertSelective(OutInStatistics outInStatistics);
    List<OutInStatistics> getOutInList();
    List<OutInStatistics> getOutInPage(Integer start);
}
