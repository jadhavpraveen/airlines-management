package com.renaissance.referencedataservice.service;

import com.renaissance.referencedataservice.exception.CommonException;
import com.renaissance.referencedataservice.exception.ResourceNotFoundException;
import com.renaissance.referencedataservice.model.Airlines;
import com.renaissance.referencedataservice.repository.AirlinesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AirlinesServiceImpl implements  AirlinesService{

    @Autowired
    AirlinesRepository repository;
    @Override
    public void addAirlines(List<Airlines> airlines) {
        if(airlines == null) throw new CommonException("Airlines object cannot be null or empty");
        repository.saveAll(airlines);
        log.info("Airlines data saved successfully");
    }

    @Override
    public List<Airlines> getAllAirlines() {
        List<Airlines> airlines = repository.findAll();
        return airlines;
    }

    @Override
    public Optional<Airlines> getAirlinesById(String id) {
        Optional<Airlines> airlines = repository.findById(id);
        if(airlines.isEmpty()) throw new ResourceNotFoundException("Airlines with id : " + id + " not found");
        return airlines;
    }

    @Override
    public Optional<List<Airlines>> findAirlinesByName(String airline_name, String status) {
        Optional<List<Airlines>> airlines = repository.findAirlinesByName(airline_name, status);
        if(airlines.isEmpty()) throw new ResourceNotFoundException("Airlines not present or is not active for name  : " + airlines);
        return airlines;
    }

    @Override
    public Optional<List<Airlines>> findAirlinesByCountryName(String country_name, String status) {
        Optional<List<Airlines>> airlines = repository.findAirlinesByCountryName(country_name, status);
        if(airlines.isEmpty()) throw new ResourceNotFoundException("Airlines not present or is not active for country  : " + country_name);
        return airlines;
    }

    @Override
    public Optional<List<Airlines>> findAirlinesByIataCode(String iata_code, String status) {
        Optional<List<Airlines>> airlines = repository.findAirlinesByIataCode(iata_code, status);
        if(airlines.isEmpty()) throw new ResourceNotFoundException("Airlines not present or is not active for Iata_Code  : " + iata_code);
        return airlines;
    }

    @Override
    public Optional<List<Airlines>> findAirlinesByIcaoCode(String icao_code, String status) {
        Optional<List<Airlines>> airlines = repository.findAirlinesByIcaoCode(icao_code, status);
        if(airlines.isEmpty()) throw new ResourceNotFoundException("Airlines not present or is not active for Icao_Code  : " + icao_code);
        return airlines;
    }
}
