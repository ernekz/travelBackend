package com.backend.travel.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.travel.model.Continent;
import com.backend.travel.service.ContinentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/continents")
@RequiredArgsConstructor
public class ContinentController {

    private final ContinentService continentService;

    @GetMapping("/getAll")
    public List<Continent> getAllContinents() {
        return continentService.getAllContinents();
    }

}
