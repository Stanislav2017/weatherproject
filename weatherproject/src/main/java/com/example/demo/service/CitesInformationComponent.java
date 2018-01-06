package com.example.demo.service;

import com.example.demo.domain.City;
import com.example.demo.domain.weather.JsonResponse;
import com.example.demo.repository.CityRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NonNull;
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

    @Value("${url.jsonByCityName}")
    private String jsonByCityName;

    @Value("${url.jsonByCityId}")
    private String jsonByCityId;

    @Value("${url.jsonByGeographicCoordinats}")
    private String jsonByGeographicCoordinats;

    public CitesInformationComponent(CityRepository repository) {
        this.repository = repository;
    }

    /**
     * @return information about all cities.
     */
    public List<City> getCityListFromJson() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        byte[] mapData = Files.readAllBytes(Paths.get(jsonCityList));
        List<City> cities = mapper.readValue(mapData, ArrayList.class);
        return mapper.convertValue(cities, new TypeReference<List<City>>() { });
    }

    /**
     * @param cityName city name.
     * @param countryCode country domain.
     * @param amountDays number of lines returned by this API call.
     * @return json response as java object.
     * @throws Exception any unexpected exceptions.
     */
    public JsonResponse getWeatherForecastBy(
            final @NonNull String cityName,
            final @NonNull String countryCode,
            final @NonNull Integer amountDays)
            throws Exception
    {
        String stringUrl = String.format(this.jsonByCityName, cityName, countryCode, amountDays);
        JsonResponse jsonResponse = this.getJsonResponse(stringUrl);
        return jsonResponse;
    }

    /**
     * @param cityID city ID.
     * @param amountDays number of lines returned by this API call.
     * @return json response as java object.
     * @throws Exception any unexpected exceptions.
     */
    public JsonResponse getWeatherForecastBy(
            final @NonNull Integer cityID,
            final @NonNull Integer amountDays)
            throws Exception
    {
        String stringUrl = String.format(this.jsonByCityId, cityID, amountDays);
        JsonResponse jsonResponse = this.getJsonResponse(stringUrl);
        return jsonResponse;
    }

    /**
     * @param longitude longitude.
     * @param latitude latitude.
     * @param amountDays number of lines returned by this API call.
     * @return json response as java object.
     * @throws Exception any unexpected exceptions.
     */
    public JsonResponse getWeatherForecastBy(
            final @NonNull Double longitude,
            final @NonNull Double latitude,
            final @NonNull Integer amountDays)
            throws Exception
    {
        String stringUrl = String.format(this.jsonByGeographicCoordinats, longitude, latitude, amountDays);
        JsonResponse jsonResponse = this.getJsonResponse(stringUrl);
        return jsonResponse;
    }

    /**
     * @param url base url.
     * @return json response as java object.
     * @throws Exception any unexpected exceptions.
     */
    private JsonResponse getJsonResponse(String url) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        URL jsonUrl = new URL(url);
        JsonResponse jsonResponse = mapper.readValue(jsonUrl, JsonResponse.class);
        return jsonResponse;
    }
}
