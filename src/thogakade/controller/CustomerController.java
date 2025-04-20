/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thogakade.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import thogakade.db.DBConnection;
import thogakade.model.Customer;

/**
 *
 * @author Nirodha
 */
public class CustomerController {

    public static boolean addCustomer(Customer customer) throws ClassNotFoundException, SQLException {
        String SQL = "insert into customer values('" + customer.getId() + "','" + customer.getName() + "','" + customer.getAddress() + "'," + customer.getSalary() + ")";
        Connection connection = DBConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        int res = statement.executeUpdate(SQL);
        return res > 0;
    }

    public static Customer searchCustomer(String id) throws ClassNotFoundException, SQLException {
        String SQL = "select * from customer where id = '"+id+"'";
        Connection connection = DBConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(SQL);
        if(result.next()){
            Customer customer = new Customer(result.getString("id"), result.getString("name"), result.getString("address"), result.getDouble("salary"));            
            return customer;
        }
        return null;
    }

    public static boolean deleteCustomer(String id) throws ClassNotFoundException, SQLException {
        String SQL = "delete from customer where id = '"+id+"'";
        Connection connection = DBConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        int reuslt = statement.executeUpdate(SQL);
        return reuslt > 0;
    }
}
