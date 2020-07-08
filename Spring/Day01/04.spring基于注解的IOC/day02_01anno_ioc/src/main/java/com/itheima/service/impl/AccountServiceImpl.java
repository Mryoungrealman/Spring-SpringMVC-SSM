package com.itheima.service.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.dao.impl.AccountDaoImpl;
import com.itheima.dao.impl.AccountDaoImpl2;
import com.itheima.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * @Author: Mr.Young
 * @Date: 2020/7/4 11:42
 * @Description: 账户的业务层实现类
 *
 * XML配置：
 * <bean id="accountService" class="com.itheima.service.impl.AccountServiceImpl"></bean>
 *
 */
@Service(value = "accountService")
//@Scope(value = "prototype")
public class AccountServiceImpl implements IAccountService {

//    @Autowired
//    @Qualifier(value = "accountDao1")
    @Resource(name = "accountDao1")
    private IAccountDao accountDao;

//    @Autowired
//    private AccountDaoImpl dao;

    @PostConstruct
    public void init(){
        System.out.println("call init method...");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("call destroy method...");
    }

    public AccountServiceImpl(){
        System.out.println("对象已创建");
    }

    public void saveAccount() {
        accountDao.saveAccount();
    }

    /**
     * @功能描述: 直接使用impl对象，来验证注解的匹配办法，即除了匹配接口类也会匹配实现类
     * @param: []
     * @return: void
     * @date: 2020/7/8 21:09

    public void saveAccount2(){
        dao.saveAccount();
    }
    */

}
