package com.itheima.service.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.dao.impl.AccountDaoImpl;
import com.itheima.service.IAccountService;

/**
 * @Author: Mr.Young
 * @Date: 2020/7/4 11:42
 * @Description: TODO 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {

    IAccountDao accountDao = new AccountDaoImpl();

    public AccountServiceImpl(){
        System.out.println("对象已创建");
    }

    public void saveAccount() {
        accountDao.saveAccount();
    }
}
