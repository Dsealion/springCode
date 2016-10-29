package cn.spring1027.di.xml.constructor;

public class Person {
	private Long pid;  //包装类型
	
	private String pname;  // String类型
	
	private Student student; //引用类型
	
	public Person(Long pid,String pname){
		this.pid=pid;
		this.pname=pname;
	}
	
	public Person(String pname,Student student){
		this.pname=pname;
		this.student=student;
	}

	public Long getPid() {
		return pid;
	}

	public String getPname() {
		return pname;
	}

	public Student getStudent() {
		return student;
	}

}
