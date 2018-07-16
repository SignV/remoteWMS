package com.signv.service;

import com.signv.domain.Admin;
import com.signv.domain.User;

import java.util.List;

public interface AdminService {
    Admin findAdminByUserId(Integer userId);
}
