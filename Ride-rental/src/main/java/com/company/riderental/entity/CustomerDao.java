package com.company.riderental.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerDao {
    private DataSource dataSource;

    @Autowired
    public CustomerDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    // Method to add a new customer
    public boolean addCustomer(CustomerData customer) throws SQLException {
        String sql = "INSERT INTO dbo.Customers (Username, PasswordHash, Email, CreatedDate, LastLogin, FirstName, LastName, PhoneNumber, Age, Address, ZipCode) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, customer.getUsername());
            ps.setString(2, customer.getPasswordHash());
            ps.setString(3, customer.getEmail());
            Timestamp now = new Timestamp(System.currentTimeMillis());
            ps.setTimestamp(4, customer.getCreatedDate() != null ? Timestamp.valueOf(customer.getCreatedDate()) : now);
            ps.setTimestamp(5, customer.getLastLogin() != null ? Timestamp.valueOf(customer.getLastLogin()) : now);
            ps.setString(6, customer.getFirstName());
            ps.setString(7, customer.getLastName());
            ps.setString(8, customer.getPhoneNumber());
            ps.setInt(9, customer.getAge());
            ps.setString(10, customer.getAddress());
            ps.setString(11, customer.getZipCode());


            int affectedRows = ps.executeUpdate();
            return affectedRows > 0;
        }
    }

    // Method to fetch a customer by username
    public CustomerData getCustomerByUsername(String username) throws SQLException {
        CustomerData customer = null;
        String sql = "SELECT * FROM dbo.Customers WHERE Username = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql))  {
            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    customer = new CustomerData(
                            rs.getString("Username"),
                            rs.getString("PasswordHash"),
                            rs.getString("Email"),
                            rs.getTimestamp("CreatedDate").toLocalDateTime(),
                            rs.getTimestamp("LastLogin").toLocalDateTime(),
                            rs.getString("FirstName"),
                            rs.getString("LastName"),
                            rs.getString("PhoneNumber"),
                            rs.getInt("Age"),
                            rs.getString("Address"),
                            rs.getString("ZipCode")
                    );
                }
            }
        }
        return customer;
    }

    // Method to update a customer's information
    public boolean updateCustomer(CustomerData customer) throws SQLException {
        String sql = "UPDATE dbo.Customers SET Email = ?, FirstName = ?, LastName = ?, PhoneNumber = ?, Age = ?, Address = ?, ZipCode = ? WHERE Username = ?";
        try (Connection conn = dataSource.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, customer.getEmail());
            ps.setString(2, customer.getFirstName());
            ps.setString(3, customer.getLastName());
            ps.setString(4, customer.getPhoneNumber());
            ps.setInt(5, customer.getAge());
            ps.setString(6, customer.getAddress());
            ps.setString(7, customer.getZipCode());
            ps.setString(8, customer.getUsername());

            int affectedRows = ps.executeUpdate();
            return affectedRows > 0;
        }
    }

    // Method to delete a customer
    public boolean deleteCustomer(String username) throws SQLException {
        String sql = "DELETE FROM dbo.Customers WHERE Username = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql))  {
            ps.setString(1, username);
            int affectedRows = ps.executeUpdate();
            return affectedRows > 0;
        }
    }

    // Method to list all customers
    public List<CustomerData> getAllCustomers() throws SQLException {
        List<CustomerData> customers = new ArrayList<>();
        String sql = "SELECT * FROM dbo.Customers";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery())  {
            while (rs.next()) {
                CustomerData customer = new CustomerData(
                        rs.getString("Username"),
                        rs.getString("PasswordHash"),
                        rs.getString("Email"),
                        rs.getTimestamp("CreatedDate").toLocalDateTime(),
                        rs.getTimestamp("LastLogin").toLocalDateTime(),
                        rs.getString("FirstName"),
                        rs.getString("LastName"),
                        rs.getString("PhoneNumber"),
                        rs.getInt("Age"),
                        rs.getString("Address"),
                        rs.getString("ZipCode")
                );
                customers.add(customer);
            }
        }
        return customers;
    }
}

