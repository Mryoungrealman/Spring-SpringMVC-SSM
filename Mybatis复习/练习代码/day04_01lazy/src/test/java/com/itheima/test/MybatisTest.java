package com.itheima.test;


import com.itheima.dao.IUserDao;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Mybatis的CRUD操作
 */
public class MybatisTest {
    private InputStream in;
    private SqlSession sqlSession;
    private IUserDao userDao;

    @Before//用于在测试方法之前执行
    public void init() throws Exception{
        in = Resources.getResourceAsStream("SqlMapConfig.xml");

        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);

        sqlSession = factory.openSession(true);

        userDao = sqlSession.getMapper(IUserDao.class);
    }

    @After//用于在测试方法之后执行
    public void destroy() throws Exception{
        //提交事务
//        sqlSession.commit();

        sqlSession.close();
        in.close();
    }

    /**
     * 测试查询所有
     */
    @Test
    public void testFindAll(){
        List<User> users = userDao.findAll();
        for(User user : users){
            System.out.println(user);
            System.out.println(user.getAccounts());
        }
    }


    /**
     * 测试查询操作
     */
    @Test
    public void testFindOne(){
        //测试查询一个方法
        User user = userDao.findById(45);
        System.out.println(user);
    }

    /**
     * 插入用户
     */
    @Test
    public void testInsert(){
        User u = new User();
        u.setUsername("韩少君");
        u.setSex("男");
        u.setBirthday(new Date());
        u.setAddress("玄虎城");

        userDao.insertUser(u);
    }
}
