package cn.spring1027.createobject.when;

import org.junit.Test;

import cn.sprin1027.utils.SpringHelper;

public class WhenTest extends SpringHelper{
	static {
		path="cn/spring1027/createobject/when/applicationContext.xml";
	}
	
	@Test
	public void test(){
		HelloWorld helloWorld=(HelloWorld)context.getBean("helloWorld");
		Person person=(Person)context.getBean("psrson");
		helloWorld.hello();
		person.say();
	}
	
}
