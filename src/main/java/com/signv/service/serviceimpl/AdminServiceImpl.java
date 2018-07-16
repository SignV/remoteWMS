package com.signv.service.serviceimpl;

import com.signv.dao.AdminMapper;
import com.signv.domain.Admin;
import com.signv.domain.User;
import com.signv.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "AdminService")
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    public Admin findAdminByUserId(Integer userId) {
        return adminMapper.findAdminByUserId(userId);
    }
}
