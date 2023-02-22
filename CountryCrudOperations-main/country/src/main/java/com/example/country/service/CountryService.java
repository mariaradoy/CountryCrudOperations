package com.example.country.service;

import com.example.country.model.Country;
import com.example.country.repository.CityRepository;
import com.example.country.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CountryService {
    @Autowired
    CountryRepository countryRepository;

    @Autowired
    CityService cityService;
    public Country saveCountry(Country country){
        return countryRepository.save(country);
    }
    public List<Country> getAllCountries(){
        return countryRepository.findAll();
    }

    public Country getCountryById(long countryId) {
        return countryRepository.findById(countryId).get();
    }

    public Country updateCountry(Country country) {
        Country updatedCountry = countryRepository.findById(country.getId()).get();
        updatedCountry.setName(country.getName());
        updatedCountry.setPopulation(country.getPopulation());
        return countryRepository.save(updatedCountry);
    }

    public void deleteById(long countryId) {
        countryRepository.deleteById(countryId);
    }

}
