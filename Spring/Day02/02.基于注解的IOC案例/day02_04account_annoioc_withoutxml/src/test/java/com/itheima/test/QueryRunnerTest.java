package com.itheima.test;

import config.SpringConfiguration;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: Mr.Young
 * @Date: 2020/7/11 17:08
 * @Description: 测试 QueryRunner 是否单例
 */
public class QueryRunnerTest {

    @Test
    public void testQueryRunner(){
        //1.获取容器
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);

        //2.获取QueryRunner对象，第二个参数跟具体实现类
        QueryRunner runner = ac.getBean("runner", QueryRunner.class);

        //测试
        QueryRunner runner1 = ac.getBean("runner", QueryRunner.class);
        System.out.println(runner == runner1);
    }
}
