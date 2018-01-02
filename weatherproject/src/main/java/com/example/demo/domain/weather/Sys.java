package com.example.demo.domain.weather;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *  Internal parameter.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sys {

    @JsonProperty("pod")
    private String pod;
}
