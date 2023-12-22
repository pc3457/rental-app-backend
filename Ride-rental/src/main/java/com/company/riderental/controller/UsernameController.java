package com.company.riderental.controller;

import com.company.riderental.entity.CustomerData;
import com.company.riderental.entity.SignInDao;
import com.company.riderental.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/users")
public class UsernameController {

    @Autowired
    private final CustomerService customerService;



    @Autowired
    public UsernameController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addCustomer(@RequestBody CustomerData customer) {
        boolean isAdded = customerService.addCustomer(customer);
        System.out.println(customer);
        if (isAdded) {
            if (customer.getPasswordHash() == null) {
                // Handle the case where passwordHash is null
                return new ResponseEntity<>("Password is required", HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>("Customer added successfully", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Failed to add customer", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{username}")
    public ResponseEntity<CustomerData> getCustomerByUsername(@PathVariable String username) {
        CustomerData customer = customerService.getCustomerByUsername(username);
        if (customer != null) {
            return new ResponseEntity<>(customer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{Username}")
    public ResponseEntity<?> updateCustomer(@RequestBody CustomerData customer) {
        boolean isUpdated = customerService.updateCustomer(customer);
        if (isUpdated) {
            return new ResponseEntity<>("Customer updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to update customer", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{Username}")
    public ResponseEntity<?> deleteCustomer(@PathVariable String username) {
        boolean isDeleted = customerService.deleteCustomer(username);
        if (isDeleted) {
            return new ResponseEntity<>("Customer deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to delete customer", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<CustomerData>> getAllCustomers() {
        List<CustomerData> customers = customerService.getAllCustomers();
        if (customers != null && !customers.isEmpty()) {
            return new ResponseEntity<>(customers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/sign-in")
    public ResponseEntity<?> signIn(@RequestBody SignInDao signInRequest) throws SQLException {
        try {
            boolean isValidUser = customerService.authenticate(signInRequest.getUsername(), signInRequest.getPassword());
            if (isValidUser) {
                Map<String, Boolean> response = new HashMap<>();
                response.put("isValid", true);
                return ResponseEntity.ok().body(response);
            } else {
                Map<String, Boolean> response = new HashMap<>();
                response.put("isValid", false);
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
            }
        }catch (Exception e){
            e.printStackTrace();
            Map<String, String> response = new HashMap<>();
            response.put("error",e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }



}

