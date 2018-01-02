package com.example.demo.controller;

import com.example.demo.domain.City;
import com.example.demo.domain.weather.JsonResponse;
import com.example.demo.service.CitesInformationComponent;
import com.example.demo.service.CityService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class CityController {

    private CitesInformationComponent component;
    private CityService service;

    public CityController(CitesInformationComponent component, CityService service) {
        this.component = component;
        this.service = service;
    }

    @RequestMapping("/cities")
    public Iterable<City> list() {
        return service.getAllCity();
    }

    @RequestMapping(value = { "/city/{city_name}" }, method = RequestMethod.GET)
    public City getCity(@PathVariable("city_name") String cityName) {
        return service.findCityByName(cityName);
    }

    @RequestMapping(value = { "/weather/city/{city_name}" }, method = RequestMethod.GET)
    public JsonResponse getJsonResponse(@PathVariable("city_name") String cityName) throws Exception {
        return component.getJsonResponse(cityName);
    }
}
