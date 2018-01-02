package com.example.demo;

import com.example.demo.domain.City;
import com.example.demo.service.CitesInformationComponent;
import com.example.demo.service.CityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class WeatherApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(CitesInformationComponent component, CityService service){
		return args -> {
			try {
				List<City> cities = component.getAllCity();
				service.save(cities);
				System.out.println("Cities Saved!");
			} catch (IOException e){
				System.out.println("Unable to save cities: " + e.getMessage());
			}
		};
	}
}
