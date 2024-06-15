package ead.rest.resource;

import ead.rest.dao.CustomerDao;
import ead.rest.entity.Customer;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;

@Path("customers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CustomerResource {

    @Inject
    private CustomerDao customerDao;

    @GET
    public List<Customer> getCustomers() throws SQLException {
        return customerDao.getAll();
    }

    @POST
    public Customer createCustomer(Customer customer) throws SQLException {
        customerDao.add(customer);
        return customer;
    }

    @GET
    @Path("/{id}")
    public Customer getCustomerById(@PathParam("id") int id) throws SQLException {
        return customerDao.getById(id);
    }


    @PUT
    @Path("/{id}")
    public Customer updateCustomer(@PathParam("id") int id, Customer customer) throws SQLException {
        customerDao.update(id, customer);
        return customer;
    }


    @DELETE
    @Path("/{id}")
    public void deleteCustomer(@PathParam("id") int id) throws SQLException {
        customerDao.deleteById(id);
    }

}
