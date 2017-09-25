package com.smart.service;

import com.smart.domain.User;
import com.smart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author Lex Li
 */
@ContextConfiguration("classpath*:/applicationContext.xml") // 启动Spring容器
public class UserServiceTesgNGTest extends AbstractTransactionalTestNGSpringContextTests {
    private UserService userService;


    @Test
    public void hasMatchUser() throws Exception {
        boolean b1 = userService.hasMatchUser("admin", "123456");
        boolean b2 = userService.hasMatchUser("admin", "1111");
        assertTrue(b1);
        assertTrue(!b2);
    }

    @Test
    public void findUserByUserName() throws Exception {
        User user = userService.findUserByUserName("admin");
        assertEquals(user.getUserName(), "admin");
    }

    @Test
    public void loginSuccess() throws Exception {
    }

    @Autowired // 注入Spring容器的Bean
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}