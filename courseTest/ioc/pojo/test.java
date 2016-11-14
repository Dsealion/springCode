package ioc.pojo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("ioc/pojo/beans.xml");
		student stu=(student)applicationContext.getBean("student");
		System.out.println(stu);
	}

}
