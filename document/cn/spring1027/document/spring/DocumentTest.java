package cn.spring1027.document.spring;

import org.junit.Test;

import cn.sprin1027.utils.SpringHelper;

public class DocumentTest extends SpringHelper{
	static {
		path="cn/spring1027/document/spring/applicationContext.xml";
	}
	
	
	@Test
	public void test(){
		DocumentManager documentManager=(DocumentManager)context.getBean("documentManager");
		documentManager.read(); //WordDocument read
	}

}
