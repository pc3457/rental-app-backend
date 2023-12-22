package com.company.riderental.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dbo.RideshareData")
public class RideShareData {
    @Id
    private String id;
    private int hour;
    private int day;
    private int month;
    private String datetime;
    private String source;
    private String destination;
    private String productId;
    private String name;
    private double price;
    private int distance;
    private double surgeMultiplier;
    private double latitude;
    private double longitude;
    private double temperature;
    private String shortSummary;
    private double precipProbability;
    private double visibility;
    private double driverRating;
    private int riderRating;
    private double rating;

    // Constructor
    public RideShareData(String id, int hour, int day, int month, String datetime,
                         String source, String destination, String productId,
                         String name, double price, int distance, double surgeMultiplier,
                         double latitude, double longitude, double temperature,
                         String shortSummary, double precipProbability, double visibility,
                         double driverRating, int riderRating, double rating) {
        this.id = id;
        this.hour = hour;
        this.day = day;
        this.month = month;
        this.datetime = datetime;
        this.source = source;
        this.destination = destination;
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.distance = distance;
        this.surgeMultiplier = surgeMultiplier;
        this.latitude = latitude;
        this.longitude = longitude;
        this.temperature = temperature;
        this.shortSummary = shortSummary;
        this.precipProbability = precipProbability;
        this.visibility = visibility;
        this.driverRating = driverRating;
        this.riderRating = riderRating;
        this.rating = rating;
    }

    public RideShareData() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public double getSurgeMultiplier() {
        return surgeMultiplier;
    }

    public void setSurgeMultiplier(double surgeMultiplier) {
        this.surgeMultiplier = surgeMultiplier;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public String getShortSummary() {
        return shortSummary;
    }

    public void setShortSummary(String shortSummary) {
        this.shortSummary = shortSummary;
    }

    public double getPrecipProbability() {
        return precipProbability;
    }

    public void setPrecipProbability(double precipProbability) {
        this.precipProbability = precipProbability;
    }

    public double getVisibility() {
        return visibility;
    }

    public void setVisibility(double visibility) {
        this.visibility = visibility;
    }

    public double getDriverRating() {
        return driverRating;
    }

    public void setDriverRating(double driverRating) {
        this.driverRating = driverRating;
    }

    public int getRiderRating() {
        return riderRating;
    }

    public void setRiderRating(int riderRating) {
        this.riderRating = riderRating;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "RideShareData{" +
                "id='" + id + '\'' +
                ", hour=" + hour +
                ", day=" + day +
                ", month=" + month +
                ", datetime='" + datetime + '\'' +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", productId='" + productId + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", distance=" + distance +
                ", surgeMultiplier=" + surgeMultiplier +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", temperature=" + temperature +
                ", shortSummary='" + shortSummary + '\'' +
                ", precipProbability=" + precipProbability +
                ", visibility=" + visibility +
                ", driverRating=" + driverRating +
                ", riderRating=" + riderRating +
                ", rating=" + rating +
                '}';
    }
}

