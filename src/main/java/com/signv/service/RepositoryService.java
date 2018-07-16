package com.signv.service;

import com.signv.domain.Repository;

import java.util.List;

public interface RepositoryService {
    List<Repository> getRepositoryList();

    List<Repository> getRepositoryPage(Integer start);

    void updataRepository(Repository repository);

    void insertRepository(Repository repository);

    void deleteRespository(int respositoryNum);

    Boolean respositorySocket(int sensorNum, int centigradeNum, int humidityNum);
}
