package com.itheima.service.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.factory.BeanFactory;
import com.itheima.service.IAccountService;

/**
 * @Author: Mr.Young
 * @Date: 2020/7/4 11:42
 * @Description: TODO 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {

//    IAccountDao accountDao = new AccountDaoImpl();
    IAccountDao accountDao = (IAccountDao) BeanFactory.getBean("accountDao");

//    private int i = 1;

    public void saveAccount() {
        int i = 1;
        accountDao.saveAccount();
        System.out.println(i);
        i++;
    }
}
