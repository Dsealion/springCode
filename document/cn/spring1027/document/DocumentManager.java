package cn.spring1027.document;

public class DocumentManager {
	private Document document;
	
	public DocumentManager(Document document){
		this.document=document;
	}
	
	public void read(){
		this.document.read();
	}
	
	public void write(){
		this.document.write();
	}
}
