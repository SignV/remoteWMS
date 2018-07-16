package com.signv.dao;

import com.signv.domain.Centigrade;
import com.signv.domain.CentigradeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CentigradeMapper {
    long countByExample(CentigradeExample example);

    int deleteByExample(CentigradeExample example);

    int insert(Centigrade record);

    int insertSelective(Centigrade record);

    List<Centigrade> selectByExample(CentigradeExample example);

    int updateByExampleSelective(@Param("record") Centigrade record, @Param("example") CentigradeExample example);

    int updateByExample(@Param("record") Centigrade record, @Param("example") CentigradeExample example);

    List<Centigrade> getCentigradeList();

    List<Centigrade> getCentigradePage(Integer start);
}