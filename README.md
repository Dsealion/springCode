#Spring框架学习
记录学习代码

##1.Spring的一个例子

* 基本jar包

		在解压目录中找到下面jar文件，拷贝到类路径下 
		--spring的核心类库 在spring文档的dist下 
		dist\spring.jar
		--引入的第三方类库 都spring文档的lib下
		lib\jakarta-commons\commons-logging.jar

* 步骤

		spring容器
		1、写一个java类
		      HelloWorld
		2、写一个spring的配置文件
		     把HelloWorld这个类放入到spring容器中
		3、启动spring容器
		4、从spring容器中把helloWorld取出来
		5、对象.方法
		说明：spring容器负责创建对象，程序员不用创建对象

	* 创建一个类

			public class HelloWorld {
				public void hello(){
					System.out.println("hello world");
				}
			}

	* 配置文件，一般在当前包下applicationContext.xml

			<?xml version="1.0" encoding="UTF-8"?>
			<beans xmlns="http://www.springframework.org/schema/beans"
			       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
			       xsi:schemaLocation="http://www.springframework.org/schema/beans
			           http://www.springframework.org/schema/beans/spring-beans-2.5.xsd">
			   <!-- 
			   		beans
			   		   把一个类放入到spring容器中，该类就称为bean
			    -->
			    <!-- 
			    	一个bean就代表一个类
			    	  id就是唯一标识符
			     -->
			   <bean id="helloWorld" class="cn.spring1027.helloworld.HelloWorld"></bean>
			</beans>

	* 客户端

			public class HelloWorldTest {
				@Test
				public void test(){
					/**
					 *  1.启动spring容器
					 *  2.从spring容器中把helloworld拿出来
					 *  3.对象.方法
					 */
					
					//启动spring容器
					ApplicationContext context=new ClassPathXmlApplicationContext("cn/spring1027/helloworld/applicationContext.xml");
					
					HelloWorld helloWorld=(HelloWorld)context.getBean("helloWorld");//spring容器中bean对应的id
					helloWorld.hello();
				}
			}

##2.Spring基本功能详解

 > **SpringIOC**：

Spring的控制反转：把对象的创建、初始化、销毁等工作交给spring容器来做。由spring容器控制对象的生命周期。多例模式下不负责销毁

> **别名**:




> **总结 spring的IOC**：

  IOC:spring容器控制对象的生命周期：前提条件：在spring容器中的bean必须是单例的

*  创建

	* 方式

			利用默认的构造函数，如果没有默认的构造函数，会报错
			利用静态工厂方法
			利用实例工厂方法

	* 时机

			* lazy-init为“default/false”当启动spring容器的时候创建bean
				但是如果该bean是prototype时，特殊。这种情况无效
				优点：在spring容器启动的时候，就会发现错误
				缺点：有可能会造成一些数据长时间驻留在内存中

			* lazy-init为"true"当context.getBean时创建
				bean为多例时，必须用这种方案创建对象
				缺点：不能及时发现错误
				优点：数据会在需要的时候加载
	* 初始化


			由spring容器调用init方法
			在构造函数之后执行

	* 销毁

			如果是单例，则必须返回ClassPathXmlApplicationContext该容器，才能执行销毁工作
			如果是多例，容器不负责销毁
		



	