package com.signv.service.serviceimpl;

import com.signv.dao.CentigradeMapper;
import com.signv.dao.HumidityMapper;
import com.signv.dao.RepositoryMapper;
import com.signv.domain.Centigrade;
import com.signv.domain.Humidity;
import com.signv.domain.Repository;
import com.signv.service.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service(value = "RepositoryService")
public class RepositoryServiceImol implements RepositoryService {
    @Autowired
    private RepositoryMapper repositoryMapper;
    @Autowired
    private CentigradeMapper centigradeMapper;
    @Autowired
    private HumidityMapper humidityMapper;

    public List<Repository> getRepositoryList() {
        return repositoryMapper.getRepositoryList();
    }

    public List<Repository> getRepositoryPage(Integer start) {
        return repositoryMapper.getRepositoryPage(start);
    }

    public void updataRepository(Repository repository) {
        repositoryMapper.updateByPrimaryKeySelective(repository);
    }

    public void insertRepository(Repository repository) {
        repositoryMapper.insertSelective(repository);
    }

    public void deleteRespository(int respositoryNum) {
        repositoryMapper.deleteByPrimaryKey(respositoryNum);
    }

    public Boolean respositorySocket(int sensorNum, int centigradeNum, int humidityNum) {
        Centigrade centigrade = new Centigrade(centigradeNum,3,sensorNum);
        Humidity humidity = new Humidity(humidityNum,3,sensorNum);
        centigradeMapper.insertSelective(centigrade);
        humidityMapper.insertSelective(humidity);
        if(centigradeNum > 40 || humidityNum >80){
            return false;
        }
        return true;
    }
}
