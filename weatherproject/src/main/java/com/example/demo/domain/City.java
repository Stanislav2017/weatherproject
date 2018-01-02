package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Класс с информацией о городе.
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class City {

    /**
     * Идентификатор города. */
    @Id
    private Long id;

    /**
     * Название города. */
    @JsonProperty("name")
    private String cityName;

    /**
     * Домен страны. */
    @JsonProperty("country")
    private String country;

    /**
     * Географические координаты города. */
    @Embedded
    @JsonProperty("coord")
    private Coordinates coordinates;
}
