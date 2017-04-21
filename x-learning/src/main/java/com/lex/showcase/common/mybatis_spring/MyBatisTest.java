package com.lex.showcase.common.mybatis_spring;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * myBatis��ݿ����Ӳ���
 * 
 * @author db2admin
 * 
 */
public class MyBatisTest {

	private static Logger log = LoggerFactory.getLogger(MyBatisTest.class);
	
	private static ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");


	public static void main(String[] args) {
        // DefaultSqlSessionFactory factory = (DefaultSqlSessionFactory) ctx.getBean("sqlSessionFactory"); //
        // getSessionFactory().openSession();
        // SqlSession session = factory.openSession();
        //
        // UserMapper userMapper = session.getMapper(UserMapper.class);
        // User user = userMapper.get(1);
        // log.info(user);
        //
        // session.close();

//		GroupMapper groupMapper = sqlSession.getMapper(GroupMapper.class);
//		Group group = groupMapper.get(1);
        // log.info(group);

        // UserMapper userMapper = (UserMapper) ctx.getBean("userMapper");
        UserMapper userMapper = ctx.getBean(UserMapper.class);
        User user = userMapper.get(1);
        log.info("user: {}", user);

        GroupMapper groupMapper = ctx.getBean(GroupMapper.class);
        Group group = groupMapper.get(-1);
        log.info("group: {}", group);
	}

}
