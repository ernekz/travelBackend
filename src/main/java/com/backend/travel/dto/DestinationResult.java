package com.backend.travel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DestinationResult {

    private Long id;
    private Integer continentId;
    private Long people;
    private String country;
    private String city;
    private String leavingDate;
    private String returningDate;
    private String description;
    private Long createdBy;
    private String imageUrl;
}
