package com.lex.showcase.mybatis.main;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import com.lex.showcase.mybatis.User;

public class Tutorial1 {

    private static Logger log = Logger.getLogger(Tutorial1.class);

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
                    "com.lex.webside.showcase.mybatis_spring.UserMapper.get",
                    -1);
            log.info(user);

            List<User> users = session
                    .selectList("com.lex.webside.showcase.mybatis_spring.UserMapper.findAll");
            log.info(users);

            session.commit();
        } finally {
            session.close();
        }
    }

}
