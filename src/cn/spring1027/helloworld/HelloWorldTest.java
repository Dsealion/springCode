package cn.spring1027.helloworld;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
