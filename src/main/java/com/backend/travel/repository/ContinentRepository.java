package com.backend.travel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.travel.model.Continent;

public interface ContinentRepository extends JpaRepository<Continent, Integer> {

}
