package com.company.riderental.service;

import com.company.riderental.entity.RideShareDao;
import com.company.riderental.entity.RideShareData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;
import java.sql.SQLException;

@Service
public class RideShareService {

    private static final Logger log;



    @Autowired
    private RideShareDao rideShareDao;


    static {
        System.setProperty("java.util.logging.SimpleFormatter.format", "[%4$-7s] %5$s %n");
        log = Logger.getLogger(RideShareService.class.getName());
    }

    /*
    public static void main(String[] args) throws Exception {
        log.info("Loading application properties");
        Properties properties = new Properties();
        properties.load(ConnectData.class.getClassLoader().getResourceAsStream("application.properties"));

        log.info("Connecting to the database RideShare");
        Connection connection = DriverManager.getConnection(properties.getProperty("url"), properties);
        log.info("Database connection test: " + connection.getCatalog());

        /*
        log.info("Create database schema");
        Scanner scanner = new Scanner(ConnectData.class.getClassLoader().getResourceAsStream("schema.sql"));
        Statement statement = connection.createStatement();
        while (scanner.hasNextLine()) {
            statement.execute(scanner.nextLine());
        }



    }
    */
    public RideShareData createRideShare(RideShareData rideShareData) throws SQLException {
        // Business logic and call to DAO for creating a rideshare record
        return rideShareDao.insert(rideShareData);
    }

    public RideShareData updateRideShare(String id, RideShareData rideShareData) throws SQLException {
        // Business logic and call to DAO for updating a rideshare record
        return rideShareDao.update(rideShareData);
    }

    public void deleteRideShare(RideShareData rideShareData) throws SQLException {
        // Business logic and call to DAO for deleting a rideshare record
        rideShareDao.delete(rideShareData);
    }

    public List<RideShareData> readRideShare() {
        try {
            return rideShareDao.read();
        } catch (SQLException e) {
            e.printStackTrace(); // Consider better error handling
            return null; // or throw a custom exception
        }
    }

    /*
    public void deleteRideShare(RideShareData rideShareData) {
        // Business logic and call to DAO for deleting a rideshare record
        return rideShareDao.delete(id);
    }

     */


}