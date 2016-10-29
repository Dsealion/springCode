#Spring框架学习
记录学习代码，学习笔记




[1]:https://github.com/xxxgitone/springCode/tree/master/src/cn/spring1027/alias
[2]:https://github.com/xxxgitone/springCode/tree/master/src/cn/spring1027/createobject
[3]:https://github.com/xxxgitone/springCode/tree/master/src/cn/spring1027/createobject/when
[4]:https://github.com/xxxgitone/springCode/tree/master/src/cn/spring1027/scope
[5]:https://github.com/xxxgitone/springCode/tree/master/src/cn/spring1027/initdestory
[6]:https://github.com/xxxgitone/springCode/tree/master/spring_di/cn/spring1027/di/xml/constructor
[7]:https://github.com/xxxgitone/springCode/tree/master/spring_di/cn/spring1027/di/xml/set

##1.Spring的一个例子

### 1.1	基本jar包

		在解压目录中找到下面jar文件，拷贝到类路径下 
		--spring的核心类库 在spring文档的dist下 
		dist\spring.jar
		--引入的第三方类库 都spring文档的lib下
		lib\jakarta-commons\commons-logging.jar

###1.2		步骤

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

###2.1		SpringIOC
Spring的控制反转：把对象的创建、初始化、销毁等工作交给spring容器来做。由spring容器控制对象的生命周期。多例模式下不负责销毁

###2.2		别名 	[code][1]
通过这样的配置，可以达到在一个地方命名，在多个地方使用不同的名字的效果。

	<bean id="helloWorld" class="cn.spring1027.alias.HelloWorld"></bean>
	<alias name="helloWorld" alias="wangermazi"/>
	<alias name="helloWorld" alias="liulaosan"/>

###2.3		Spring容器内部对象的创建 [code][2]
####2.3.1	使用类构造器实例化(默认无参数)
	<!--在这个配置文件中spring要用默认的构造函数为HelloWorld创建对象  -->
	<bean id="helloWorld" class="cn.spring1027.createobject.HelloWorld"></bean>
####2.3.2	使用静态工厂方法实例化(简单工厂模式)
配置文件

	<!-- 
	   
	   	采用静态工厂方法创建对象 
	   			factory-method 工厂方法
	   
	   -->
	   <bean id="helloWorld2" class="cn.spring1027.createobject.HelloWorldFactory" factory-method="getInstance"></bean>
	
	
工厂类

	public class HelloWorldFactory {
			
			public static HelloWorld getInstance(){
				return new HelloWorld();
			}
			
		}   
SpringHelper

	public class SpringHelper {
		public static ApplicationContext context;
		public static String path;
		
		@Before
		public void startSpring(){
			context = new ClassPathXmlApplicationContext(path);
		}
	}

客户端(要继承SpringHelper)

	public class CreateObjectTest extends SpringHelper{
		static {
			path="cn/spring1027/createobject/applicationContext.xml";
		}
		
		/**
		 * spring调用的是默认的构造函数来创建对象
		 */
		@Test
		public void test(){
			context.getBean("HelloWorld"); 
		}
		
		@Test
		public void factoryTest(){
			HelloWorld world=(HelloWorld)context.getBean("helloWorld2");
			world.hello();
		}
	}

####2.3.3	初始化bean时机[code][3]
Spring默认在启动时将所有singleton bean提前进行实例化。提前实例化意味着作为初始化的一部分，ApplicationContext会自动创建并配置所有的singleton bean.通常情况下这是件好事。因为这样在配置中有任何错误能立即发现。

* Lazy-init=”true or  false”
* Lazy-init 为false,spring容器将在启动的时候报错（比较好的一种方式）
* Lazy-init 为true,spring容器将在调用该类的时候出错。

####2.3.4	bean的作用域
#####scope属性[code][4]

	<!-- 
	     	在默认情况下，spring创建bean是单例模式
	     	
	     	scope
	     		singleton 默认
	     			单例  属性是共享的
	     			一般情况下把数据放在方法里
	     		prototype
	     			多例   当一个bean是多例模式的情况下，lazy-init为false或者default无效，有true的效果
	      -->
	   <bean id="helloWorld" class="cn.spring1027.scope.HelloWorld" scope="prototype"></bean>

#####指定Bean的初始化方法和销毁方法[code][5]

	<!-- 
	 		init-method 该方法是有spring容器执行的
	 			在构造函数之后执行
	 			在构造函数之后，在调用方法之前要做一些工作，可以在init中做
	 		destroy-method
	 			如果该bean是单例则在spring容器关闭后者销毁的时候执行，
	 			如果该bean是多例，则spring不负责销毁，
	 		说明：要想要spring控制bean的生命周期，必须是单例
	 			如果该bean是多例，该bean中含有资源，关闭资源的操作由程序员完成
	 	 -->
	   <bean id="helloWorld" class="cn.spring1027.initdestory.HelloWorld" init-method="init" destroy-method="destory"></bean>
   
###2.4		总结 spring的IOC

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
		
###2.5		依赖注入
####2.5.1	构造器注入 [code][6]
*  Person类

		public class Person {
			private Long pid;  //包装类型
			
			private String pname;  // String类型
			
			private Student student; //引用类型
			
			public Person(Long pid,String pname){
				this.pid=pid;
				this.pname=pname;
			}
			
			public Person(String pname,Student student){
				this.pname=pname;
				this.student=student;
			}
		
			public Long getPid() {  //只要get方法就行
				return pid;
			}
		
			public String getPname() {
				return pname;
			}
		
			public Student getStudent() {
				return student;
			}
		
		}

*	配置文件

		<bean id="person" class="cn.spring1027.di.xml.constructor.Person">
		   
		   		<!-- 利用构造函数赋值 -->
		   		<!-- 
		   			构造函数的参数
		   				index 	第几个参数	
		   				type	参数的类型
		   				ref		如果类型是引用类型，赋值
		   				value	如果类型是基本类型，赋值
		   				
		   				说明：只能指定一个构造函数
		   		 -->
		   		 <!-- 
		   		 	<constructor-arg index="0" type="java.lang.Long" value="5"></constructor-arg>
		   		<constructor-arg index="1" type="java.lang.String" value="狗蛋"></constructor-arg>
		   		  -->
		   		<constructor-arg index="0" type="java.lang.String" value="妞儿"></constructor-arg>
		   		<constructor-arg index="1" ref="student"></constructor-arg>
		   		
		   		
		   </bean>
		   
		   
		   <bean id="student" class="cn.spring1027.di.xml.constructor.Student"></bean>


####2.5.2	xml注入 [code][7]
*	基本类型（包装类型和string类型）



		<bean id="person" class="cn.spring1027.di.xml.set.Person">
		   		<!-- 
		   		property  代表属性
		   		在spring中基本类型(包装类型和string类型)都可以用value赋值
		   		 -->
		   		<property name="pid" value="5"></property>
		   		<property name="pname" value="网二"></property>
		   		
		</bean>

*	引用类型

		<property name="student" ref="student">
		   	<!-- <ref bean="student"/> -->	
		</property>

*	list集合

		<property name="lists">
			<list>
				<value>list1</value>
				<value>list2</value>
				<ref bean="student"/>
			</list>
		</property>

*	装配set

		<property name="sets">
			<set>
				<value>set1</value>
				<value>set2</value>
				<ref bean="student"/>
			</set>
		</property>

*	装配map

		<property name="map">
			<map>
				<entry key="map1">
					<value>map1</value>
				</entry>
				<entry key="map2">
					<value>map2</value>
				</entry>
				<entry key="map3">
					<ref bean="student"/>
				</entry>
			</map>
		</property>

*	装配properties

		<property name="properties">
			<props>
				<prop key="prop1">
					prop1
				</prop>
			</props>
		</property>


	