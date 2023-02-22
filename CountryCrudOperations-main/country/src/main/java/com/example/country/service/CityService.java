package com.example.country.service;


import com.example.country.model.City;
import com.example.country.repository.CityRepository;
import com.example.country.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CityService {
    @Autowired
    CityRepository cityRepository;
    @Autowired
    CountryRepository countryRepository;
    public List<City> getAllCitiesByCountryId(Long countryId){
        return (List<City>) cityRepository.findByCountryId(countryId);
    }

    public City saveCity(long countryId, City city) {
        return countryRepository.findById(countryId).map(country -> {
            city.setCountry(country);
            return cityRepository.save(city);
        }).orElseThrow();
    }

    public City updateCity(City city){
        City updatedCity = cityRepository.findById(city.getId()).get();
        updatedCity.setName(city.getName());
        return cityRepository.save(updatedCity);
    }

    public void deleteById(long id){
        cityRepository.deleteById(id);
    }

}
