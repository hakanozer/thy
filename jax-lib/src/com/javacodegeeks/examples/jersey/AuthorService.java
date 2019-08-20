package com.javacodegeeks.examples.jersey;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/AuthorService")
public class AuthorService {
	@GET
	@Path("/authors")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Person> getTrackInJSON() {
		List<Person> listPerson = new ArrayList<>();
		Person p1 = new Person();
		p1.setId(1);;
		p1.setName("name1");
		Person p2 = new Person();
		p2.setId(2);
		p2.setName("name2");
		listPerson.add(p1);
		listPerson.add(p2);
		return listPerson;
	}
	
	
}
