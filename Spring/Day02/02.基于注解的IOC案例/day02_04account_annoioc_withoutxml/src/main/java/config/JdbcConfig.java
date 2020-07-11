package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;

/**
 * @Author: Mr.Young
 * @Date: 2020/7/11 17:27
 * @Description:
 */
//@Configuration
//@ComponentScan({"com.itheima","config"})
public class JdbcConfig {

    @Value("${jdbc.driver}")
    private String driver;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    /**
     * @功能描述:  创建 QueryRunner 对象
     * @param: [dataSource]
     * @return: org.apache.commons.dbutils.QueryRunner
     * @date: 2020/7/11 11:01
     */
    @Bean(name = "runner")
    @Scope("prototype") //指定多例，此处需要多例
    public QueryRunner createQueryRunner(DataSource dataSource){
        return new QueryRunner(dataSource);
    }

    /**
     * @功能描述: 创建数据源对象
     * @param: []
     * @return: javax.sql.DataSource
     * @date: 2020/7/11 11:08
     */
    @Bean(name = "dataSource")
    public DataSource createDataSource(){
        try {
            ComboPooledDataSource ds = new ComboPooledDataSource();
            ds.setDriverClass(driver);
            ds.setJdbcUrl(url);
            ds.setUser(username);
            ds.setPassword(password);
            return ds;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
