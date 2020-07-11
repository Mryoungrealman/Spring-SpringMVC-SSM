# 1. 基于xml的IOC案例

> ***
>
> 2020-7-9
>
> ***
>
> - 本节重点在于实践，其中最重要部分在于案例中 **bean.xml** 文件的配置，以及其中的注释与笔记；
> - 在 **bean.xml** 文件的配置中，采用嵌套的思想，层层配置，需要什么配置什么，以这样的思路配置，可以既不多也不少的配置好文件；
>
> ***



# 2. 基于注解的IOC案例

> ***
>
> 2020-7-10 ~ 11
>
> ***
>
> 1. account_annoioc 主要将service 和 dao 的xml配置改为注解，仍需进一步更改；
> 2. spring 中的新注解；
> 3. spring 整合 junit 分析；
>
> ***



> ***
>
> Tips：
>
> 1. 在编写实体类时，其需要实现 序列化接口（implements Serializable）
> 2. 在 **XML** 和 **注解** 的选择上：
>    - 如果是配置已写好（已有）的 jar 包，可以采用 XML 方式；
>    - 如果是配置自己写的类，可以采用 注解 方式；
>    - 混合使用，更加简洁、高效；
>
> ***

## 1. spring中的新注解【2.】

1. @Configuration

   - 作用：指定当前类是一个配置类；
   - **<u>细节</u>**：
     1. 当配置类作为 AnnotationConfigApplicationContext 对象创建的参数时，该注解可以不写；
     2. @Configuration 是用于指定配置类的；
        1. 当上述的 AnnotationConfigApplicationContext 创建时没有传入该配置类时，可以通过传入其他类的字节码，同时该类也在头部加有包扫描注解，并在属性中添加配置类的包，以扫描到配置类，此时在配置类的头部必须加有 @Configuration 注解，以被 spring 识别为配置类；
        2. 当上述 AnnotationConfigApplicationContext 创建时传入该配置类时，不用加 @Configuration 注解；
        3. 不论在何处，都应该在spring能找到的范围内加上 @ComponentScan 包扫描注解，以创建 bean 对象；

2. @ComponentScan

   - 作用：指定 spring 在创建容器时要扫描的包；

   - 属性：

     - value	与 basePackges 的作用相同，都是用于指定 spring 在创建容器时要扫描的包；

   - 写法：

     ```java
     @ComponentScan(basePackages = {"com.itheima"})
     
     //只有一个包时
     @ComponentScan("com.itheima")
     ```

     等同于：

     ```java
     <context:component-scan base-package="com.itheima"></context:component-scan>
     ```

3. @Bean

   - 作用：用于把当前方法的返回值作为 bean 对象，存入 spring 的 ioc 容器中；

   - 属性：

     - name	指定 bean 的 id；当不写时，默认值为当前方法名称；

   - 写法：

     ```java
         @Bean(name = "runner")
         @Bean(name = "dataSource")
     ```

   - <u>**细节**</u>：

     当使用注解配置方法时，若方法有参数，spring 框架会去容器中<u>寻找</u>有没有可用的 bean 对象，查找方式与 @AutoWired 一样；如果没有找到会报错；

4. @Import

   - 作用：用于导入其他配置类

   - 属性：

     - value	用于指定其他配置类的字节码；

     - 含 @Import 注解的都是父配置类，导入的都是子配置类 【该方式**更好**】；

       在 AnnotationConfigApplicationContext 通过传入参数传入的配置类是 **并列** 的关系；

   - 写法：

     ```java
     @Import(JdbcConfig.class)
     ```

5. @PropertySource

   - 作用：用于指定 .properties 文件的位置；

   - 属性：

     1. value	指定文件的名称和路径
     2. 关键字：classpath  表示类路径下，有包就写包，没包在在根路径下直接写文件名

   - 写法：

     ```java
     @PropertySource("classpath:jdbcConfig.properties")
     ```

## 2. spring 整合 junit 【3.】

> ***
>
> 1. 应用程序的入口
>    	main方法
> 2. junit单元测试中，没有main方法也能执行
>    	junit集成了一个main方法
>    	该方法就会判断当前测试类中哪些方法有 @Test注解
>    	junit就让有Test注解的方法执行
> 3. junit不会管我们是否采用spring框架
>    	在执行测试方法时，junit根本不知道我们是不是使用了spring框架
>    	所以也就不会为我们读取配置文件/配置类创建spring核心容器
> 4. 由以上三点可知
>    	当测试方法执行时，没有Ioc容器，就算写了Autowired注解，也无法实现注入
>
> written by Teacher.
>
> ***
>
> **spring 整合 junit 配置**：
>
> 1.  导入spring 整合 junit 的 jar包（坐标）；
>
>    ```java
>            <dependency>
>                <groupId>org.springframework</groupId>
>                <artifactId>spring-test</artifactId>
>                <version>5.0.2.RELEASE</version>
>            </dependency>
>    ```
>
> 2. 使用 junit 提供的注解，将原 main 方法替换为 spring 提供的 main 方法；
>
>    - @Runwith
>
> 3. 告知 spring 的运行器，ioc 的创建是基于 XML 还是 注解，并说明位置；
>
>    - @ContextConfiguration
>
>      属性：
>
>      1. locations	指定 XML 文件的位置，加 classpath 关键字，表示在类路径下；
>      2. classes   指定注解（配置）类所在的位置；
>
> 4. 写法：
>
>    ```java
>    @RunWith(SpringJUnit4ClassRunner.class)
>    @ContextConfiguration(classes = SpringConfiguration.class)
>    ```
>
>    
>
> - **细节**：
>
>   当使用 spring 5.x 版本时，要求 junit 版本必须是 4.12 及以上；
>
> ***

