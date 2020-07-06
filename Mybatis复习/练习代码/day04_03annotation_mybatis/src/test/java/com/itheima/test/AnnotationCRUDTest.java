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
 * @Auther: HP
 * @Date: 2020/7/2 14:53
 * @Description:
 */
public class AnnotationCRUDTest {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IUserDao userDao;

    @Before
    public void init() throws Exception{
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();
        userDao = session.getMapper(IUserDao.class);
    }

    @After
    public void destroy() throws Exception{
        session.commit();
        session.close();
        in.close();
    }

    @Test
    public void testSaveUser(){
        User user = new User();
        user.setUsername("mybatis annotation");
        user.setAddress("长治市潞州区");
        userDao.saveUser(user);
    }

    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(58);
        user.setUsername("mybatis annotation update");
        user.setAddress("长治市屯留区");
        user.setSex("女");
        user.setBirthday(new Date());

        userDao.updateUser(user);
    }

    @Test
    public void testDelete(){
        userDao.deleteUser(52);
    }

    @Test
    public void testFindUserById(){
        User user = userDao.findById(56);
        System.out.println(user);
    }

    @Test
    public void testFindUserByName(){
        List<User> users = userDao.findUserByName("%mybatis%");
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindTotal(){
        int res = userDao.findTotal();
        System.out.println(res);
    }
}
