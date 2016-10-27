package cn.spring1027.helloworld;

import org.junit.Test;

/**
 * spring容器
	1、写一个java类
	      HelloWorld
	2、写一个spring的配置文件
	     把HelloWorld这个类放入到spring容器中
	3、启动spring容器
	4、从spring容器中把helloWorld取出来
	5、对象.方法
	
	说明：spring容器负责创建对象，程序员不用创建对象

 * @author Administrator
 *
 */
public class HelloWorld {
	public void hello(){
		System.out.println("hello world");
	}
	
//	@Test
//	public void test(){
//		HelloWorld helloWorld=new HelloWorld();
//		helloWorld.hello();
//	}
	
	
}
