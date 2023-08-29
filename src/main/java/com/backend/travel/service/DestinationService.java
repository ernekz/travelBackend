package com.backend.travel.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.backend.travel.dto.DestinationRequest;
import com.backend.travel.dto.DestinationResult;
import com.backend.travel.model.Continent;
import com.backend.travel.model.Destination;
import com.backend.travel.repository.ContinentRepository;
import com.backend.travel.repository.DestinationRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class DestinationService {

    private final DestinationRepository destinationRepository;
    private final ContinentRepository continentRepository;

    public void createDestination(DestinationRequest destinationRequest) {

        Continent continent = continentRepository.findById(destinationRequest.getContinentId())
                .orElseThrow(() -> new EntityNotFoundException(
                        "Continent with id " + destinationRequest.getContinentId() + " not found"));
        Destination destination = Destination.builder()
                .createdBy(destinationRequest.getCreatedBy())
                .people(destinationRequest.getPeople())
                .continent(continent)
                .country(destinationRequest.getCountry())
                .city(destinationRequest.getCity())
                .description(destinationRequest.getDescription())
                .leavingDate(destinationRequest.getLeavingDate())
                .returningDate(destinationRequest.getReturningDate())
                .imageUrl(destinationRequest.getImageUrl())
                .build();

        destinationRepository.save(destination);
        log.info("Destination {} is created", destination.getId());
    }

    public Optional<Destination> getDestination(long id) {
        return destinationRepository.findById(id);
    }

    public List<DestinationResult> getAllDestinations() {

        List<DestinationResult> destinationResults = new ArrayList<>();

        List<Destination> destinations = destinationRepository.findAll();

        for (Destination destination : destinations) {
            DestinationResult dto = new DestinationResult();

            dto.setId(destination.getId());
            dto.setContinentId(destination.getContinent().getId());
            dto.setPeople(destination.getPeople());
            dto.setCountry(destination.getCountry());
            dto.setCity(destination.getCity());
            dto.setLeavingDate(destination.getLeavingDate());
            dto.setReturningDate(destination.getReturningDate());
            dto.setDescription(destination.getDescription());
            dto.setCreatedBy(destination.getCreatedBy());
            dto.setImageUrl(destination.getImageUrl());
            destinationResults.add(dto);

        }
        return destinationResults;
    }

    public List<DestinationResult> getDestinationsByContinentId(Integer continendId) {

        List<Destination> destinations = destinationRepository.findByContinentId(continendId);

        List<DestinationResult> destinationResults = destinations.stream().map(this::mapToDestinationResult)
                .collect(Collectors.toList());

        return destinationResults;

    }

    private DestinationResult mapToDestinationResult(Destination destination) {
        DestinationResult result = new DestinationResult();
        result.setId(destination.getId());
        result.setContinentId(destination.getContinent().getId());
        result.setPeople(destination.getPeople());
        result.setCountry(destination.getCountry());
        result.setCity(destination.getCity());
        result.setLeavingDate(destination.getLeavingDate());
        result.setReturningDate(destination.getReturningDate());
        result.setDescription(destination.getDescription());
        result.setCreatedBy(destination.getCreatedBy());
        result.setImageUrl(destination.getImageUrl());
        return result;
    }
}
