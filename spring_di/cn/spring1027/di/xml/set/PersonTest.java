package cn.spring1027.di.xml.set;


import java.util.List;

import org.junit.Test;

import cn.sprin1027.utils.SpringHelper;

public class PersonTest extends SpringHelper{
	static{
		path="cn/spring1027/di/xml/set/applicationContext.xml";
	}
	
	@Test
	public void test(){
		Person person=(Person)context.getBean("person");
		person.getStudent().say();
		
		System.out.println(person.getPid());
		System.out.println(person.getPname());
		
		List lists=person.getLists();
		for(int i=0;i<lists.size();i++){
			System.out.println(lists.get(i).toString());
		}
		
	}
}
