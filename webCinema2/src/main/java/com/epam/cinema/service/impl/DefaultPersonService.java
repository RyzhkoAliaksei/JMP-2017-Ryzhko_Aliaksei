package com.epam.cinema.service.impl;

import java.util.NavigableMap;
import java.util.TreeMap;

import org.springframework.stereotype.Service;

import com.epam.cinema.model.Person;
import com.epam.cinema.service.PersonService;


@Service
public class DefaultPersonService implements PersonService {
	
	private static NavigableMap<Long, Person> persons = new TreeMap<Long, Person>();

	public Long createPerson(Person person) {
		if (persons.isEmpty()) {
			person.setId(1L);
		} else {
			person.setId(persons.lastKey() + 1L);
		}
		persons.put(person.getId(), person);
		return person.getId();
	}

	public void removePersonById(Long id) {
		persons.remove(id);

	}

	public Person getPersonById(Long id) {
		return persons.get(id);
	}

}
