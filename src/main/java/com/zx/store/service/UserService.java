package com.zx.store.service;

import com.zx.store.bean.User;

public interface UserService {
    public User selectUserByEmailAndPassword(String email, String password);

    public User selectUserByUsernameAndPassword(String username, String password);

    public User selectByUsername(String username);

    public User selectByEmail(String email);
}
