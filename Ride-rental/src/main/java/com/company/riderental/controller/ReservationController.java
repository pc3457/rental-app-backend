package com.company.riderental.controller;

import com.company.riderental.entity.ReservationData;
import com.company.riderental.service.ReservationService;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/get")
    public ResponseEntity<ReservationData> getReservation(@RequestParam int bookingID) throws SQLException {
        ReservationData reservation = reservationService.getReservationById(bookingID);
        if (reservation == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(reservation);
    }

    @PostMapping("/create")
    public ResponseEntity<ReservationData> createReservation(@RequestBody ReservationData reservationData) throws SQLException {
        System.out.println("Received data: " + reservationData);
        boolean isCreated = reservationService.addReservation(reservationData);
        if (!isCreated) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(reservationData); // Consider returning the updated reservation data
    }

    @PutMapping("/update/{bookingID}")
    public ResponseEntity<ReservationData> updateReservation(@PathVariable int bookingID, @RequestBody ReservationData reservationData) throws SQLException {
        reservationData.setBookingID(bookingID);
        boolean isUpdated = reservationService.updateReservation(reservationData);
        if (!isUpdated) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(reservationData);
    }

    @DeleteMapping("/delete/{bookingID}")
    public ResponseEntity<Void> deleteReservation(@PathVariable int bookingID) throws SQLException {
        boolean isDeleted = reservationService.deleteReservation(bookingID);
        if (!isDeleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<ReservationData>> getAllReservations() throws SQLException {
        List<ReservationData> reservations = reservationService.getAllReservations();
        return ResponseEntity.ok(reservations);
    }
}
