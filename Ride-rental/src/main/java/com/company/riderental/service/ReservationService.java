package com.company.riderental.service;

import com.company.riderental.entity.CustomerDao;
import com.company.riderental.entity.CustomerData;
import com.company.riderental.entity.ReservationDao;
import com.company.riderental.entity.ReservationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
@Service
public class ReservationService {

    @Autowired
    private final ReservationDao reservationDao;

    @Autowired
    private final CustomerDao customerDao;


    public ReservationService(ReservationDao reservationDao, CustomerDao customerDao) {
        this.reservationDao = reservationDao;
        this.customerDao = customerDao;
    }

    public ReservationData getReservationById(int bookingID) throws SQLException {
        return reservationDao.getReservationById(bookingID);
    }

    public boolean addReservation(ReservationData reservationData) throws SQLException {
        // Check if the customer exists
        CustomerData customer = customerDao.getCustomerByUsername(reservationData.getUsername());
        if (customer == null) {
            // Handle the case where the customer does not exist
            // For example, throw an exception or return a specific error response
            throw new RuntimeException("Customer with username " + reservationData.getUsername() + " does not exist.");
        }

        return reservationDao.addReservation(reservationData);
    }

    public boolean updateReservation(ReservationData reservationData) throws SQLException {
        // Similar check as in addReservation
        CustomerData customer = customerDao.getCustomerByUsername(reservationData.getUsername());
        if (customer == null) {
            throw new RuntimeException("Customer with username " + reservationData.getUsername() + " does not exist.");
        }

        return reservationDao.updateReservation(reservationData);
    }

    public boolean deleteReservation(int bookingID) throws SQLException {
        return reservationDao.deleteReservation(bookingID);
    }

    public List<ReservationData> getAllReservations() throws SQLException {
        return reservationDao.getAllReservations();
    }



}
