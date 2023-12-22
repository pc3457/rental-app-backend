package com.company.riderental.service;

import com.company.riderental.entity.CarRentalDao;
import com.company.riderental.entity.CarRentalData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Logger;

@Service
public class CarRentalService {

    private static final Logger log;

    @Autowired
    private CarRentalDao carRentalDao;

    static {
        System.setProperty("java.util.logging.SimpleFormatter.format", "[%4$-7s] %5$s %n");
        log = Logger.getLogger(CarRentalService.class.getName());
    }


    /*
    public static void main(String[] args) throws Exception {
        log.info("Loading application properties");
        Properties properties = new Properties();
        properties.load(ConnectData.class.getClassLoader().getResourceAsStream("application.properties"));

        log.info("Connecting to the database");
        Connection connection = DriverManager.getConnection(properties.getProperty("url"), properties);
        log.info("Database connection test: " + connection.getCatalog());

        log.info("Create database schema");
        Scanner scanner = new Scanner(ConnectData.class.getClassLoader().getResourceAsStream("schema.sql"));
        Statement statement = connection.createStatement();
        while (scanner.hasNextLine()) {
            statement.execute(scanner.nextLine());
        }

    }

     */
    // Create a new car rental record
    public CarRentalData createCarRental(CarRentalData carRentalData) {
        try {
            carRentalDao.create(carRentalData);
            return carRentalData;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<CarRentalData> findCarRentalsByMakeAndModel(String vehicleMake, String vehicleModel, String city) {
        return carRentalDao.findByMakeAndModel(vehicleMake, vehicleModel, city);
    }

    // Read all car rental records
    public List<CarRentalData> getAllCarRentals() {
        try {
            return carRentalDao.readAll();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    // Update an existing car rental record
    public CarRentalData updateCarRental(CarRentalData carRentalData) {
        try {
            carRentalDao.update(carRentalData);
            return carRentalData;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Delete a car rental record
    public void deleteCarRental(String vehicleReg) {
        try {
            carRentalDao.delete(vehicleReg);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to get unique vehicle makes
    public List<String> getUniqueVehicleMakes() throws SQLException {
        return carRentalDao.getUniqueVehicleMakes();
    }

    // Method to get unique vehicle models
    public List<String> getUniqueVehicleModels(String vehicleMake) throws SQLException {
        return carRentalDao.getUniqueVehicleModels(vehicleMake);
    }

    public List<String> getUniqueVehicleLocations() {
        try {
            return carRentalDao.getUniqueVehicleLocations();
        } catch (Exception e) {
            // Log the exception
            System.err.println("Error fetching unique vehicle locations: " + e.getMessage());
            // You could also throw an appropriate exception here
            throw new RuntimeException("Error fetching unique vehicle locations", e);
        }
    }






}
