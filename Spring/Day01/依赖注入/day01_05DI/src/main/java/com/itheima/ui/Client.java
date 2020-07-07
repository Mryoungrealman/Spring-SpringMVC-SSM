package com.itheima.ui;

import com.itheima.service.IAccountService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//import org.springframework.beans.factory.xml.XmlBeanFactory;

/**
 * @Author: Mr.Young
 * @Date: 2020/7/6 09:30
 * @Description: TODO 模拟一个表现层，用于调用业务层
 */
public class Client {
    /**
     * @功能描述:  获取spring的IOC核心容器，并根据id获取对象
     * @param: [args]
     * @return: void
     * @date: 2020/7/6 16:56
     */
    public static void main(String[] args) {
        //1.获取核心容器对象
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        //2.根据id获取bean对象，两种方式都可以，强转或传入字节码
//        IAccountService as = (IAccountService)ac.getBean("accountService");
//        as.saveAccount();

//        IAccountService as = (IAccountService)ac.getBean("accountService2");
//        as.saveAccount();

        IAccountService as = (IAccountService)ac.getBean("accountService3");
        as.saveAccount();

    }
}
