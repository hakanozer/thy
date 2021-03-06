package servicesRest;

import javax.ws.rs.QueryParam;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
	
	@QueryParam("id")
	private int id;
	
	@QueryParam("name")
	private String name;
	
	@QueryParam("surname")
	private String surname;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public User(int id, String name, String surname) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
	}
	
	public User() {
		super();
	}
	
	
	

}
