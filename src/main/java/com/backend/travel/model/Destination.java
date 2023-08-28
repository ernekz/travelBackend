package com.backend.travel.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "t_destination")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Destination {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "continentId")
    private Continent continent;

    @Column(name = "people")
    private Long people;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "leavingDate")
    private String leavingDate;

    @Column(name = "returningDate")
    private String returningDate;

    @Column(name = "description")
    private String description;

    @Column(name = "createdBy")
    private Long createdBy;

    @Column(name = "imageUrl")
    private String imageUrl;

}
