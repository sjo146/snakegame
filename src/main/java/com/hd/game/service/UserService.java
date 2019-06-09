package com.hd.game.service;

import com.hd.game.domain.User;

public interface UserService {
     User login(String name, String pwd);
     int insertNewUser(User user);
}
