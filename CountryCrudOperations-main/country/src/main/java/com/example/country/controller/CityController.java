package com.example.country.controller;

import com.example.country.model.City;
import com.example.country.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {
    @Autowired
    CityService cityService;

    @GetMapping
    public List<City> getAllCities() throws Exception{ return cityService.getAllCities(); }

    @GetMapping("/{id}")
    public City getCityById(@PathVariable long id) { return cityService.getCityById(id); }

    @PostMapping
    public City addCity(@RequestBody City city) { return cityService.saveCity(city);}

    @PutMapping
    public City updateCity(@RequestBody City city) { return cityService.updateCity(city); }

    @DeleteMapping
    public void deleteAllCountries(){
        cityService.deleteAllCities();
    }

    @DeleteMapping("/{id}")
    public void deleteCountryByID(@PathVariable long id){
        cityService.deleteById(id);
    }


}
