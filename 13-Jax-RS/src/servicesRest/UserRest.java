package servicesRest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/user")
public class UserRest {
	
	
	// all user rest -> json
	@GET
	@Path("/allUser")
	@Produces(MediaType.APPLICATION_JSON)
	public HashMap<String, Object> allUser( @DefaultValue(value = "") @QueryParam(value = "api_key") String api_key ) {
		HashMap<String, Object> hm = new HashMap<>();
		if (api_key.equals("5dd28be5b8243bff4aef0bf0755ded7c")) {
			hm.put("statu", true);
			hm.put("message", "işlem başarılı");
			hm.put("list", dataResult());
		}else {
			// api key hatalı
			hm.put("statu", false);
			hm.put("message", "Api_Key Hatalı!");
		}
		
		return hm;
	}
	
	static List<User> ls = new ArrayList<User>();
	public List<User> dataResult() {
		if(ls.size() < 10)
		for (int i = 0; i < 10; i++) {
			User us = new User();
			us.setId(i);
			us.setName("Ahmet " + i);
			us.setSurname("Bilmem : " + i);
			ls.add(us);
		}
		return ls;
	}
	
	
	// add user
	@POST
	@Path("/addUser")
	@Produces(MediaType.APPLICATION_JSON)
	public HashMap<String, Object> addUser( @BeanParam User us ) {
		HashMap<String, Object> hm = new HashMap<>();
		hm.put("statu", true);
		hm.put("user", us);
		ls.add(us);
		return hm;
	}
	
	
	
	

}
