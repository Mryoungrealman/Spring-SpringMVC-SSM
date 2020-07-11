package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @Author: Mr.Young
 * @Date: 2020/7/11 10:48
 * @Description: 配置类，作用与 bean.xml 相同
 */
//@Configuration
//@ComponentScan({"com.itheima","config"})
@ComponentScan({"com.itheima"})
@Import(JdbcConfig.class)
@PropertySource("classpath:jdbcConfig.properties")
public class SpringConfiguration {


}
