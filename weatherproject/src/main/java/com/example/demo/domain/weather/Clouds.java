package com.example.demo.domain.weather;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Cloud percentages.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Clouds {

    /**
     * Cloudiness, %. */
    @JsonProperty("all")
    private Integer all;
}
