package com.example.country.controller;

import com.example.country.model.Country;
import com.example.country.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping
public class CountryController{
    @Autowired
    CountryService countryService;
    @GetMapping("/countries")
    public List<Country> getAllCountry() { return countryService.getAllCountries(); }

    @GetMapping("/countries/{id}")
    public Country getCountryById(@PathVariable long id){
        return countryService.getCountryById(id);
    }
    @PostMapping("/countries")
    public Country addCountry(@RequestBody Country country){
        return countryService.saveCountry(country);
    }

    @PutMapping("/countries")
    public Country updateCountry(@RequestBody Country country){
        return countryService.updateCountry(country);
    }

    @DeleteMapping("/countries/{id}")
    public void deleteCountryByID(@PathVariable long countryId){
        countryService.deleteById(countryId);
    }

}

