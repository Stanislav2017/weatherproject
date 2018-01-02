package com.example.demo.domain.weather;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MeteorologicalData {

    @JsonProperty("temp")
    private Double temperature;

    @JsonProperty("temp_min")
    private Double temperatureMin;

    @JsonProperty("temp_max")
    private Double temperatureMax;

    @JsonProperty("pressure")
    private Double pressure;

    @JsonProperty("sea_level")
    private Double pressureSeaLevel;

    @JsonProperty("grnd_level")
    private Double pressureGroundLevel;

    @JsonProperty("humidity")
    private Double humidity;

    @JsonProperty("temp_kf")
    private Double temperatureCoefficient;
}
