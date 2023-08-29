package com.backend.travel.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.backend.travel.dto.DestinationRequest;
import com.backend.travel.dto.DestinationResult;
import com.backend.travel.model.Destination;
import com.backend.travel.service.DestinationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/destination")
@RequiredArgsConstructor
public class DestinationController {

    private final DestinationService destinationService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Boolean createDestination(
            @RequestBody DestinationRequest destinationRequest) {
        destinationService.createDestination(destinationRequest);
        return true;
    }

    @GetMapping("/get/{id}")
    public Optional<Destination> getDestination(@PathVariable Long id) {
        // Some problem with PathVariable need to fix it so i can get the result by ID
        return destinationService.getDestination(id);
    }

    @GetMapping("/getAll")
    public List<DestinationResult> getAllDestinations() {
        return destinationService.getAllDestinations();
    }

    @GetMapping("/getByContinent/{continentId}")
    public ResponseEntity<List<DestinationResult>> getDestinationByContinent(@PathVariable Integer continentId) {
        List<DestinationResult> destinationResults = destinationService.getDestinationsByContinentId(continentId);

        return ResponseEntity.ok(destinationResults);
    }

}
