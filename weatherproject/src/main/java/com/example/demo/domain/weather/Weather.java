package com.example.demo.domain.weather;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Weather {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("main")
    private String precipitation;

    @JsonProperty("description")
    private String description;

    @JsonProperty("icon")
    private String icon;
}
