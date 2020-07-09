package com.itheima.dao;

import com.itheima.domain.Account;

import java.util.List;

/**
 * @Author: Mr.Young
 * @Date: 2020/7/9 18:53
 * @Description: 账户持久层接口
 */
public interface IAccountDao {
    /**
     * @功能描述: 查询所有
     * @param: []
     * @return: java.util.List<com.itheima.domain.Account>
     * @date: 2020/7/9 18:44
     */
    List<Account> findAll();

    /**
     * @功能描述:  查询一个
     * @param: [accountId]
     * @return: com.itheima.domain.Account
     * @date: 2020/7/9 18:48
     */
    Account findAccountById(Integer accountId);

    /**
     * @功能描述:  保存
     * @param: [account]
     * @return: void
     * @date: 2020/7/9 18:46
     */
    void saveAccount(Account account);

    /**
     * @功能描述:  更新账户
     * @param: [account]
     * @return: void
     * @date: 2020/7/9 18:47
     */
    void updateAccount(Account account);

    /**
     * @功能描述:  删除账户
     * @param: [accountId]
     * @return: void
     * @date: 2020/7/9 18:48
     */
    void deleteAccount(Integer accountId);
}
