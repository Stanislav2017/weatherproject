package com.example.demo.domain.weather;

import com.example.demo.domain.City;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JsonResponse {

    /**
     * Internal parameter. */
    @JsonProperty("cod")
    private Integer statusCode;

    /**
     * Internal parameter. */
    @JsonProperty("message")
    private Double message;

    /**
     * Number of lines returned by this API call. */
    @JsonProperty("cnt")
    private Integer numberDaysWeather;

    /**
     * Weather Forecasts. */
    @JsonProperty("list")
    private List<WeatherForecast> weatherForecasts;

    /**
     * Information about the city. */
    @JsonProperty("city")
    private City city;
}
