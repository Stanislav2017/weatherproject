package com.example.demo.domain.weather;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * More info Weather condition codes.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Weather {

    /**
     * Weather condition id. */
    @JsonProperty("id")
    private Integer id;

    /**
     * Group of weather parameters (Rain, Snow, Extreme etc.). */
    @JsonProperty("main")
    private String precipitation;

    /**
     * Weather condition within the group. */
    @JsonProperty("description")
    private String description;

    /**
     * Weather icon id. */
    @JsonProperty("icon")
    private String icon;
}
