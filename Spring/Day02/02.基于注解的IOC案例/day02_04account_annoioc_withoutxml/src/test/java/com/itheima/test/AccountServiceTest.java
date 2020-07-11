package com.itheima.test;

import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import config.JdbcConfig;
import config.SpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @Author: Mr.Young
 * @Date: 2020/7/9 22:37
 * @Description: 使用junit单元测试测试配置，@Test是junit包里的；
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountServiceTest {

    @Autowired
    private IAccountService as = null;

    @Test
    public void testFindAll(){
//        //1.获取容器
////        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
//
//
//        //2.得到业务层对象
//        //这里第二个参数 写的是 接口的字节码
//        IAccountService as = ac.getBean("accountService", IAccountService.class);

        //3.执行业务层对象方法
        List<Account> accounts = as.findAll();
        for (Account account : accounts) {
            System.out.println(account);
        }

    }

    @Test
    public void testFindOne(){
        //1.获取容器
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);

        //2.得到业务层对象
        //这里第二个参数 写的是 接口的字节码
        IAccountService as = ac.getBean("accountService", IAccountService.class);

        //3.执行方法
        Account account = as.findAccountById(9);
        System.out.println(account);
    }

    @Test
    public void testSave(){
        //1.获取容器
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);

        //2.得到业务层对象
        //这里第二个参数 写的是 接口的字节码
        IAccountService as = ac.getBean("accountService", IAccountService.class);

        Account account = new Account();
        account.setMoney(123f);
        account.setName("赵敏");
        as.saveAccount(account);
    }

    @Test
    public void testUpdate(){
        //1.获取容器
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);

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
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);

        //2.得到业务层对象
        //这里第二个参数 写的是 接口的字节码
        IAccountService as = ac.getBean("accountService", IAccountService.class);

        as.deleteAccount(7);
    }

    /**
     * @功能描述:  测试 新创建 ApplicationContext 对象，是否会新建 bean；结果是会新建 bean；
     * @param: []
     * @return: void
     * @date: 2020/7/11 21:15
     */
    @Test
    public void testTwoSimilar(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        IAccountService as = ac.getBean("accountService", IAccountService.class);

        ApplicationContext ac1 = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        IAccountService as1 = ac1.getBean("accountService", IAccountService.class);

        System.out.println(as);
        System.out.println(as1);
        System.out.println(as == as1);
    }

}
