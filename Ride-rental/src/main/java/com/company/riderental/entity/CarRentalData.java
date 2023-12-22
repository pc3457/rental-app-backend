package com.company.riderental.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="dbo.CarRental")
public class CarRentalData {
    private String fuelType;
    private double rating;
    private int renterTripsTaken;
    private int reviewCount;
    @Column(name = "location_city")
    private String city;
    @Column(name = "location_country")
    private String country;
    @Column(name = "location_latitude")
    private double latitude;
    @Column(name = "location_longitude")
    private double longitude;
    @Column(name = "location_state")
    private String state;
    @Column(name = "owner_id")
    private long ownerId;
    @Column(name = "rate_daily")
    private int rateDaily;
    @Column(name = "vehicle_make")
    private String make;
    @Column(name = "vehicle_model")
    private String model;
    @Column(name = "vehicle_type")
    private String type;
    @Column(name = "vehicle_year")
    private int year;
    @Column(name = "airportcity")
    private String airportCity;

    @Id
    @Column(name="vehicle_registration")
    private String vehicleReg;

    // Constructor
    public CarRentalData(String fuelType, double rating, int renterTripsTaken, int reviewCount,
                         String city, String country, double latitude, double longitude,
                         String state, long ownerId, int rateDaily, String make,
                         String model, String type, int year, String airportCity, String vehicleReg) {
        this.fuelType = fuelType;
        this.rating = rating;
        this.renterTripsTaken = renterTripsTaken;
        this.reviewCount = reviewCount;
        this.city = city;
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
        this.state = state;
        this.ownerId = ownerId;
        this.rateDaily = rateDaily;
        this.make = make;
        this.model = model;
        this.type = type;
        this.year = year;
        this.airportCity = airportCity;
        this.vehicleReg = vehicleReg;
    }

    public CarRentalData() {
    }

    public String getVehicleReg() {
        return vehicleReg;
    }

    public void setVehicleReg(String vehicleReg) {
        this.vehicleReg = vehicleReg;
    }

    // Getters
    public String getFuelType() {
        return fuelType;
    }

    public double getRating() {
        return rating;
    }

    public int getRenterTripsTaken() {
        return renterTripsTaken;
    }

    public int getReviewCount() {
        return reviewCount;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getState() {
        return state;
    }

    public long getOwnerId() {
        return ownerId;
    }

    public int getRateDaily() {
        return rateDaily;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getType() {
        return type;
    }

    public int getYear() {
        return year;
    }

    public String getAirportCity() {
        return airportCity;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setRenterTripsTaken(int renterTripsTaken) {
        this.renterTripsTaken = renterTripsTaken;
    }

    public void setReviewCount(int reviewCount) {
        this.reviewCount = reviewCount;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }

    public void setRateDaily(int rateDaily) {
        this.rateDaily = rateDaily;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setAirportCity(String airportCity) {
        this.airportCity = airportCity;
    }

    @Override
    public String toString() {
        return "CarRentalData{" +
                "fuelType='" + fuelType + '\'' +
                ", rating=" + rating +
                ", renterTripsTaken=" + renterTripsTaken +
                ", reviewCount=" + reviewCount +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", state='" + state + '\'' +
                ", ownerId=" + ownerId +
                ", rateDaily=" + rateDaily +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", type='" + type + '\'' +
                ", year=" + year +
                ", airportCity='" + airportCity + '\'' +
                ", vehicleReg='" + vehicleReg + '\'' +
                '}';
    }
}
