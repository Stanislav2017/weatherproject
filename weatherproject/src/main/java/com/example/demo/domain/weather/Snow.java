package com.example.demo.domain.weather;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Precipitation clout(snow).
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Snow {

    /**
     * Snow volume for the last 3 hours. */
    @JsonProperty("3h")
    private Double threeH;
}
