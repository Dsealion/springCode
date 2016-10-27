package cn.spring1027.createobject;

import org.junit.Test;

import cn.sprin1027.utils.SpringHelper;

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
