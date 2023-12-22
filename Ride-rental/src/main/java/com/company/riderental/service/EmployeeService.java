package com.company.riderental.service;

import com.company.riderental.entity.EmployeeDao;
import com.company.riderental.entity.EmployeeData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public EmployeeService(EmployeeDao theEmployeeDao) {
        this.employeeDao = theEmployeeDao;
    }

    public List<EmployeeData> getAllEmployees() {
        try {
            return employeeDao.findAll();
        } catch (SQLException e) {
            // Log and handle exception
            e.printStackTrace();
            return null;
        }
    }

    public boolean addEmployee(EmployeeData employee) {
        try {
            return employeeDao.insertEmployee(employee);
        } catch (SQLException e) {
            // Log and handle exception
            e.printStackTrace();
            return false;
        }
    }

    // Other service methods for update, delete, find by id, etc.
}

