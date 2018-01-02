package com.example.demo.domain.weather;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Precipitation clout(rain).
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rain {

    /**
     * Rain volume for the last 3 hours. */
    @JsonProperty("3h")
    private Double threeH;
}
