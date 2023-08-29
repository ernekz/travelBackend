package com.backend.travel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.travel.model.Destination;

public interface DestinationRepository extends JpaRepository<Destination, Long> {

    List<Destination> findByContinentId(Integer continentId);
}
