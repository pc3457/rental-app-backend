package com.company.riderental.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
@Entity
@Table(name = "dbo.Employees")
public class EmployeeData {

    @Id
    @Column(name = "EmployeeId")
    private int employeeID;
    @Column(name = "Username")
    private String username;
    @Column(name = "PasswordHash")
    private String passwordHash;
    @Column(name = "Email")
    private String email;
    @Column(name = "Role")
    private String role;
    @Column(name = "Department")
    private String department;
    @Column(name = "CreatedDate")
    private LocalDateTime createdDate;
    @Column(name = "LastLogin")
    private LocalDateTime lastLogin;

    public EmployeeData(int employeeID, String username, String passwordHash, String email, String role, String department, LocalDateTime createdDate, LocalDateTime lastLogin) {
        this.employeeID = employeeID;
        this.username = username;
        this.passwordHash = passwordHash;
        this.email = email;
        this.role = role;
        this.department = department;
        this.createdDate = createdDate;
        this.lastLogin = lastLogin;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    @Override
    public String toString() {
        return "EmployeeData{" +
                "employeeID=" + employeeID +
                ", username='" + username + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", department='" + department + '\'' +
                ", createdDate=" + createdDate +
                ", lastLogin=" + lastLogin +
                '}';
    }
}
