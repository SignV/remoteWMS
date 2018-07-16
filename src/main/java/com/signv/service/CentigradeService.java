package com.signv.service;

import com.signv.domain.Centigrade;

import java.util.List;

public interface CentigradeService {
    //获取分页的页数
    List<Integer> getPageSize();
    //分页操作
    List<Centigrade> getPage(int first);
}
