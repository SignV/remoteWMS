package com.signv.dao;

import com.signv.domain.OutInStatistics;
import com.signv.domain.OutInStatisticsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OutInStatisticsMapper {
    long countByExample(OutInStatisticsExample example);

    int deleteByExample(OutInStatisticsExample example);

    int deleteByPrimaryKey(Integer outInId);

    int insert(OutInStatistics record);

    int insertSelective(OutInStatistics record);

    List<OutInStatistics> selectByExample(OutInStatisticsExample example);

    OutInStatistics selectByPrimaryKey(Integer outInId);

    int updateByExampleSelective(@Param("record") OutInStatistics record, @Param("example") OutInStatisticsExample example);

    int updateByExample(@Param("record") OutInStatistics record, @Param("example") OutInStatisticsExample example);

    int updateByPrimaryKeySelective(OutInStatistics record);

    int updateByPrimaryKey(OutInStatistics record);

    List<OutInStatistics> getOutInPage(Integer start);

    List<OutInStatistics> getOutInList();
}