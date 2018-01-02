package com.example.demo.domain.weather;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Meteorological indicators.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MeteorologicalData {

    /**
     * Temperature. Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit. */
    @JsonProperty("temp")
    private Double temperature;

    /**
     * Minimum temperature at the moment. This is deviation from current temp that is possible for large cities
     * and megalopolises geographically expanded (use these parameter optionally). */
    @JsonProperty("temp_min")
    private Double temperatureMin;

    /**
     *  Maximum temperature at the moment. This is deviation from current temp that is possible for large cities
     *  and megalopolises geographically expanded (use these parameter optionally). */
    @JsonProperty("temp_max")
    private Double temperatureMax;

    /**
     * Atmospheric pressure (on the sea level, if there is no sea_level or grnd_level data), hPa. */
    @JsonProperty("pressure")
    private Double pressure;

    /**
     * Atmospheric pressure on the sea level, hPa. */
    @JsonProperty("sea_level")
    private Double pressureSeaLevel;

    /**
     * Atmospheric pressure on the ground level, hPa. */
    @JsonProperty("grnd_level")
    private Double pressureGroundLevel;

    /**
     * Humidity, %. */
    @JsonProperty("humidity")
    private Double humidity;

    /**
     * Temperature coefficient. */
    @JsonProperty("temp_kf")
    private Double temperatureCoefficient;
}
