package ead.rest.dao;

import ead.rest.entity.Customer;
import ead.rest.util.DBConnection;

import javax.inject.Singleton;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class CustomerDao {

    public List<Customer> getAll() throws SQLException {
        Connection con = DBConnection.getConnection();
        String sql = "SELECT * FROM customer";
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        List<Customer> customers = new ArrayList<>();
        while (resultSet.next()) {
            Customer customer = new Customer();
            customer.setId(resultSet.getInt("id"));
            customer.setName(resultSet.getString("name"));
            customer.setCity(resultSet.getString("city"));
            customers.add(customer);
        }
        con.close();
        return customers;
    }

    public Customer getById(Integer id) throws SQLException {
        Connection con = DBConnection.getConnection();
        String sql = "SELECT * FROM customer WHERE id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet resultSet = ps.executeQuery();
        Customer customer = null;
        while (resultSet.next()) {
            customer = new Customer();
            customer.setId(resultSet.getInt("id"));
            customer.setName(resultSet.getString("name"));
            customer.setCity(resultSet.getString("city"));
        }
        con.close();
        return customer;
    }

    public void add(Customer customer) throws SQLException {
        Connection con = DBConnection.getConnection();
        String sql = "INSERT INTO customer(name, city) VALUES(?,?)";
        PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, customer.getName());
        ps.setString(2, customer.getCity());
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        rs.next();
        customer.setId(rs.getInt(1));
    }

    public void delete(Customer customer) throws SQLException {
        deleteById(customer.getId());
    }

    public void deleteById(Integer id) throws SQLException {
        Connection con = DBConnection.getConnection();
        String sql = "DELETE FROM customer WHERE id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        boolean result = ps.execute();
    }

    public void update(Integer id, Customer customer) throws SQLException {
        Connection con = DBConnection.getConnection();
        String sql = "UPDATE customer SET id=?, name=?, city=? WHERE id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, customer.getId());
        ps.setString(2, customer.getName());
        ps.setString(3, customer.getCity());
        ps.setInt(4, id);
        boolean result = ps.execute();
    }

}
