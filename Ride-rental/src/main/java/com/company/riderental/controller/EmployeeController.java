package com.company.riderental.controller;

import com.company.riderental.entity.EmployeeData;
import com.company.riderental.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<EmployeeData>> getAllEmployees() {
        List<EmployeeData> employees = employeeService.getAllEmployees();
        return employees != null
                ? new ResponseEntity<>(employees, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("/add")
    public ResponseEntity<EmployeeData> addEmployee(@RequestBody EmployeeData employeeData) {
        boolean isAdded = employeeService.addEmployee(employeeData);
        return isAdded
                ? new ResponseEntity<>(employeeData, HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
