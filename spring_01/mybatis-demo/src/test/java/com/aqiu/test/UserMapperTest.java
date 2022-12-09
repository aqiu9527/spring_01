package com.aqiu.test;

import com.aqiu.mapper.UserMapper;
import com.aqiu.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Aqiu
 * @create 2022-11-05 19:17
 */
public class UserMapperTest {


    @Test
    public void selectById() throws IOException {

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //手动提交事务
        //SqlSession sqlSession = sqlSessionFactory.openSession();
        //自动提交,无需sqlSession.commit();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.selectById(3);

        System.out.println(user);

        sqlSession.close();

    }


    @Test
    public void login() throws IOException {
        String userName = "张三";
        String password = "123";

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //手动提交事务
        //SqlSession sqlSession = sqlSessionFactory.openSession();
        //自动提交,无需sqlSession.commit();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.login(userName,password);

        System.out.println(user);

        sqlSession.close();

    }
}
