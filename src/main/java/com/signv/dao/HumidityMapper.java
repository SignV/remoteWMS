package com.signv.dao;

import com.signv.domain.Humidity;
import com.signv.domain.HumidityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HumidityMapper {
    long countByExample(HumidityExample example);

    int deleteByExample(HumidityExample example);

    int insert(Humidity record);

    int insertSelective(Humidity record);

    List<Humidity> selectByExample(HumidityExample example);

    int updateByExampleSelective(@Param("record") Humidity record, @Param("example") HumidityExample example);

    int updateByExample(@Param("record") Humidity record, @Param("example") HumidityExample example);

    List<Humidity> getHumidityList();

    List<Humidity> getHumidityPage(Integer start);
}