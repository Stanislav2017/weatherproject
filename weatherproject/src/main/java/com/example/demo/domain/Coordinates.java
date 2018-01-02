package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

/**
 * Географические координаты.
 */
@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
class Coordinates {

    /**
     * Долгота. */
    @JsonProperty("lon")
    private double longitude;

    /**
     * Широта. */
    @JsonProperty("lat")
    private double latitude;
}
