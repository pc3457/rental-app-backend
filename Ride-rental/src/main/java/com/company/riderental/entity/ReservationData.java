package com.company.riderental.entity;

import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "dbo.Reservation")
public class ReservationData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BookingId")
    private int bookingID;
    @Column(name = "PickupLocation")
    private String pickupLocation;
    @Column(name = "DropoffLocation")
    private String dropoffLocation;
    @Column(name = "PickupDate")
    private LocalDate pickupDate;
    @Column(name = "DropoffDate")
    private LocalDate dropoffDate;
    @Column(name = "vehicle_make")
    private String vehicleMake;
    @Column(name = "vehicle_model")
    private String vehicleModel;
    @Column(name = "Username")
    private String username;

    public ReservationData() {
        // Default constructor
    }

    public ReservationData(int bookingID, String pickupLocation, String dropoffLocation, LocalDate pickupDate, LocalDate dropoffDate, String vehicleMake, String vehicleModel, String username) {
        this.bookingID = bookingID;
        this.pickupLocation = pickupLocation;
        this.dropoffLocation = dropoffLocation;
        this.pickupDate = pickupDate;
        this.dropoffDate = dropoffDate;
        this.vehicleMake = vehicleMake;
        this.vehicleModel = vehicleModel;
        this.username = username;
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public String getDropoffLocation() {
        return dropoffLocation;
    }

    public void setDropoffLocation(String dropoffLocation) {
        this.dropoffLocation = dropoffLocation;
    }

    public LocalDate getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(LocalDate pickupDate) {
        this.pickupDate = pickupDate;
    }

    public LocalDate getDropoffDate() {
        return dropoffDate;
    }

    public void setDropoffDate(LocalDate dropoffDate) {
        this.dropoffDate = dropoffDate;
    }

    public String getVehicleMake() {
        return vehicleMake;
    }

    public void setVehicleMake(String vehicleMake) {
        this.vehicleMake = vehicleMake;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "ReservationData{" +
                "bookingID=" + bookingID +
                ", pickupLocation='" + pickupLocation + '\'' +
                ", dropoffLocation='" + dropoffLocation + '\'' +
                ", pickupDate=" + pickupDate +
                ", dropoffDate=" + dropoffDate +
                ", vehicleMake='" + vehicleMake + '\'' +
                ", vehicleModel='" + vehicleModel + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
