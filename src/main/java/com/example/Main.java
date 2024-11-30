/*Main
Drives the core program.

Written by: Shelby Jacobs
Date: 2024-11-27
*/
package com.example;

import java.io.StringReader;
import java.util.Comparator;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main
{
	public static void main(String args[]) throws Exception
	{
		//Set up the REST client
		System.out.println("Creating REST client");
		RestClient client = new RestClient();
		client.setEndpoint("https://birt.eriscloud.com/interviewer/data");
		client.setXAccessToken("901278250");

		//Get the CSV from the endpoint
		System.out.println("Attempting GET of CSV data from endpoint");
		StringReader stringReader = new StringReader(client.get());

		//Process CSV data into a List of Person objects
		System.out.println("Converting CSV data into objects of class Person");
		List<Person> beans = new CsvToBeanBuilder<Person>(stringReader).withType(Person.class).build().parse();
		
		//Sort the List of Person objects
		System.out.println("Sorting data by first_name field");
		beans.sort(Comparator.comparing(Person::getFirstName));

		//Create DAO and fill Person list with the List of Person objects
		PersonDAO peeps = new PersonDAO();
		peeps.updateAllPeople(beans);

		//Convert the Person list into JSONs
		System.out.println("Converting Person objects into JSON form");
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(peeps.getAllPeople().getPersonList());

		//Put the sorted JSON array of Person objects to the endpoint
		System.out.println("Attempting PUT of JSON data to endpoint");
		client.put(jsonString);
	}
}
