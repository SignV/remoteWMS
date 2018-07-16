package com.signv.dao;

import com.signv.domain.Repository;
import com.signv.domain.RepositoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RepositoryMapper {
    long countByExample(RepositoryExample example);

    int deleteByExample(RepositoryExample example);

    int deleteByPrimaryKey(Integer repositoryNum);

    int insert(Repository record);

    int insertSelective(Repository record);

    List<Repository> selectByExample(RepositoryExample example);

    Repository selectByPrimaryKey(Integer repositoryNum);

    int updateByExampleSelective(@Param("record") Repository record, @Param("example") RepositoryExample example);

    int updateByExample(@Param("record") Repository record, @Param("example") RepositoryExample example);

    int updateByPrimaryKeySelective(Repository record);

    int updateByPrimaryKey(Repository record);

    List<Repository> getRepositoryList();

    List<Repository> getRepositoryPage(Integer start);
}