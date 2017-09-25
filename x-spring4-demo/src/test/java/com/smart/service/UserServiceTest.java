package com.smart.service;

import com.smart.domain.User;
import com.smart.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * @author Lex Li
 */
@ContextConfiguration("classpath*:/smart-context.xml") // 启动Spring容器
public class UserServiceTest extends AbstractTransactionalJUnit4SpringContextTests {
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
        User user = new User();
        user.setUserId(1);
        user.setUserName("admin");
        user.setCredits(0);
        userService.loginSuccess(user);
    }

    @Autowired // 注入Spring容器的Bean
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}