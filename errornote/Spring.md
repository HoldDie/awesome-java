---
typora-root-url: pic
---



### SpringMVC

#### DispatcherServlet

- 文件上传解析，如果请求类型是multipart，将通过multipartResolver记性文件上传解析。
- 通过HandlerMapping，将请求映射到处理器（返回一个HandlerExecution，它包括一个处理器、多个HandlerInterceptor拦截器）
- 通过HandlerAdapter支持多种类型的处理器
- 通过ViewResolver解析逻辑视图名到指定视图实现
- 本地化解析
- 渲染具体的视图
- 如果执行过程中遇到异常将交给HandlerExceptionResolver来解析



### Spring 事务

- 总接口：PlatformTransactionManager
  - TransactionDefinition：事务属性定义
  - TransactionStatus：代表当前的事务，可以提交，回滚
  - PlatformTransactionManager：核心接口的子类



### Spring 依赖注入

- Spring 的 IOC 容器能够帮助我们自动 new 对象，对象交给Spring管理，无需手动new对象，转让控制权。
- Spring 使用 BeanFactory 来实例化、配置和管理对象，但是它只是一个接口，里面有一个 getBean（）方法。
- 我们一般不直接使用BeanFactory，而是使用它的实现类ApplicationContext，这个类会自动解析我们配置的`applicationContext.xml`



### Spring

#### 七大模块：

1. Spring Core： Core封装包是框架的最基础部分，提供IOC和依赖注入特性。这里的基础概念是BeanFactory，它提供对Factory模式的经典实现来消除对程序性单例模式的需要，并真正地允许你从程序逻辑中分离出依赖关系和配置。

2.Spring Context: 构建于[Core](http://www.mianwww.com/html/2014/03/19750.html#beans-introduction)封装包基础上的 [Context](http://blog.chinaunix.net/u/9295/ch03s08.html)封装包，提供了一种框架式的对象访问方法，有些象JNDI注册器。Context封装包的特性得自于Beans封装包，并添加了对国际化（I18N）的支持（例如资源绑定），事件传播，资源装载的方式和Context的透明创建，比如说通过Servlet容器。

3．Spring DAO:  [DAO](http://www.mianwww.com/html/2014/03/19750.html#dao-introduction) (Data Access Object)提供了JDBC的抽象层，它可消除冗长的JDBC编码和解析数据库厂商特有的错误代码。 并且，JDBC封装包还提供了一种比编程性更好的声明性事务管理方法，不仅仅是实现了特定接口，而且对所有的POJOs（plain old Java objects）都适用。

4.Spring ORM: [ORM](http://www.mianwww.com/html/2014/03/19750.html#orm-introduction) 封装包提供了常用的“对象/关系”映射APIs的集成层。 其中包括[JPA](http://blog.chinaunix.net/u/9295/ch12s07.html)、[JDO](http://blog.chinaunix.net/u/9295/ch12s03.html)、[Hibernate](http://blog.chinaunix.net/u/9295/ch12s02.html) 和 [iBatis](http://blog.chinaunix.net/u/9295/ch12s06.html) 。利用ORM封装包，可以混合使用所有Spring提供的特性进行“对象/关系”映射，如前边提到的简单声明性事务管理。

5.Spring AOP: Spring的 [AOP](http://www.mianwww.com/html/2014/03/19750.html#aop-introduction) 封装包提供了符合AOP Alliance规范的面向方面的编程实现，让你可以定义，例如方法拦截器（method-interceptors）和切点（pointcuts），从逻辑上讲，从而减弱代码的功能耦合，清晰的被分离开。而且，利用source-level的元数据功能，还可以将各种行为信息合并到你的代码中。

6.Spring Web: Spring中的 Web 包提供了基础的针对Web开发的集成特性，例如多方文件上传，利用Servlet listeners进行IOC容器初始化和针对Web的ApplicationContext。当与WebWork或Struts一起使用Spring时，这个包使Spring可与其他框架结合。

7.Spring Web MVC: Spring中的[MVC](http://www.mianwww.com/html/2014/03/19750.html#mvc-introduction)封装包提供了Web应用的Model-View-Controller（MVC）实现。Spring的MVC框架并不是仅仅提供一种传统的实现，它提供了一种清晰的分离模型，在领域模型代码和Web Form之间。并且，还可以借助Spring框架的其他特性。

- 在Spring中，在没有设置值注入的情况下，才会根据配置文件中的构造注入，一旦有设值注入，则构造注入失效。
- Spring 框架的核心思想：依赖注入、控制反转、面向切面

### 散点

- SpringMVC 和 Struts2 的区别：
  - 机制：`SpringMVC` 的入口是 `Servlet`，而 `Struts2` 是`filter`
  - 性能：Spring 比 struts2 快，SpringMVC 基于方法的设计，Struts2 基于类的设计。
  - 参数传递：Strusts 在接受参数的时候，可以用属性来接受参数，参数是可以让多个方法共享的
  - 设计思想，Struts2 更加符合 OOP 的编程思想，Spring 在Servlet上扩展
  - Intercepter实现机制：Struts 有自己的 interceptor 机制，SpringMVC 用的是独立的AOP方式。