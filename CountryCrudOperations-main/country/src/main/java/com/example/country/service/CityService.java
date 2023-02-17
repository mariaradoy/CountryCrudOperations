package com.example.country.service;


import com.example.country.model.City;
import com.example.country.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    @Autowired
    CityRepository cityRepository;

    public City saveCity(City city){
        return cityRepository.save(city);
    }

    public List<City> getAllCities() throws Exception{
        return cityRepository.findAll();
    }

    public City getCityById(long id){
        return cityRepository.findById(id).get();
    }

    public City updateCity(City city){
        City city1 = cityRepository.findById(city.getId()).get();
        city1.setName(city.getName());
        return cityRepository.save(city1);
    }

    public void deleteAllCities(){
        cityRepository.deleteAll();
    }
    public void deleteById(long id){
        cityRepository.deleteById(id);
    }

}
