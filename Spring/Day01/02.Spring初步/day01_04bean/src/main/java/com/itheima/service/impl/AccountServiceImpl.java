package com.itheima.service.impl;

import com.itheima.service.IAccountService;

/**
 * @Author: Mr.Young
 * @Date: 2020/7/4 11:42
 * @Description: TODO 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {


    public AccountServiceImpl(){
        System.out.println("对象已创建");
    }

    public void saveAccount() {
        System.out.println("service中的saveAccount方法执行了！");
    }

    public void init(){
        System.out.println("对象初始化了");
    }

    public void destroy(){
        System.out.println("对象销毁了");
    }
}
