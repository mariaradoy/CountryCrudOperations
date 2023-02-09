package com.example.country.controller;

import com.example.country.model.Country;
import com.example.country.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CountryController{
    @Autowired
    CountryRepository countryRepository;

    @GetMapping("/countries")
    public ResponseEntity<List<Country>> getAllCountries(@RequestParam(required = false) String name){
        try {
            List<Country> countries = new ArrayList<>();

            if (name == null)
                countryRepository.findAll().forEach(countries::add);
            else
                countryRepository.findByName(name).forEach(countries::add);

            if (countries.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(countries, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/countries/{id}")
    public ResponseEntity<Country> getCountryById(@PathVariable("id") long id) {
        Optional<Country> countryData = countryRepository.findById(id);

        if (countryData.isPresent()) {
            return new ResponseEntity<>(countryData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/countries")
    public ResponseEntity<Country> createCountry(@RequestBody Country country) {
        try {
            Country _country = countryRepository
                    .save(new Country(country.getName(), country.getPopulation()));
            return new ResponseEntity<>(_country, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/countries/{id}")
    public ResponseEntity<Country> updateCountry(@PathVariable("id") long id, @RequestBody Country country) {
        Optional<Country> tutorialData = countryRepository.findById(id);

        if (tutorialData.isPresent()) {
            Country _country = tutorialData.get();
            _country.setName(country.getName());
            _country.setPopulation(country.getPopulation());
            return new ResponseEntity<>(countryRepository.save(_country), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/countries/{id}")
    public ResponseEntity<HttpStatus> deleteCountry(@PathVariable("id") long id) {
        try {
            countryRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/countries")
    public ResponseEntity<HttpStatus> deleteAllCountries() {
        try {
            countryRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}

