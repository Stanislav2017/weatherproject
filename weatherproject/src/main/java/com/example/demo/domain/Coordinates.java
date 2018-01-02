package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

/**
 * City geo location.
 */
@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
class Coordinates {

    /**
     * Longitude. */
    @JsonProperty("lon")
    private double longitude;

    /**
     * Latitude. */
    @JsonProperty("lat")
    private double latitude;
}
