package cn.spring1027.mvc.spring;

public class PersonAction {
	private PersonService personService;

	public PersonService getPersonService() {
		return personService;
	}

	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}
	
	public void savePerson(){
		this.personService.savePerson();
	}
}
