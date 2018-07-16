package com.signv.service;

import com.signv.domain.Epc;

import java.util.List;

public interface EpcService {
    List<Integer> getPageSize();

    List<Epc> getPage(Integer first);

    void epcInsert(Epc epc);

    Boolean epcSocket(String epcCode);
}
