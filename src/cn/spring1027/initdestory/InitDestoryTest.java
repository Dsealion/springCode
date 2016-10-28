package cn.spring1027.initdestory;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.sprin1027.utils.SpringHelper;

public class InitDestoryTest extends SpringHelper{
	static {
		path="cn/spring1027/initdestory/applicationContext.xml";
	}
	
	@Test
	public void test(){
		ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext();
		HelloWorld helloWorld=(HelloWorld)applicationContext.getBean("helloWorld");
		//helloWorld.hello();  //aaa
							//init
							//hello world
		
		applicationContext.close();  //destroy
		
		
		
	}
}
