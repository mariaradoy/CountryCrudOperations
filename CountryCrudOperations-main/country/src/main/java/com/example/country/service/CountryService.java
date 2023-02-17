package com.example.country.service;

import com.example.country.model.Country;
import com.example.country.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    @Autowired
    CountryRepository countryRepository;


    public Country saveCountry(Country country){
        return countryRepository.save(country);
    }
    public List<Country> getAllCountries() throws Exception {
        return countryRepository.findAll();
    }

    public Country getCountryById(long id) {
        return countryRepository.findById(id).get();
    }

    public Country updateCountry(Country country) {
        Country country1 = countryRepository.findById(country.getId()).get();
        country1.setName(country.getName());
        country1.setPopulation(country.getPopulation());
        country1.setCities(country.getCities());
        return countryRepository.save(country1);
    }

    public void deleteAllCountries() {
        countryRepository.deleteAll();
    }

    public void deleteById(long id) {
        countryRepository.deleteById(id);
    }

}
