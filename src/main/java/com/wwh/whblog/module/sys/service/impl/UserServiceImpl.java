package com.wwh.whblog.module.sys.service.impl;

import com.wwh.whblog.module.sys.entity.User;
import com.wwh.whblog.module.sys.repository.UserRepository;
import com.wwh.whblog.module.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(String userId) {
        return userRepository.getUserById(userId);
    }

    @Override
    public User getUserByUserName(String userName) {
        return userRepository.getUserByUserName(userName);
    }
}
