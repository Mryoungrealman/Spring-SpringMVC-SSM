package com.itheima.factory;

import com.itheima.service.IAccountService;
import com.itheima.service.impl.AccountServiceImpl;

/**
 * @Author: Mr.Young
 * @Date: 2020/7/6 20:43
 * @Description: 模拟一个工厂类(有些类存在于jar包中，无法通过修改源码来提供构造函数)
 */
public class staticFactory {
    /**
     * @功能描述:
     * @param: []
     * @return: com.itheima.service.IAccountService
     * @date: 2020/7/6 20:46
     */
    public static IAccountService getAccountService(){
        return new AccountServiceImpl();
    }
}
