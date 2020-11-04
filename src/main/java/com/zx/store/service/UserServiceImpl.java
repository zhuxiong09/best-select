package com.zx.store.service;

import com.zx.store.bean.User;
import com.zx.store.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectUserByEmailAndPassword(String email, String password) {
        User user = userMapper.selectByEmailAndPassword(email, password);
        return user;
    }

    @Override
    public User selectUserByUsernameAndPassword(String username, String password) {
        User user = userMapper.selectByUsernameAndPassword(username, password);
        return user;
    }

    @Override
    public User selectByUsername(String username) {

        return userMapper.selectByUsername(username);
    }

    @Override
    public User selectByEmail(String email) {
        return userMapper.selectByEmail(email);
    }
}
