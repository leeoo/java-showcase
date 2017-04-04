package com.lex.showcase.mybatis.main;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import com.lex.showcase.mybatis.User;
import com.lex.showcase.mybatis.UserMapper;

public class Tutorial2 {

    private static Logger log = Logger.getLogger(Tutorial2.class);

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

        try {
            User user = mapper.get(1);
            log.info(user);

            user = mapper.get(-1);
            log.info(user);

            List<User> users = mapper.findAll();
            log.info(users);

            users = mapper.getUsers("user-1");
            log.info(users);

            User userToSave = new User();
            userToSave.setName("Lex");
            userToSave.setLoginName("Lex");
            mapper.save(userToSave);
            log.info(userToSave);

            session.commit();

            List<User> usersToSave = new ArrayList<User>();
            usersToSave.add(userToSave);
            userToSave.setName("Ken");
            userToSave.setLoginName("Ken");
            usersToSave.add(userToSave);
            mapper.batchInsert(usersToSave);
            log.info(usersToSave);

            User userToUpdate = new User();
            userToUpdate.setId(-1);
            userToUpdate.setName("Joe");
            userToUpdate.setLoginName("Joe");
            mapper.update(userToUpdate);
            log.info(userToUpdate);

            mapper.delete(-2);

            session.commit();
        } catch (Exception e) {
            log.error("Exception operating DB! Will rollbak!", e);
            session.rollback();
        } finally {
            session.close();
        }
    }
}
