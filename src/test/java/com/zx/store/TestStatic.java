package com.zx.store;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestStatic {
    @Test
    public void test(){
        StoreApplicationTests st= new StoreApplicationTests();
        st.b="asfdas";
        st.a=2;
        System.out.println(st.b);
        System.out.println(st.a);
        StoreApplicationTests st1= new StoreApplicationTests();
//        st1.b="as";
//        st1.a=3;
        System.out.println(st1.b);
        System.out.println(st1.a);
    }
}
