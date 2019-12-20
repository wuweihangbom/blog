package com.wwh.whblog.module.sys.service;

import com.wwh.whblog.module.sys.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<User> findAll();

    /**
     * 根据用户id获取用户
     *
     * @param userId 用户id
     * @return
     */
    User getUserById(String userId);

    /**
     * 根据登录名称获取用户列表
     *
     * @param userName 登录名称
     * @return
     */
    User getUserByUserName(String userName);

}
