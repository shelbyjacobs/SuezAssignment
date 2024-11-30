/*People
A list of Person objects. After retrieving the csv of people from the endpoint, it gets stored as a List to be sorted.

Written by: Shelby Jacobs
Date: 2024-11-27
*/
package com.example;

import java.util.List;
import java.util.ArrayList;

public class PersonList
{
	/*Variables*/
	private List<Person> personList;


	/*Accessors*/
	public List<Person> getPersonList()
	{
		if (personList == null)
		{
			personList = new ArrayList<Person>();
		}

		return personList;
	}

	
	/*Mutators*/
	public void setPersonList(List<Person> personList)
	{
		this.personList = personList;
	}
}
