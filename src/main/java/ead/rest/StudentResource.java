package ead.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("students")
public class StudentResource {

    @GET
    public String index(){
        return "Hello Student";
    }

}
