package com.company.riderental.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

@Repository
public class EmployeeDao {
    @Autowired
    private DataSource dataSource;

    public EmployeeDao(DataSource theDataSource) {
        this.dataSource = theDataSource;
    }

    public List<EmployeeData> findAll() throws SQLException {
        List<EmployeeData> employees = new ArrayList<>();
        String sql = "SELECT * FROM dbo.Employees";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                employees.add(mapRowToEmployeeData(rs));
            }
        }
        return employees;
    }

    // Example of a method to insert a new employee record into the database
    public boolean insertEmployee(EmployeeData employee) throws SQLException {
        String sql = "INSERT INTO dbo.Employees (Username, PasswordHash, Email, Role, Department, CreatedDate, LastLogin) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, employee.getUsername());
            stmt.setString(2, employee.getPasswordHash());
            stmt.setString(3, employee.getEmail());
            stmt.setString(4, employee.getRole());
            stmt.setString(5, employee.getDepartment());
            stmt.setObject(6, employee.getCreatedDate());
            stmt.setObject(7, employee.getLastLogin());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        }
    }

    // Helper method to map a ResultSet row to an EmployeeData object
    private EmployeeData mapRowToEmployeeData(ResultSet rs) throws SQLException {
        return new EmployeeData(
                rs.getInt("EmployeeID"),
                rs.getString("Username"),
                rs.getString("PasswordHash"),
                rs.getString("Email"),
                rs.getString("Role"),
                rs.getString("Department"),
                rs.getTimestamp("CreatedDate").toLocalDateTime(),
                rs.getTimestamp("LastLogin") != null ? rs.getTimestamp("LastLogin").toLocalDateTime() : null
        );
    }

    // Add other CRUD methods as needed...
}

