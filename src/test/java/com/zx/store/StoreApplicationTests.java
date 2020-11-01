package com.zx.store;

import com.zx.store.bean.Goods;
import com.zx.store.mapper.LoginMapping;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StoreApplicationTests {
    @Autowired
    private LoginMapping loginMapping;

    @Test
    void contextLoads() {
        List<Goods> goods = loginMapping.selectAllGoods();
        int a = goods.size();
        System.out.println(a);

//        User user1 = loginMapping.selectByUsername("zx");
//        System.out.println(user1);
    }

}
