package com.lex.showcase.mybatis.main;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lex.showcase.mybatis.User;
import com.lex.showcase.mybatis.UserMapper;

public class BatchOperationTest {

    private static Logger log = Logger.getLogger(BatchOperationTest.class);

    private static SqlSessionFactory factory;
    private static ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");


    public static void main(String[] args) {
        // factory = (DefaultSqlSessionFactory) ctx.getBean("sqlSessionFactory");
        factory = ctx.getBean(SqlSessionFactory.class);
        SqlSession session = factory.openSession(ExecutorType.BATCH, false);

        UserMapper mapper = session.getMapper(UserMapper.class);

        try {
            long beginTime = System.currentTimeMillis();
            List<User> usersToSave = new ArrayList<User>();
            User userToSave;

            final int COUNT_TO_OPERATE = 30000;
            for (int i = 0; i < COUNT_TO_OPERATE; i++) {
                userToSave = new User();

                userToSave.setName("Lex" + (i + 1));
                userToSave.setLoginName("Lex" + (i + 1));

                usersToSave.add(userToSave);
                mapper.save(userToSave);
            }

            // mapper.batchInsert(usersToSave);

            session.commit();
            session.clearCache();
            long duration = System.currentTimeMillis() - beginTime;
            log.info(usersToSave.size());
            log.info("Time cost on batch insert: " + duration + "ms.");
        } catch (Exception e) {
            log.error("Exception operating DB! Will rollbak!", e);
            session.rollback();
        } finally {
            session.close();
        }
    }
}
