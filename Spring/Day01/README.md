# Day 01

## 1. 框架理解-工厂模式

- 重点理解解耦合使用工厂模式的步骤，重点在于两点：使用配置文件、读取配置文件使用反射创建类。
- 理解多例模式和单例模式。使用单例模式更好，但使用单例模式不要添加类成员变量，这样会影响之后使用这个类方法的对象（值存在依赖）。【 **servlet 创建的就是单例对象**】
- 使用单例模式要小心Java的垃圾回收机制，此时可以使用容器来存储对象。
- 以上为一点点总结和理解。

## 2. Spring 初步

> 2020年7月6日

- 基本概念-IOC：

  控制反转，即将创建对象的权利交给框架；

  包括依赖注入和依赖查找；

  作用：解耦合、解依赖；

  自己编写，使用工厂模式；使用框架，使用spring的IOC快捷编写；

- 核心概念图：

  <img src="img\spring-overview.png" style="zoom:50%;" />

- 获取核心容器，使用 ApplicationContext 接口，其三个常用实现类：

  1. ClassPathXmlApplicationContext：加载在类路径下的配置文件，要求配置文件必须在类路径下。不在，无法加载；【与下面一个比较更加常用】
  2. FileSystemXmlApplicationContext：加载磁盘任意路径下的配置文件（必须有访问权限）
  3. AnnotationConfigApplicationContext：用于读取注解创建容器
  
  - 可见，区别仅在于配置文件的位置不同。
  
- 核心容器的两个接口引发的问题：

  1. ApplicationContext：【单例对象适用，实际开发更多使用】

     构建核心容器时，创建对象采用立即加载的方式。即：一读取完配置文件，使用反射的方式立马创建配置的对象。【可使用debug+断点来看出】

  2. BeanFactory： 【多例对象适用】

     构建核心容器时，创建对象采用延迟加载的方式。即：什么时候根据id获取对象，什么时候才真正创建对象。

- spring对bean的管理细节：

  1. 创建bean的三种方式：

     1. ```java
        /*
        使用默认构造函数创建
        在spring的配置文件中使用bean标签，配以id和class属性之后，且没有其他属性和标签时，
        采用的就是默认构造函数创建，此时如果类中没有默认构造函数，则对象无法创建；
        */
        <bean id="accountService" class="com.itheima.service.impl.AccountServiceImpl"></bean>
        ```
        
     2. ```java
        /*
            【有些类存在于jar包中，无法通过修改源码来提供构造函数】的情况；
           使用普通工厂中的方法创建对象，或者称为使用某个类中的方法创建对象，并存入spring容器；
              【可以这样理解，如果构造函数被重写并且有参数，此时就需要借助第三方（工厂类）来将这个构造函数的参数传入，从而完成配置文件，使spring可以通过配置文件得到key-value对，并存入spring容器】
              */
            <bean id="instanceFactory" class="com.itheima.factory.InstanceFactory"></bean>
                  
            <bean id="accountService" factory-bean="instanceFactory" factory-method="getAccountService"></bean>
        ```
     
     3. ```java
        /*
        使用工厂中的静态方法创建对象（使用某个类中的静态方法创建对象，并存入spring容器）
        */
        <bean id="accountService" class="com.itheima.factory.staticFactory" factory-method="getAccountService"></bean>
        ```
     
        4. 心得：此处配置文件意在创建key-value对，形成一种映射，从而存在spring容器中，可以通过后面的getBean(“key”)方法来获得。
     
  2. bean对象的作用范围：
  
     - <bean>标签的scope属性
       - 用于指定bean的作用范围；
       - 取值：
         1. singleton：单例（Default） 【常用】
         2. prototype：多例 【常用】
         3. request：作用于web应用的请求范围
         4. session：作用于web应用的会话范围
         5. global-session：作用于集群环境的（全局）会话范围，当不是集群环境时，等同于session
  
  3. bean对象的生命周期：
  
     1. 单例对象：【与所存放的容器相同】
        - 产生：容器创建时产生
        - 存在：容器在，就在
        - 摧毁：容器销毁，则对象摧毁
     2. 多例对象：
        - 产生：使用对象时，spring创建
        - 存在：对象使用过程中
        - 摧毁：当对象长时间不用，且没有别的对象引用时，由Java垃圾回收机制回收

***

## 3. 依赖注入

1. spring中的依赖注入（Dependency injection）：

   - IOC作用：降低耦合（依赖关系）；

     依赖关系的管理：交给spring来维护。即当前类需要用到其他类的对象时，由spring提供，只需在spring中说明；

     依赖关系的维护称为 依赖注入；

   - 注入数据，三种：

     1. 基本类型 和 string

     2. 其他 bean 类型 （在配置文件中 或 注解中配置过的bean）

     3. 复杂类型（集合类型）：

        - 用于List结构集合注入的标签：

          list / array / set

        - 用于给map结构集合注入的标签：

          map / props

        - 结构相同，标签可以互换，即：只有值 与 key-value对 ；

        - ```java
              <bean id="accountService3" class="com.itheima.service.impl.AccountServiceImpl3">
                  <property name="myStrs">
                      <array>
                          <value>AAA</value>
                          <value>BBB</value>
                          <value>CCC</value>
                      </array>
                  </property>
          
                  <property name="myList">
                      <list>
                          <value>AAA</value>
                          <value>BBB</value>
                          <value>CCC</value>
                      </list>
                  </property>
          
                  <property name="mySet">
                      <set>
                          <value>AAA</value>
                          <value>BBB</value>
                          <value>CCC</value>
                      </set>
                  </property>
          
                  <property name="myMap">
                      <map>
                          <entry key="testA" value="AAA"></entry>
                          <entry key="testB" value="BBB"></entry>
                          <entry key="testC" value="CCC"></entry>
                      </map>
                  </property>
          
                  <property name="myProps">
                      <props>
                          <prop key="testC">ccc</prop>
                          <prop key="testD">ddd</prop>
                      </props>
                  </property>
              </bean>
          ```

   - 注入方式：

     1. 使用构造函数；

        - ```java
          /*
          使用 constructor-arg 标签，出现在bean标签内部；
          属性:
          	type：指定要注入的数据类型，也是构造函数中参数的类型；
          	index：给构造函数中 指定索引位置 的参数赋值，索引位置从0开始；
          	name：给构造函数中指定名称的参数赋值；	【常用】
          	【以上三个，用于指定给哪个参数赋值】
          	
          	value：用于提供基本类型和String类型的数据；
          	ref：用于指定其他的bean类型数据；即在在spring的IOC核心容器中出现过的bean对象；
          */
          
              <bean id="accountService" class="com.itheima.service.impl.AccountServiceImpl">
                  <constructor-arg name="name" value="哈个哈"></constructor-arg>
                  <constructor-arg name= "age" value="18"></constructor-arg>
                  <constructor-arg name= "birthday" ref="now"></constructor-arg>
              </bean>
          
              <bean id="now" class="java.util.Date"></bean>
          ```

        - 优势：（有构造函数，更改了默认构造函数）获取bean对象时，注入数据是必须的操作，否则对象无法创建成功。

        - 弊端：改变了bean对象的实例化方式。创建对象时，如果用不到这些数据也必须提供。

     2. 使用set方法；  **【比1更常用】**

        - ```java
          /*
          使用 property 标签，出现在bean标签内部
          属性：
          	name：用于指定注入时所调用的 set 方法名称；
          	value：用于提供基本类型和String类型的数据；
          	ref：用于指定其他的bean类型数据；即在在spring的IOC核心容器中出现过的bean对象；
          */
          
              <bean id="now" class="java.util.Date"></bean>
          
              <bean id="accountService2" class="com.itheima.service.impl.AccountServiceImpl2">
                  <property name="name" value="哈喽"></property>
                  <property name="age" value="22"></property>
                  <property name="birthday" ref="now"></property>
              </bean>
          ```

        - 优势：创建对象时，没有明确限制，可以直接使用默认构造函数；

        - 弊端：若要求某个成员必须有值，set方法无法保证一定注入。

     3. 使用注解提供；