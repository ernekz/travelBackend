package com.backend.travel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.travel.model.Destination;

public interface DestinationRepository extends JpaRepository<Destination, Long> {

}
