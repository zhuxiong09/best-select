package com.zx.store.mapper;

import com.zx.store.bean.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LoginMapping {

    public User selectByUsername(String username);

    public User selectByEmail(String email);

    public User selectByUsernameAndPassword(String username, String password);

    public User selectByEmailAndPassword(String email, String password);

    public List<Goods> selectAllGoods();

    public DetailPage selectShopCarById(Integer id);

    public List<Property> selectPropertyById(Integer id);

    public List<DetailImage> selectDetailImageById(Integer id);

    public List<Size> selectSizeById(Integer id);

    public List<Color> selectColorById(Integer id);

    public void insertShopcar();
}

