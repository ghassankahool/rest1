package com.ghassan;

import java.net.URI;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class Runner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 ClientConfig config = new DefaultClientConfig();
		    Client client = Client.create(config);
		    WebResource service = client.resource(getBaseURI());
		    // Get XML
		  //  System.out.println(service.path("rest").path("todo").accept(MediaType.TEXT_XML).get(String.class));
		    // Get XML for application
		    System.out.println(service.path("rest").path("sponsor").accept(MediaType.APPLICATION_JSON).get(String.class));
		    // Get JSON for application
		    System.out.println(service.path("rest").path("sponsor/2").accept(MediaType.APPLICATION_XML).get(String.class));
		    System.out.println(service.path("rest").path("sponsor/2").accept(MediaType.APPLICATION_JSON).get(String.class));
		  }

		  private static URI getBaseURI() {
		    return UriBuilder.fromUri("http://localhost:8080/restjaxb").build();
		  }
}
