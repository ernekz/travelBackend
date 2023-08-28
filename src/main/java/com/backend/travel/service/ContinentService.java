package com.backend.travel.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.backend.travel.model.Continent;
import com.backend.travel.repository.ContinentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ContinentService {

    private final ContinentRepository continentRepository;

    public List<Continent> getAllContinents() {
        List<Continent> continents = new ArrayList<Continent>();
        continentRepository.findAll().forEach(continents1 -> continents.add(continents1));
        return continents;
    }
}
