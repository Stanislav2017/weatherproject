package com.example.demo.controller;

import com.example.demo.domain.City;
import com.example.demo.domain.weather.JsonResponse;
import com.example.demo.service.CitesInformationComponent;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class WeatherForecastController {

    private CitesInformationComponent component;

    public WeatherForecastController(CitesInformationComponent component) {
        this.component = component;
    }

    @RequestMapping("/cities")
    public Iterable<City> list() throws Exception {
        return component.getCityListFromJson();
    }

    @RequestMapping(
            value = {"/weatherforecast/cityname/{city_name},{country_code}/amountdays/{amount_days}"},
            method = RequestMethod.GET)
    public JsonResponse getWeatherForecast(
            @PathVariable("city_name") String cityName,
            @PathVariable("country_code") String countryCode,
            @PathVariable("amount_days") Integer amountDays)
            throws Exception
    {
        return component.getWeatherForecastBy(cityName, countryCode, amountDays);
    }

    @RequestMapping(
            value = {"/weatherforecast/cityid/{city_id}/amountdays/{amount_days}"},
            method = RequestMethod.GET)
    public JsonResponse getWeatherForecast(
            @PathVariable("city_id") Integer cityId,
            @PathVariable("amount_days") Integer amountDays)
            throws Exception
    {
        return component.getWeatherForecastBy(cityId, amountDays);
    }

    @RequestMapping(
            value = {"/weatherforecast/longitude/{longitude}/latitude/{latitude}/amountdays/{amount_days}"},
            method = RequestMethod.GET)
    public JsonResponse getWeatherForecast(
            @PathVariable("longitude") Double longitude,
            @PathVariable("latitude") Double latitude,
            @PathVariable("amount_days") Integer amountDays)
            throws Exception
    {
        return component.getWeatherForecastBy(longitude, latitude, amountDays);
    }
}
