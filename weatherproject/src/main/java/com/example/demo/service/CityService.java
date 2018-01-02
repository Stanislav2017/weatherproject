package com.example.demo.service;

import com.example.demo.domain.City;
import com.example.demo.repository.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    private CityRepository repository;

    public CityService(CityRepository repository) {
        this.repository = repository;
    }

    public City findCityByName(String cityName) {
        return repository.findByCityName(cityName);
    }

    public void save(List<City> cities) {
        repository.save(cities);
    }

    public void save(City city) {
        repository.save(city);
    }

    public Iterable<City> getAllCity() {
        return repository.findAll();
    }
}
