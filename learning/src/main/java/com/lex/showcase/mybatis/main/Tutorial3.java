package com.lex.showcase.mybatis.main;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import com.lex.showcase.mybatis.GroupMapper;
import com.lex.showcase.mybatis.User;
import com.lex.showcase.mybatis.UserMapper;

public class Tutorial3 {

    private static Logger log = Logger.getLogger(Tutorial3.class);

    private static SqlSessionFactory factory;

    static {
        Reader reader = null;

        try {
            reader = Resources.getResourceAsReader("mybatis-config.xml");
        } catch (IOException e) {
            log.error("Exception loading mybatis config file!", e);
        }

        factory = new SqlSessionFactoryBuilder().build(reader);
    }

    public static void main(String[] args) {
        SqlSession session = factory.openSession();

        UserMapper mapper = session.getMapper(UserMapper.class);
        GroupMapper groupMapper = session.getMapper(GroupMapper.class);

        try {
            List<User> users = groupMapper.getGroupUsers(-1);
            log.info(users);

            session.commit();
        } catch (Exception e) {
            log.error("Exception operating DB! Will rollbak!", e);
            session.rollback();
        } finally {
            session.close();
        }
    }
}
