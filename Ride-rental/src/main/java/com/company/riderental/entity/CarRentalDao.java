package com.company.riderental.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CarRentalDao {

    @Autowired
    private DataSource dataSource;

    public void create(CarRentalData carRentalData) throws SQLException {
        String sql = "INSERT INTO dbo.CarRental (fuelType, rating, renterTripsTaken, reviewCount, location_city, location_country, location_latitude, location_longitude, location_state, owner_Id, rate_daily, vehicle_make, vehicle_model, vehicle_type, vehicle_year, airportcity, vehicle_registration) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, carRentalData.getFuelType());
            ps.setDouble(2, carRentalData.getRating());
            ps.setInt(3, carRentalData.getRenterTripsTaken());
            ps.setInt(4, carRentalData.getReviewCount());
            ps.setString(5, carRentalData.getCity());
            ps.setString(6, carRentalData.getCountry());
            ps.setDouble(7, carRentalData.getLatitude());
            ps.setDouble(8, carRentalData.getLongitude());
            ps.setString(9, carRentalData.getState());
            ps.setLong(10, carRentalData.getOwnerId());
            ps.setInt(11, carRentalData.getRateDaily());
            ps.setString(12, carRentalData.getMake());
            ps.setString(13, carRentalData.getModel());
            ps.setString(14, carRentalData.getType());
            ps.setInt(15, carRentalData.getYear());
            ps.setString(16, carRentalData.getAirportCity());



            ps.executeUpdate();
        }
    }

    public List<CarRentalData> readAll() throws SQLException {
        List<CarRentalData> carRentals = new ArrayList<>();
        String sql = "SELECT fuelType, rating, renterTripsTaken, reviewCount, location_city, location_country, location_latitude, location_longitude, location_state, owner_id, rate_daily, vehicle_make, vehicle_model, vehicle_type, vehicle_year, airportcity, vehicle_registration FROM dbo.CarRental";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                CarRentalData carRentalData = new CarRentalData();
                rs.getString("fuelType");
                        rs.getDouble("rating");
                        rs.getInt("renterTripsTaken");
                        rs.getInt("reviewCount");
                        rs.getString("location_city");
                        rs.getString("location_country");
                        rs.getDouble("location_latitude");
                        rs.getDouble("location_longitude");
                        rs.getString("location_state");
                        rs.getLong("owner_id");
                        rs.getInt("rate_daily");
                        rs.getString("vehicle_make");
                        rs.getString("vehicle_model");
                        rs.getString("vehicle_type");
                        rs.getInt("vehicle_year");
                        rs.getString("airportcity");
                        rs.getString("vehicle_registration");
                carRentals.add(carRentalData);
            }
        }
        return carRentals;
    }

    public void update(CarRentalData carRentalData) throws SQLException {
        String sql = "UPDATE dbo.CarRental SET fuelType = ?, rating = ?, renterTripsTaken = ?, reviewCount = ?, location_city = ?, location_country = ?, location_latitude = ?, location_longitude = ?, location_state = ?, owner_id = ?, rate_daily = ?, vehicle_make = ?, vehicle_model = ?, vehicle_type = ?, vehicle_year = ?, airportcity = ? WHERE vehicle_registration = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            // Set parameters from carRentalData
            ps.setString(1, carRentalData.getFuelType());
            ps.setDouble(2, carRentalData.getRating());
            ps.setInt(3, carRentalData.getRenterTripsTaken());
            ps.setInt(4, carRentalData.getReviewCount());
            ps.setString(5, carRentalData.getCity());
            ps.setString(6, carRentalData.getCountry());
            ps.setDouble(7, carRentalData.getLatitude());
            ps.setDouble(8, carRentalData.getLongitude());
            ps.setString(9, carRentalData.getState());
            ps.setLong(10, carRentalData.getOwnerId());
            ps.setInt(11, carRentalData.getRateDaily());
            ps.setString(12, carRentalData.getMake());
            ps.setString(13, carRentalData.getModel());
            ps.setString(14, carRentalData.getType());
            ps.setInt(15, carRentalData.getYear());
            ps.setString(16, carRentalData.getAirportCity());
            ps.setString(17, carRentalData.getVehicleReg());

            ps.executeUpdate();
        }
    }

    public void delete(String vehicle_registration) throws SQLException {
        String sql = "DELETE FROM dbo.CarRental WHERE vehicle_registration = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, vehicle_registration);
            ps.executeUpdate();
        }
    }

    public List<CarRentalData> findByMakeAndModel(String vehicleMake, String vehicleModel, String city) {
        String sql = "SELECT * FROM dbo.CarRental WHERE vehicle_make = ? AND vehicle_model = ? AND location_city = ?";
        List<CarRentalData> carRentals = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, vehicleMake);
            ps.setString(2, vehicleModel);
            ps.setString(3, city);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    CarRentalData carRentalData = new CarRentalData(
                            rs.getString("fuelType"),
                    rs.getDouble("rating"),
                    rs.getInt("renterTripsTaken"),
                    rs.getInt("reviewCount"),
                    rs.getString("location_city"),
                    rs.getString("location_country"),
                    rs.getDouble("location_latitude"),
                    rs.getDouble("location_longitude"),
                    rs.getString("location_state"),
                    rs.getLong("owner_id"),
                    rs.getInt("rate_daily"),
                    rs.getString("vehicle_make"),
                    rs.getString("vehicle_model"),
                    rs.getString("vehicle_type"),
                    rs.getInt("vehicle_year"),
                    rs.getString("airportcity"),
                    rs.getString("vehicle_registration")
                    );
                    carRentals.add(carRentalData);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Consider a more robust error handling strategy
        }

        return carRentals;
    }

    public List<String> getUniqueVehicleMakes() throws SQLException {
        List<String> vehicleMakes = new ArrayList<>();
        String sql = "SELECT DISTINCT vehicle_make FROM dbo.CarRental"; // Replace CarRentalTable with your actual table name

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                vehicleMakes.add(resultSet.getString("vehicle_make"));
            }
        }
        return vehicleMakes;
    }

    public List<String> getUniqueVehicleModels(String vehicleMake) throws SQLException {
        List<String> vehicleModels = new ArrayList<>();
        String sql = "SELECT DISTINCT vehicle_model FROM dbo.CarRental WHERE vehicle_make = ?"; // Adjust table name as necessary

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, vehicleMake); // Set the vehicle make parameter

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    vehicleModels.add(resultSet.getString("vehicle_model"));
                }
            }
        }
        return vehicleModels;
    }

    public List<String> getUniqueVehicleLocations() throws SQLException {
        List<String> vehicleLocations = new ArrayList<>();
        String sql = "SELECT DISTINCT location_city FROM dbo.CarRental"; // Replace CarRental with your actual table name

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                vehicleLocations.add(resultSet.getString("location_city"));
            }
        }
        return vehicleLocations;
    }





}
