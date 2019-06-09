package com.hd.game.service.impl;

import com.hd.game.dao.UserMapper;
import com.hd.game.domain.User;
import com.hd.game.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public User login(String name, String pwd) {
        System.out.println("impl");
        return userMapper.queryUserByIdAndPwd(name, pwd);
    }

    @Override
    public int insertNewUser(User user) {
        return userMapper.insertNewUser(user);
    }
}
