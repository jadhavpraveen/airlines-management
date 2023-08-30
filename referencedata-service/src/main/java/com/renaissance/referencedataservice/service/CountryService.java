package com.renaissance.referencedataservice.service;

import com.renaissance.referencedataservice.model.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    void addCountry(List<Country> countries) ;
    List<Country> getAllCountries();
    Optional<Country> getCountryById(int id);
    Optional<Country> findCountriesByCountryName(String name);
    Optional<List<Country>> findCountriesByCountryRegion(String region);
}
