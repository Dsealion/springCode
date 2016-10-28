package cn.spring1027.scope;

import org.junit.Test;

import cn.sprin1027.utils.SpringHelper;

public class ScopeTest extends SpringHelper{
	static {
		path="cn/spring1027/scope/applicationContext.xml";
	}
	
	@Test
	public void test(){
		/**
		 * 只调用一次构造器
		 */
		HelloWorld helloWorld=(HelloWorld)context.getBean("helloWorld");
		helloWorld.getLists().add("23ew");
		System.out.println(helloWorld);
		
		HelloWorld helloWorld2=(HelloWorld)context.getBean("helloWorld");
		helloWorld2.getLists().add("2424jfgj");
		System.out.println(helloWorld.getLists().size());	//单例是2
		System.out.println(helloWorld2.getLists().size());    //单例是2
	}
}
