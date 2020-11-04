package com.zx.store.mapper;

import com.zx.store.bean.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    public User selectByUsername(String username);

    public User selectByEmail(String email);

    public User selectByUsernameAndPassword(String username, String password);

    public User selectByEmailAndPassword(String email, String password);
}
