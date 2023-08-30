package com.renaissance.referencedataservice.service;

import com.renaissance.referencedataservice.exception.CommonException;
import com.renaissance.referencedataservice.exception.ResourceNotFoundException;
import com.renaissance.referencedataservice.model.Country;
import com.renaissance.referencedataservice.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CountryServiceImpl implements  CountryService {
    @Autowired
    private CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public void addCountry(List<Country> countries) {
        if(countries == null) throw new CommonException("Country object cannot be null or empty");
        countryRepository.saveAll(countries);
        log.info("Countries data saved successfully");
    }

    @Override
    public List<Country> getAllCountries() {
        List<Country> countries = countryRepository.findAll();
        return countries;
    }

    @Override
    public Optional<Country> getCountryById(int id) {
       Optional<Country> country = countryRepository.findById(id);
        if(country.isEmpty()) throw new ResourceNotFoundException("Country with id : " + id + " not found");
       return country;
    }
    @Override
    public Optional<Country> findCountriesByCountryName(String name) {
        Optional<Country> country = countryRepository.findCountriesByCountryName(name);
        if(country.isEmpty()) throw new ResourceNotFoundException("Country with name : " + name + " not found");
        return country;
    }
    @Override
    public Optional<List<Country>> findCountriesByCountryRegion(String region) {
        Optional<List<Country>> countries = countryRepository.findCountriesByCountryRegion(region);
        if(countries.isEmpty()) throw new ResourceNotFoundException("No countries present for region  : " + region);
        return countries;
    }
}
