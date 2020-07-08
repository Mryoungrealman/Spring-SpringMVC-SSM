package com.itheima.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @Author: Mr.Young
 * @Date: 2020/7/6 09:40
 * @Description: TODO 一个创建bean对象的工厂，用来创建service和dao对象
 *
 * 解耦需要：
 * 1.配置文件：唯一标识=全限定类名
 * 2.读取配置文件，反射创建对象
 *
 * 配置文件可以是 xml 或 properties
 */
public class BeanFactory {
    //定义一个Properties对象；
    private static Properties props;

    //由于直接使用getBean()【已注释】中Class.forName(beanPath).newInstance()创建的是多例对象，
    //目的是创建单例对象，但直接创建单例对象会由于Java垃圾回收机制导致不可复用，
    //所以使用容器来保存单例对象，由于有配置文件，所以此处使用map容器来保存。
    //定义一个map，用于存放我们要创建的对象，称之为容器
    private static Map<String, Object> beans;


    //使用静态代码块为Properties对象赋值，静态代码只运行一次
    static {
        try {
            //实例化对象
            props = new Properties();
            //获取properties文件的流对象
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            props.load(in);
            //实例化容器
            beans = new HashMap<String, Object>();
            //取出配置文件中所有的key
            Enumeration keys =  props.keys();
            //遍历枚举
            while (keys.hasMoreElements()){
                //取出每个key
                String key = keys.nextElement().toString();
                //根据key获取value
                String beanPath = props.getProperty(key);
                //反射创建对象
                Object value = Class.forName(beanPath).newInstance();
                //把key和value存入容器中
                beans.put(key, value);
            }

        } catch (IOException | ClassNotFoundException e) {
            throw new ExceptionInInitializerError("初始化properties失败！");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    /**
     * @功能描述:  根据bean的名称获取对象
     * @param: [beanName]
     * @return: java.lang.Object
     * @date: 2020/7/6 10:47
     */
    public static Object getBean(String beanName){
        return beans.get(beanName);
    }


    /**
     * @功能描述:  根据bean名称获取bean对象
     * @param: [beanName]
     * @return: java.lang.Object
     * @date: 2020/7/6 10:07


    public static Object getBean(String beanName){
        Object bean = null;
        try {
            String beanPath = props.getProperty(beanName);
//            System.out.println(beanPath);
            bean = Class.forName(beanPath).newInstance();   //使用反射创建对象
                                                            //newInstance()标识每次都会调用默认构造函数创建对象
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return bean;
    }
     */

}
