package com.demo.service;

import com.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public String getPassword(String username) {
        return userMapper.getPassword(username);
    }
}
