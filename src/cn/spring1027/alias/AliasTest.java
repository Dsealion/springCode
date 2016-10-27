package cn.spring1027.alias;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.sprin1027.utils.SpringHelper;

/**
 * 别名
 * @author Administrator
 *
 */
public class AliasTest extends SpringHelper{
	
	/**
	 * 无论这两个类有什么继承关系，静态代码块比方法先执行
	 */
	static{
		path="cn/spring1027/alias/applicationContext.xml";
	}
	
	@Test
	public void test(){
		HelloWorld helloWorld=(HelloWorld)context.getBean("helloWorld");
		HelloWorld helloWorld2=(HelloWorld)context.getBean("wangermazi");
		HelloWorld helloWorld3=(HelloWorld)context.getBean("liulaosan");
		helloWorld2.hello();

	}
}
