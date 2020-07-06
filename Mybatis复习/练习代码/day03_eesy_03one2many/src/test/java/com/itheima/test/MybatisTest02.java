package com.itheima.test;


import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import com.itheima.domain.AccountUser;
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
public class MybatisTest02 {
    private InputStream in;
    private SqlSession sqlSession;
    private IAccountDao accountDao;

    @Before//用于在测试方法之前执行
    public void init() throws Exception{
        in = Resources.getResourceAsStream("SqlMapConfig.xml");

        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);

        sqlSession = factory.openSession(true);

        accountDao = sqlSession.getMapper(IAccountDao.class);
    }

    @After//用于在测试方法之后执行
    public void destroy() throws Exception{
        //提交事务
//        sqlSession.commit();

        sqlSession.close();
        in.close();
    }

    /**
     * 测试查询所有账户
     */
    @Test
    public void testFindAll(){
        List<Account> accounts = accountDao.findAll();

        for(Account account : accounts){
            System.out.println(account);
        }
    }

    /**
     * 测试查询所有账户，同时包含用户名称和地址
     */
    @Test
    public void testFindAllAccountUser(){
        List<AccountUser> accountUsers = accountDao.findAllAccount();

        for(AccountUser accountUser : accountUsers){
            System.out.println(accountUser);
        }
    }

}
