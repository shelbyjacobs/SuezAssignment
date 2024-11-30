/* Person
Data for each Person object is retrieved from a CSV from a REST endpoint. OpenCSV is used to convert each row of the csv into a Person object.

Written by: Shelby Jacobs
Date: 2024-11-27
*/

package com.example;

import com.opencsv.bean.CsvBindByName;

public class Person
{
	/*Variables*/
	@CsvBindByName
	private String last_name;
	
	@CsvBindByName
	private int id;

	@CsvBindByName
	private String ip_address;
	
	@CsvBindByName
	private String first_name;
	
	@CsvBindByName
	private String email;


	/*Accessors*/
	public String getFirstName()
	{
		return first_name;
	}

	public String getLastName()
	{
		return last_name;
	}

	public int getId()
	{
		return id;
	}

	public String getIpAddress()
	{
		return ip_address;
	}

	public String getEmail()
	{
		return email;
	}


	/*Mutators*/
	public void setFirstName(String first_name)
	{
		this.first_name = first_name;
	}

	public void setLastName(String last_name)
	{
		this.last_name = last_name;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public void setIpAddress(String ip_address)
	{
		this.ip_address = ip_address;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}
}
