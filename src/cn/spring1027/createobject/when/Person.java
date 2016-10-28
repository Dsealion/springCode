package cn.spring1027.createobject.when;

import java.util.ArrayList;
import java.util.List;

public class Person {
	
	private List<String> lists = new ArrayList<String>();  //当创建对象的时候会触发，使用lazy-init="true"属性，可以使用它的时候再创建，节省内存
	public Person(){
		for(int i=0;i<10;i++){
			lists.add(i+"");
		}
		System.out.println("person");
	}
	
	public void say(){
		System.out.println("Person say");
	}
}
