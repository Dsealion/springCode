package cn.spring1027.di.xml.constructor;


import java.util.List;

import org.junit.Test;

import cn.sprin1027.utils.SpringHelper;

public class PersonTest extends SpringHelper{
	static{
		path="cn/spring1027/di/xml/constructor/applicationContext.xml";
	}
	
	@Test
	public void test(){
		
		Person person=(Person)context.getBean("person");
		//System.out.println(person.getPname());
		
		person.getStudent().say();
	}
}
