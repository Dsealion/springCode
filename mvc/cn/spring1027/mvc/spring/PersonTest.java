package cn.spring1027.mvc.spring;

import org.junit.Test;

import cn.sprin1027.utils.SpringHelper;

public class PersonTest extends SpringHelper{
	static {
		path="cn/spring1027/mvc/spring/applicationContext.xml";
	}
	
	@Test
	public void test(){
		PersonAction personAction=(PersonAction)context.getBean("personAction");
		personAction.savePerson();
	}
}
