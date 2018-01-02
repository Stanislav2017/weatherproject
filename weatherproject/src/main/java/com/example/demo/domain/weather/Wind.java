package com.example.demo.domain.weather;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Characteristics of the wind.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Wind {

    /**
     * Wind speed. Unit Default: meter/sec, Metric: meter/sec, Imperial: miles/hour. */
    @JsonProperty("speed")
    private Double speed;

    /**
     * Wind direction, degrees (meteorological). */
    @JsonProperty("deg")
    private Double degrees;
}
