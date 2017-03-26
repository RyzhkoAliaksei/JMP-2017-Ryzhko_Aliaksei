package cinema.service;


import cinema.model.Person;

public interface PersonService {

	Long createPerson(Person person);

	void removePersonById(Long id);

	Person getPersonById(Long id);
}
