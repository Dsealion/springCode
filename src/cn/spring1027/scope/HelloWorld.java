package cn.spring1027.scope;

import java.util.ArrayList;
import java.util.List;

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
	/**
	 * 该属性是共享的，
	 * 		如果该属性有数据，会引发线程安全问题
	 */
	private List<String> lists=new ArrayList<String>();
	
	public HelloWorld(){
		System.out.println("aaa");
	}
	
	public void hello(){
		System.out.println("hello world");
	}
	
	public List<String> getLists(){
		return lists;
	}
	
//	@Test
//	public void test(){
//		HelloWorld helloWorld=new HelloWorld();
//		helloWorld.hello();
//	}
	
	
}
