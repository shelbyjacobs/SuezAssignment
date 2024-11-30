/*RestClient
Connects to a REST endpoint. Set up to perform GET and PUT operations only.

Written by: Shelby Jacobs
Date: 2024-11-27
*/

package com.example;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RestClient
{
	/*Variables*/
	private String endpoint;
	private String x_access_token;

	HttpClient client = HttpClient.newHttpClient();


	/*Mutators*/
	public void setEndpoint(String endpoint)
	{
		this.endpoint = endpoint;
	}

	public void setXAccessToken(String x_access_token)
	{
		this.x_access_token = x_access_token;
	}


	/*get
	Retrieve data from the endpoint.
	*/
	public String get() throws Exception
	{
		//Verify that the endpoint URI has been set
		if (endpoint == null)
		{
			System.out.println("You have not set the endpoint for this REST connection.");
			System.exit(0);
		}

		//Verify that the x access token has been set
		if (x_access_token == null)
		{
			System.out.println("You have not set the x access token for this endpoint.");
			System.exit(0);
		}

		//Create the Http request
		HttpRequest request = HttpRequest.newBuilder()
			.uri(URI.create(endpoint))
			.header("x-access-token", x_access_token)
			.GET()
			.build();

		//Send the Http request
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

		System.out.println("GET status code: " + response.statusCode());

		//Verify that the request was successful
		if (response.statusCode() != 200)
		{
			System.out.println("There was an error when connecting to the endpoint.");
			System.exit(0);
		}

		return response.body();
	}

	/*put
	Send data to the endpoint.
	*/
	public void put(String body) throws Exception
	{
		//Verify that the endpoint URI has been set
		if (endpoint == null)
		{
			System.out.println("You have not set the endpoint for this REST connection.");
			System.exit(0);
		}

		//Verify that the x access token has been set
		if (x_access_token == null)
		{
			System.out.println("You have not set the x access token for this endpoint.");
			System.exit(0);
		}

		//Create the Http request
		HttpRequest request = HttpRequest.newBuilder()
			.uri(URI.create(endpoint))
			.header("x-access-token", x_access_token)
			.PUT(HttpRequest.BodyPublishers.ofString(body))
			.build();

		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

		System.out.println("PUT status code: " + response.statusCode());

		System.out.println(response.body());
	}
}
