package com.itheima.dao;

import com.itheima.domain.Account;
import com.itheima.domain.AccountUser;

import java.util.List;

/**
 * @Auther: HP
 * @Date: 2020/6/30 16:38
 * @Description:
 */
public interface IAccountDao {
    /**
     * 查询所有用户，同时还要获取当前用户的所属用户信息
     * @return
     */
    List<Account> findAll();

    /**
     * 查询所有信息，并且带有用户名称和地址信息
     * @return
     */
    List<AccountUser> findAllAccount();
}
