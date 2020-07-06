package com.itheima.test;


import com.itheima.dao.IUserDao;
import com.itheima.domain.QueryVo;
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
public class MybatisTest {
    private InputStream in;
    private SqlSession sqlSession;
    private IUserDao userDao;

    @Before//用于在测试方法之前执行
    public void init() throws Exception{
        in = Resources.getResourceAsStream("SqlMapConfig.xml");

        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);

        sqlSession = factory.openSession();

        userDao = sqlSession.getMapper(IUserDao.class);
    }

    @After//用于在测试方法之后执行
    public void destroy() throws Exception{
        //提交事务
        sqlSession.commit();

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
        }
    }

    /**
     * 测试保存操作
     */
    @Test
    public void testSave(){
        User user = new User();
        user.setUsername("哈喽");
        user.setAddress("中国北京");
        user.setSex("男");
        user.setBirthday(new Date());

        System.out.println("保存操作之前"+user);
        userDao.saveUser(user);
        System.out.println("保存操作之后"+user);
    }

    /**
     * 测试更新操作
     */
    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(51);
        user.setUsername("mybatis updateuser");
        user.setAddress("中国南京");
        user.setSex("女");
        user.setBirthday(new Date());

        userDao.updateUser(user);
    }

    /**
     * 测试删除操作
     */
    @Test
    public void testDelete(){
        userDao.deleteUser(46);
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
     * 测试模糊查询操作
     */
    @Test
    public void testFindByName(){
        //测试查询一个方法
        List<User> users = userDao.findByName("%王%");
//        List<User> users = userDao.findByName("王");
        for(User user : users){
            System.out.println(user);
        }
    }

    /**
     * 测试查询总用户数操作
     */
    @Test
    public void testFindTotal(){
        //测试查询一个方法
        int count = userDao.findTotal();
        System.out.println(count);
    }

    /**
     * 测试使用QueryVo作为查询条件
     */
    @Test
    public void testFindByVo(){
        QueryVo vo = new QueryVo();
        User user = new User();
        user.setUsername("%王%");
        vo.setUser(user);
        //测试查询一个方法
        List<User> users = userDao.findUserByVo(vo);
//        List<User> users = userDao.findByName("王");
        for(User u : users){
            System.out.println(u);
        }
    }

}
