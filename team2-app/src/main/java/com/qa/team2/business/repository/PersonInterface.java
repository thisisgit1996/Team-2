package com.qa.team2.business.repository;

public interface PersonInterface {
	
	String getAllPersons();

	String addNewPerson(String bookJson);

	String deletePerson(Long id);
	
	String findPerson(Long id);
	
	String updatePerson(Long id, String person);
}
