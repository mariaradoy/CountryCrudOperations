package com.example.country.controller;

import com.example.country.model.City;
import com.example.country.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping
public class CityController {
    @Autowired
    CityService cityService;

    @GetMapping("/countries/{countryId}/cities")
    public List<City> getAllCitiesByCountryId(@PathVariable (value = "countryId") Long countryId){
        return  cityService.getAllCitiesByCountryId(countryId);
    }

    @PostMapping("/countries/{countryId}/cities")
    public City addCity(@PathVariable (value = "countryId") long countryId, @RequestBody City city) { return cityService.saveCity(countryId, city);}

    @PutMapping("/countries/{countryId}/cities")
    public City updateCity(@RequestBody City city) { return cityService.updateCity(city); }

    @DeleteMapping("/countries/{countryId}/cities/{cityId}")
    public void deleteCountryByID(@PathVariable long cityId){
        cityService.deleteById(cityId);
    }


}
