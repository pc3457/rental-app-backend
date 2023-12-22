package com.company.riderental.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ReservationDao {

    private final DataSource dataSource;

    @Autowired
    public ReservationDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    // Method to add a new reservation
    public boolean addReservation(ReservationData reservation) throws SQLException {
        String sql = "INSERT INTO Reservation (PickupLocation, DropoffLocation, PickupDate, DropoffDate, vehicle_make, vehicle_model, Username) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, reservation.getPickupLocation());
            ps.setString(2, reservation.getDropoffLocation());

            // Check if dates are not null before converting to java.sql.Date
            if (reservation.getPickupDate() != null) {
                ps.setDate(3, Date.valueOf(reservation.getPickupDate()));
            } else {
                ps.setDate(3, null); // Or handle this case as you see fit
            }

            if (reservation.getDropoffDate() != null) {
                ps.setDate(4, Date.valueOf(reservation.getDropoffDate()));
            } else {
                ps.setDate(4, null); // Or handle this case as you see fit
            }

            ps.setString(5, reservation.getVehicleMake());
            ps.setString(6, reservation.getVehicleModel());
            ps.setString(7, reservation.getUsername());
            int affectedRows = ps.executeUpdate();
            return affectedRows > 0;
        }
    }

    public ReservationData getReservationById(int bookingID) throws SQLException {
        String sql = "SELECT * FROM Reservation WHERE BookingID = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, bookingID);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapRowToReservation(rs);
                }
            }
        }
        return null; // or throw an exception if preferred
    }

    public boolean updateReservation(ReservationData reservation) throws SQLException {
        String sql = "UPDATE Reservation SET PickupLocation = ?, DropoffLocation = ?, PickupDate = ?, DropoffDate = ?, vehicle_make = ?, vehicle_model = ?, Username = ? WHERE BookingID = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, reservation.getPickupLocation());
            ps.setString(2, reservation.getDropoffLocation());
            ps.setDate(3, Date.valueOf(reservation.getPickupDate()));
            ps.setDate(4, Date.valueOf(reservation.getDropoffDate()));
            ps.setString(5, reservation.getVehicleMake());
            ps.setString(6, reservation.getVehicleModel());
            ps.setString(7, reservation.getUsername());
            ps.setInt(8, reservation.getBookingID());

            int affectedRows = ps.executeUpdate();
            return affectedRows > 0;
        }
    }

    public boolean deleteReservation(int bookingID) throws SQLException {
        String sql = "DELETE FROM Reservation WHERE BookingID = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, bookingID);
            int affectedRows = ps.executeUpdate();
            return affectedRows > 0;
        }
    }

    public List<ReservationData> getAllReservations() throws SQLException {
        List<ReservationData> reservations = new ArrayList<>();
        String sql = "SELECT * FROM Reservation";
        try (Connection conn = dataSource.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                reservations.add(mapRowToReservation(rs));
            }
        }
        return reservations;
    }

    private ReservationData mapRowToReservation(ResultSet rs) throws SQLException {
        int bookingID = rs.getInt("BookingID");
        String pickupLocation = rs.getString("PickupLocation");
        String dropoffLocation = rs.getString("DropoffLocation");
        Date pickupDate = rs.getDate("PickupDate");
        Date dropoffDate = rs.getDate("DropoffDate");
        String vehicleMake = rs.getString("vehicle_make");
        String vehicleModel = rs.getString("vehicle_model");
        String username = rs.getString("Username");

        return new ReservationData(bookingID, pickupLocation, dropoffLocation,
                pickupDate.toLocalDate(), dropoffDate.toLocalDate(),
                vehicleMake, vehicleModel, username);
    }



}
