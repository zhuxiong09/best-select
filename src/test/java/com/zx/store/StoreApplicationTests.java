package com.zx.store;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StoreApplicationTests {
//    @Test
//    public void system(){
//        System.out.println("-1.5round结果："+Math.round(-1.5));
//        System.out.println("-1.6round结果："+Math.round(-1.6));
//        System.out.println("-1.4round结果："+Math.round(-1.4));
//        System.out.println("1.4round结果："+Math.round(1.4));
//        System.out.println("1.5round结果："+Math.round(1.5));
//        System.out.println("1.6round结果："+Math.round(1.6));
//        String s = new String();
//        s="safdsadfgadfgadgf";
//        int a = s.length();
//        int b = s.indexOf("a");
//        System.out.println(a+"+"+b);
//    }
//
    static int a = 1;
    String b;
    @Test
    public void test(){
        StoreApplicationTests st= new StoreApplicationTests();
        System.out.println(st.b);
        System.out.println(st.a);
        st.b="asfdas";
        st.a=3;
        System.out.println(st.b);
        System.out.println(st.a);
        StoreApplicationTests st1= new StoreApplicationTests();
//        st1.b="as";
//        st1.a=3;
        System.out.println(st1.b);
        System.out.println(st1.a);
    }

}
