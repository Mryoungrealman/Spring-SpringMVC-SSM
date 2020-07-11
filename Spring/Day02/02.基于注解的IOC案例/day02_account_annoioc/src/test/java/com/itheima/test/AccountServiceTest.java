package com.itheima.test;

import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import com.itheima.service.impl.AccountServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @Author: Mr.Young
 * @Date: 2020/7/9 22:37
 * @Description: 使用junit单元测试测试配置，@Test是junit包里的；
 */
public class AccountServiceTest {

    @Test
    public void testFindAll(){
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        //2.得到业务层对象
        //这里第二个参数 写的是 接口的字节码
        IAccountService as = ac.getBean("accountService", IAccountService.class);

        //3.执行方法
        List<Account> accounts = as.findAll();
        for (Account account : accounts) {
            System.out.println(account);
        }

    }

    @Test
    public void testFindOne(){
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        //2.得到业务层对象
        //这里第二个参数 写的是 接口的字节码
        IAccountService as = ac.getBean("accountService", IAccountService.class);

        //3.执行方法
        Account account = as.findAccountById(7);
        System.out.println(account);
    }

    @Test
    public void testSave(){
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        //2.得到业务层对象
        //这里第二个参数 写的是 接口的字节码
        IAccountService as = ac.getBean("accountService", IAccountService.class);

        Account account = new Account();
        account.setMoney(9999.9f);
        account.setName("陈芊芊");
        as.saveAccount(account);
    }

    @Test
    public void testUpdate(){
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        //2.得到业务层对象
        //这里第二个参数 写的是 接口的字节码
        IAccountService as = ac.getBean("accountService", IAccountService.class);

        Account account = new Account();
        account.setId(7);
        account.setName("刘强东");
        account.setMoney(10000f);
        as.updateAccount(account);
    }

    @Test
    public void testDelete(){
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        //2.得到业务层对象
        //这里第二个参数 写的是 接口的字节码
        IAccountService as = ac.getBean("accountService", IAccountService.class);

        as.deleteAccount(7);
    }

}
