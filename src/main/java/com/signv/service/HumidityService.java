package com.signv.service;

import com.signv.domain.Humidity;

import java.util.List;

public interface HumidityService {
    List<Integer> getPageSize();

    List<Humidity> getPage(Integer first);
}
