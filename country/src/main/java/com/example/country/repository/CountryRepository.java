package com.example.country.repository;


import com.example.country.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, Long> {
    List<Country> findByName(String name);
    List<Country> findByPopulation(long population);
}
