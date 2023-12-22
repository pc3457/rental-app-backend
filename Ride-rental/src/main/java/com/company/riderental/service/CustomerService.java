package com.company.riderental.service;

import com.company.riderental.entity.CustomerDao;
import com.company.riderental.entity.CustomerData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerDao customerDao;

    // Constructor that takes a CustomerDao instance
    public CustomerService(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    // Method to add a new customer
    public boolean addCustomer(CustomerData customer) {
        try {
            return customerDao.addCustomer(customer);
        } catch (SQLException e) {
            // Handle exception (log it, wrap it in a custom exception, etc.)
            e.printStackTrace();
            return false;
        }
    }

    // Method to retrieve a customer by username
    public CustomerData getCustomerByUsername(String username) {
        try {
            return customerDao.getCustomerByUsername(username);
        } catch (SQLException e) {
            // Handle exception
            e.printStackTrace();
            return null;
        }
    }

    // Method to update a customer's information
    public boolean updateCustomer(CustomerData customer) {
        try {
            return customerDao.updateCustomer(customer);
        } catch (SQLException e) {
            // Handle exception
            e.printStackTrace();
            return false;
        }
    }

    // Method to delete a customer
    public boolean deleteCustomer(String username) {
        try {
            return customerDao.deleteCustomer(username);
        } catch (SQLException e) {
            // Handle exception
            e.printStackTrace();
            return false;
        }
    }

    // Method to get a list of all customers
    public List<CustomerData> getAllCustomers() {
        try {
            return customerDao.getAllCustomers();
        } catch (SQLException e) {
            // Handle exception
            e.printStackTrace();
            return null;
        }
    }

    public boolean authenticate(String username, String password) throws SQLException {
        CustomerData customer = customerDao.getCustomerByUsername(username);
        if (customer != null) {
            return customer.getPasswordHash().equals(password);
        }
        return false;
    }

}

