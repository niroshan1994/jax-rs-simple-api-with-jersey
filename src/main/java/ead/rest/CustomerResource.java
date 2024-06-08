package ead.rest;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("customers")
public class CustomerResource {

    @GET
    public String index(HttpServletRequest request){
        return "Hello Customer";
    }

}
