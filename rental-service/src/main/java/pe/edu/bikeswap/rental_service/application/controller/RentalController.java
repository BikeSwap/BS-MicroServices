package pe.edu.bikeswap.rental_service.application.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import pe.edu.bikeswap.rental_service.domain.model.Rental;
import pe.edu.bikeswap.rental_service.domain.service.RentalService;
import pe.edu.bikeswap.rental_service.entity.RentalEntity;

import java.net.URISyntaxException;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/rentals")
public class RentalController {
    private final RentalService rentalService;
    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }
    // URL: http://localhost:8080/api/v1/rentals
    // Method: POST
    @Transactional(readOnly = true)
    @PostMapping
    public ResponseEntity<Rental> createRental(@RequestBody Rental rental) {
        return new ResponseEntity<Rental>(rentalService.create(rental), HttpStatus.CREATED);
    }
    // URL: http://localhost:8080/api/v1/rentals
    // Method: GET
    @Transactional(readOnly = true)
    @GetMapping
    public ResponseEntity<List<Rental>> getAllRentals() {
        return new ResponseEntity<List<Rental>>(rentalService.getAll(), HttpStatus.OK);
    }
    // URL: http://localhost:8080/api/v1/rentals/{rentalId}
    // Method: GET
    @Transactional(readOnly = true)
    @GetMapping("/{rentalId}")
    public ResponseEntity<Rental> getRentalById(@PathVariable(name = "rentalId") Long rentalId) {
        return new ResponseEntity<Rental>(rentalService.getById(rentalId), HttpStatus.OK);
    }
    // URL: http://localhost:8080/api/v1/rentals/{rentalId}
    // Method: PUT
    @Transactional
    @PutMapping("/{rentalId}")
    public ResponseEntity<Rental> updateRentalById(@PathVariable(name = "rentalId") Long rentalId, @RequestBody Rental rental) {
        return new ResponseEntity<Rental>(rentalService.update(rentalId, rental), HttpStatus.OK);
    }
    // URL: http://localhost:8080/api/v1/rentals/{rentalId}
    // Method: DELETE
    @Transactional
    @DeleteMapping("/{rentalId}")
    public ResponseEntity<String> deleteRentalById(@PathVariable(name = "rentalId") Long rentalId) {
        rentalService.delete(rentalId);
        return new ResponseEntity<>("Bicycle deleted successfully", HttpStatus.OK);
    }
}
