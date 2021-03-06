package com.itheima.service.impl;

import com.itheima.service.IAccountService;

import java.util.Date;

/**
 * @Author: Mr.Young
 * @Date: 2020/7/4 11:42
 * @Description: TODO 账户的业务层实现类
 */
public class AccountServiceImpl2 implements IAccountService {

    //经常变化的数据，不适用于注入
    //重点在于类型
    private String name;
    private Integer age;
    private Date birthday;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void saveAccount() {
        System.out.println("service中的saveAccount方法执行了--"+ name + "," + age + "," + birthday);
    }

}
