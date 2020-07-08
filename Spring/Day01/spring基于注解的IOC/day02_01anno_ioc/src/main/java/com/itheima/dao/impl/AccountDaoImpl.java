package com.itheima.dao.impl;

import com.itheima.dao.IAccountDao;
import org.springframework.stereotype.Repository;


/**
 * @Author: Mr.Young
 * @Date: 2020/7/4 11:47
 * @Description: TODO 账户持久层实现类
 */
@Repository("accountDao1")
public class AccountDaoImpl implements IAccountDao {
    @Override
    public void saveAccount() {
        System.out.println("保存了账户 1");
    }
}
