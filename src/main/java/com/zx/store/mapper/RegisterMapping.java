package com.zx.store.mapper;

import com.zx.store.bean.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RegisterMapping {

    public void insertUser(User user);
}
