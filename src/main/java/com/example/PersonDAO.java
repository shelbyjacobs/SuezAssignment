/*PersonDAO
DAO to perform CRUD operations on the list of Person objects. Only get and update have been implemented, as the other two aren't required for this assignment.

Written by: Shelby Jacobs
Date: 2024-11-27
*/
package com.example;

import java.util.List;

public class PersonDAO
{
	/*Variables*/
	private static PersonList personList = new PersonList();


	/*Get*/
	public PersonList getAllPeople()
	{
		return personList;
	}


	/*Update*/
	public void updateAllPeople(List<Person> newPersonList)
	{
		personList.setPersonList(newPersonList);
	}
}
