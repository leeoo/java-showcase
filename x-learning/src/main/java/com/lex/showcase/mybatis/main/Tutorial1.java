package com.lex.showcase.mybatis.main;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.lex.showcase.mybatis.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Tutorial1 {

    private static Logger log = LoggerFactory.getLogger(Tutorial1.class);

    private static SqlSessionFactory factory;

    static {
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader("mybatis-config.xml");
        } catch (IOException e) {
            log.error("Exception loading mybatis configuration file!", e);
        }
        factory = new SqlSessionFactoryBuilder().build(reader);
    }

    public static void main(String[] args) {
        SqlSession session = factory.openSession();
        try {
            User user = session.selectOne(
                    "com.lex.showcase.mybatis.UserMapper.get",
                    -1);
            log.info("user: {}", user);

            List<User> users = session
                    .selectList("com.lex.showcase.mybatis.UserMapper.findAll");
            log.info("users: {}", users);

            session.commit();
        } finally {
            session.close();
        }
    }

}
