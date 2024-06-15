package ead.rest;

import javax.ws.rs.*;

@Path("customers")
public class CustomerResource {

    @GET
    public String getCustomers() {
        return "All Customers";
    }

    @POST
    public String createCustomer() {
        return "Add Customer";
    }

    @GET
    @Path("/{id}")
    public String getCustomerById(@PathParam("id") int id) {
        return "Get customer details of id : " + id;
    }


    @PUT
    @Path("/{id}")
    public String updateCustomer(@PathParam("id") int id) {
        return "Update customer details of id : " + id;
    }


    @DELETE
    @Path("/{id}")
    public String deleteCustomer(@PathParam("id") int id) {
        return "Delete customer which is id = " + id;
    }

}
