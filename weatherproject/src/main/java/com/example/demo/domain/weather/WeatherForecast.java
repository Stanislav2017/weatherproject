package com.example.demo.domain.weather;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherForecast {

    @JsonProperty("dt")
    private Long timeDataForecasted;

    @JsonProperty("main")
    private MeteorologicalData meteorologicalData;

    @JsonProperty("weather")
    private List<Weather> weather;

    @JsonProperty("clouds")
    private Clouds clouds;

    @JsonProperty("wind")
    private Wind wind;

    @JsonProperty("rain")
    private Rain rain;

    @JsonProperty("snow")
    private Snow snow;

    @JsonProperty("sys")
    private Sys sys;

    @JsonProperty("dt_txt")
    private String dateTxt;
}
