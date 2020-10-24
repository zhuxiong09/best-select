package com.zx.store.mapper;

import com.zx.store.bean.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapping {

    public User selectByUsername(String username);

    public User selectByEmail(String email);
}
