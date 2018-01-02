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

    @JsonProperty("cod")
    private Integer statusCode;

    @JsonProperty("message")
    private Double message;

    @JsonProperty("cnt")
    private Integer numberDaysWeather;

    @JsonProperty("list")
    private List<WeatherForecast> weatherForecasts;

    @JsonProperty("city")
    private City city;

}
