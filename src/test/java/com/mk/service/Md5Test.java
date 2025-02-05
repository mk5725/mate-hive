package com.mk.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

@SpringBootTest
public class Md5Test {
    private static final String SALT = "12345678";
    @Test
    void test1(){
        String pwd = DigestUtils.md5DigestAsHex((SALT + "123456").getBytes());
        System.out.println(pwd);
    }
}
