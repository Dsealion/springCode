package ioc.pojo;

public class student {
	private String name;
	private String stuId;
	private String speciality;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStuId() {
		return stuId;
	}
	public void setStuId(String stuId) {
		this.stuId = stuId;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	
	@Override
	public String toString() {
		return "姓名="+name+";学号="+stuId+(speciality==null?"":"最擅长使用"+speciality);
	}
	
	
}
