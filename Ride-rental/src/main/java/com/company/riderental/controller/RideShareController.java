package com.company.riderental.controller;

import com.company.riderental.entity.RideShareData;
import com.company.riderental.service.RideShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/rideshare")
public class RideShareController {

    @Autowired
    private RideShareService rideShareService;

    @PostMapping
    public ResponseEntity<RideShareData> createRideShare(@RequestBody RideShareData rideShareData) throws SQLException {
        RideShareData createdData = rideShareService.createRideShare(rideShareData);
        return ResponseEntity.ok(createdData);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RideShareData> updateRideShare(@PathVariable String id, @RequestBody RideShareData rideShareData) throws SQLException {
        RideShareData updatedData = rideShareService.updateRideShare(id, rideShareData);
        return ResponseEntity.ok(updatedData);
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<RideShareData>> readRideShare() {
        List<RideShareData> rideShares = rideShareService.readRideShare();
        return ResponseEntity.ok(rideShares);
    }
}
