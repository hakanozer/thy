package rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



import servis.User;

@Path("/users")
public class UserEndpoint {
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Response list() {
		List<User> ls = new ArrayList<User>();
		for (int i = 0; i < 10; i++) {
			User u = new User();
			u.setId(i);
			u.setName("ali " + i);
			u.setSurname("bilmem " + i);
			ls.add(u);
		}
		return Response.ok().entity(ls).build();
	}


}
