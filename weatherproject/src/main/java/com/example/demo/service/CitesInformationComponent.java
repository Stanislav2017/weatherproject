package com.example.demo.service;

import com.example.demo.domain.City;
import com.example.demo.domain.weather.JsonResponse;
import com.example.demo.repository.CityRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Component for obtaining a list with information on cities.
 */
@Component
public class CitesInformationComponent {

    private CityRepository repository;

    @Value("${jsonCityList}")
    private String jsonCityList;

    @Value("${baseUrl}")
    private String baseUrl;

    public CitesInformationComponent(CityRepository repository) {
        this.repository = repository;
    }

    /**
     * @return information about all cities.
     */
    public List<City> getAllCity() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        byte[] mapData = Files.readAllBytes(Paths.get(jsonCityList));
        List<City> cities = mapper.readValue(mapData, ArrayList.class);
        return mapper.convertValue(cities, new TypeReference<List<City>>() { });
    }

    public JsonResponse getJsonResponse(String cityName) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        City city = repository.findByCityName(cityName);
        String stringUrl = String.format(this.baseUrl, city.getId());
        URL jsonUrl = new URL(stringUrl);
        JsonResponse jsonResponse = mapper.readValue(jsonUrl, JsonResponse.class);
        return jsonResponse;
    }
}
