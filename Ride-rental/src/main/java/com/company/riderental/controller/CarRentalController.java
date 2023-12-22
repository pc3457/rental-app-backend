package com.company.riderental.controller;

import com.company.riderental.entity.CarRentalData;
import com.company.riderental.service.CarRentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/carrental")
public class CarRentalController {

    @Autowired
    private CarRentalService carRentalService;

    // POST: Create a new car rental record
    @PostMapping("/add")
    public ResponseEntity<CarRentalData> createCarRental(@RequestBody CarRentalData carRentalData) {
        CarRentalData createdData = carRentalService.createCarRental(carRentalData);
        return ResponseEntity.ok(createdData);
    }

    // GET: Read all car rental records
    @GetMapping("/get/all")
    public ResponseEntity<List<CarRentalData>> getAllCarRentals() {
        List<CarRentalData> carRentals = carRentalService.getAllCarRentals();
        return ResponseEntity.ok(carRentals);
    }

    @GetMapping("/search")
    public ResponseEntity<List<CarRentalData>> searchCarRentals(
            @RequestParam String vehicleMake,
            @RequestParam String vehicleModel,
            @RequestParam String city) {

        List<CarRentalData> carRentals = carRentalService.findCarRentalsByMakeAndModel(vehicleMake, vehicleModel, city);
        return ResponseEntity.ok(carRentals);
    }

    // PUT: Update an existing car rental record
    @PutMapping("/update/{vehicle_registration}")
    public ResponseEntity<CarRentalData> updateCarRental(@PathVariable String vehicleReg, @RequestBody CarRentalData carRentalData) {
        carRentalData.setVehicleReg(vehicleReg);
        CarRentalData updatedData = carRentalService.updateCarRental(carRentalData);
        return ResponseEntity.ok(updatedData);
    }

    // DELETE: Delete a car rental record
    @DeleteMapping("/delete/{vehicle_registration}")
    public ResponseEntity<Void> deleteCarRental(@PathVariable String vehicleReg) {
        carRentalService.deleteCarRental(vehicleReg);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/unique-makes")
    public ResponseEntity<List<String>> getUniqueVehicleMakes() {
        try {
            List<String> makes = carRentalService.getUniqueVehicleMakes();
            return ResponseEntity.ok(makes);
        } catch (Exception e) {
            // You can log the exception and return an appropriate error response
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/unique-models")
    public ResponseEntity<List<String>> getUniqueVehicleModels(@RequestParam String vehicleMake) {
        try {
            List<String> models = carRentalService.getUniqueVehicleModels(vehicleMake);
            return ResponseEntity.ok(models);
        } catch (Exception e) {
            // You can log the exception and return an appropriate error response
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/unique-locations")
    public ResponseEntity<List<String>> getUniqueVehicleLocations() {
        try {
            List<String> locations = carRentalService.getUniqueVehicleLocations();
            return ResponseEntity.ok(locations);
        } catch (Exception e) {
            // Here, you would handle the exception appropriately.
            // For example, you might log the error and return an error response.
            return ResponseEntity.status(500).build(); // Simple internal server error response for example purposes
        }
    }




}
