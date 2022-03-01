package com.example.comprehensiveexecise.mapper;

import com.example.comprehensiveexecise.entity.User;
import com.example.comprehensiveexecise.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class UserMapperTest {
    @Test
    void login() {
        UserService userService = new UserService();
        User user = userService.login("zhangsan","123");
        if(user!=null){
            log.info(String.valueOf(user));
        }
    }
    @Test
    void regist() {
        UserService userService = new UserService();
        boolean user = userService.regist("zhangsan1","123");
        System.out.println(user);
//        if(user!=null){
//            log.info(String.valueOf(user));
//        }
    }
}
