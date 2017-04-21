package com.lex.showcase.mybatis.main;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lex.showcase.mybatis.GroupMapper;
import com.lex.showcase.mybatis.User;
import com.lex.showcase.mybatis.UserMapper;

public class Tutorial4 {

    private static Logger log = LoggerFactory.getLogger(Tutorial4.class);

    private static ApplicationContext ctx;

    static {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    public static void main(String[] args) {
        UserMapper userMapper = (UserMapper) ctx.getBean("userMapper");
        GroupMapper groupMapper = (GroupMapper) ctx.getBean("groupMapper");

        User user = userMapper.get(-1);
        log.info("user: {}", user);

        List<User> users = userMapper.findAll();
        log.info("users: {}", users);

        users = groupMapper.getGroupUsers(-1);
        log.info("users: {}", users);
    }
}
