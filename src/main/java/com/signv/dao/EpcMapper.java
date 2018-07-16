package com.signv.dao;

import com.signv.domain.Epc;
import com.signv.domain.EpcExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EpcMapper {
    long countByExample(EpcExample example);

    int deleteByExample(EpcExample example);

    int deleteByPrimaryKey(Integer epcId);

    int insert(Epc record);

    int insertSelective(Epc record);

    List<Epc> selectByExample(EpcExample example);

    Epc selectByPrimaryKey(Integer epcId);

    int updateByExampleSelective(@Param("record") Epc record, @Param("example") EpcExample example);

    int updateByExample(@Param("record") Epc record, @Param("example") EpcExample example);

    int updateByPrimaryKeySelective(Epc record);

    int updateByPrimaryKey(Epc record);

    List<Epc> getEpcList();

    List<Epc> getEpcPage(Integer start);

    Epc getEpcByEpcCode(String epcCode);
}