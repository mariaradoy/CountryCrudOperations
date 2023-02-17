package com.example.country.controller;

import com.example.country.model.Country;
import com.example.country.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/countries")
public class CountryController{
    @Autowired
    CountryService countryService;

    @GetMapping
    public List<Country> getAllCountry() throws Exception { return countryService.getAllCountries(); }

    @GetMapping("/{id}")
    public Country getCountryById(@PathVariable long id){
        return countryService.getCountryById(id);
    }
    @PostMapping
    public Country addCountry(@RequestBody Country country){
        return countryService.saveCountry(country);
    }

    @PutMapping
    public Country updateCountry(@RequestBody Country country){
        return countryService.updateCountry(country);
    }

    @DeleteMapping
    public void deleteAllCountries(){
        countryService.deleteAllCountries();
    }

    @DeleteMapping("/{id}")
    public void deleteCountryByID(@PathVariable long id){
        countryService.deleteById(id);
    }

}

