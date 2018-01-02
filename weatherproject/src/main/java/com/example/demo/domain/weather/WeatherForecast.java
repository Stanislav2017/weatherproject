package com.example.demo.domain.weather;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Weather forecast.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherForecast {

    /**
     * Time of data calculation, unix, UTC. */
    @JsonProperty("dt")
    private Long timeDataForecasted;

    /**
     * Meteorological evidence. */
    @JsonProperty("main")
    private MeteorologicalData meteorologicalData;

    /**
     * More info Weather condition codes. */
    @JsonProperty("weather")
    private List<Weather> weather;

    /**
     * Cloud percentages. */
    @JsonProperty("clouds")
    private Clouds clouds;

    /**
     * Characteristics of the wind. */
    @JsonProperty("wind")
    private Wind wind;

    /**
     * Precipitation clout(rain). */
    @JsonProperty("rain")
    private Rain rain;

    /**
     * Precipitation clout(snow). */
    @JsonProperty("snow")
    private Snow snow;

    /**
     *  Internal parameter. */
    @JsonProperty("sys")
    private Sys sys;

    /**
     * Date in string format. */
    @JsonProperty("dt_txt")
    private String dateTxt;
}
