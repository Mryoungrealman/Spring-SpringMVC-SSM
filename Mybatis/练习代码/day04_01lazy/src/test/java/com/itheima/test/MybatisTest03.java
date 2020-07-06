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
import java.util.Date;
import java.util.List;

/**
 * Mybatis的CRUD操作
 */
public class MybatisTest03 {
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
     * 测试查询所有用户及其账户信息
     */
    @Test
    public void testFindAll(){
        List<User> users = userDao.findAll();
        for (User user : users){
            System.out.println("------每个用户的信息------");
            System.out.println(user);
            System.out.println(user.getAccounts());
        }
    }

}
