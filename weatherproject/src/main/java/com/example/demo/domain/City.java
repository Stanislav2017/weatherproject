package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Information about the city.
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class City {

    /**
     * City ID. */
    @Id
    private Long id;

    /**
     * City name. */
    @JsonProperty("name")
    private String cityName;

    /**
     * Country Domain. */
    @JsonProperty("country")
    private String country;

    /**
     * City geo location. */
    @Embedded
    @JsonProperty("coord")
    private Coordinates coordinates;
}
