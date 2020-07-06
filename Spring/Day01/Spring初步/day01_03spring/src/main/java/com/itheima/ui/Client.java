package com.itheima.ui;

import com.itheima.dao.IAccountDao;
import com.itheima.service.IAccountService;
import com.itheima.service.impl.AccountServiceImpl;
import com.sun.org.apache.bcel.internal.util.ClassPath;
import org.springframework.beans.factory.BeanFactory;
//import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

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
        //根路径resources下直接写就可以
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        ApplicationContext ac = new FileSystemXmlApplicationContext("C:\\Users\\HP\\Desktop\\bean.xml");

        //2.根据id获取bean对象，两种方式都可以，强转或传入字节码
        IAccountService as = (IAccountService)ac.getBean("accountService");
        IAccountDao adao = ac.getBean("accountDao", IAccountDao.class);

        System.out.println(as);
        System.out.println(adao);
        as.saveAccount();

////        --------BeanFactory接口方式-------
//        Resource resource = new ClassPathResource("bean.xml");
//        BeanFactory factory = new XmlBeanFactory(resource);
//        IAccountService as = (IAccountService)factory.getBean("accountService");
//        System.out.println(as);


    }
}
