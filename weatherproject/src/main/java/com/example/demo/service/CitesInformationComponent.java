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
 * Компонент для получения списока с информацией о городах.
 */
@Component
public class CitesInformationComponent {

    private CityRepository repository;

    @Value("${jsonCityList}")
    private String jsonCityList;

    public CitesInformationComponent(CityRepository repository) {
        this.repository = repository;
    }

    /**
     * @return информацию о всех городах.
     */
    public List<City> getAllCity() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        byte[] mapData = Files.readAllBytes(Paths.get(jsonCityList));
        List<City> cities = mapper.readValue(mapData, ArrayList.class);
        return mapper.convertValue(cities, new TypeReference<List<City>>() { });
    }

    public JsonResponse getJsonResponse(String cityName) throws Exception {
        City city = repository.findByCityName(cityName);
        String stringUrl = String.format(
                "http://api.openweathermap.org/data/2.5/forecast?id=%d&cnt=16&APPID=83c377433a8a24e5ef0656303487a845",
                city.getId());
        URL jsonUrl = new URL(stringUrl);
        ObjectMapper mapper = new ObjectMapper();
        JsonResponse jsonResponse = mapper.readValue(jsonUrl, JsonResponse.class);
        return jsonResponse;
    }
}
