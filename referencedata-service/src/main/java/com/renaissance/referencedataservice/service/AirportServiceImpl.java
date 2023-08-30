package com.renaissance.referencedataservice.service;

import com.renaissance.referencedataservice.exception.CommonException;
import com.renaissance.referencedataservice.exception.ResourceNotFoundException;
import com.renaissance.referencedataservice.model.Airport;
import com.renaissance.referencedataservice.model.Country;
import com.renaissance.referencedataservice.repository.AirportRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AirportServiceImpl  implements AirportService{
    @Autowired
    AirportRepository repository;

    @Override
    public void addAirport(List<Airport> airports) {
            if(airports == null) throw new CommonException("Airports data cannot be null") ;
            repository.saveAll(airports);
            log.info("Airports data saved successfully");
    }

    @Override
    public List<Airport> getAllAirports() {
        List<Airport> airports = repository.findAll();
        return airports;
    }

    @Override
    public Optional<Airport> getAirportById(String id) {
        Optional<Airport> airport = repository.findById(id);
        if(airport.isEmpty()) throw new ResourceNotFoundException("Airport with id : " + id + " not found");
        return airport;
    }

    @Override
    public Optional<List<Airport>> findAirportsByCountryName(String country) {
        Optional<List<Airport>> airports = repository.findAirportsByCountryName(country);
        if(airports.isEmpty()) throw new ResourceNotFoundException("Airports not present for country  : " + country);
        return airports;
    }

    @Override
    public Optional<List<Airport>> findAirportsByCityName(String city) {
        Optional<List<Airport>> airports = repository.findAirportsByCityName(city);
        if(airports.isEmpty()) throw new ResourceNotFoundException("Airports not present for city  : " + city);
        return airports;
    }

    @Override
    public Optional<List<Airport>> findAirportsByCode(String code) {
        Optional<List<Airport>> airports = repository.findAirportsByCode(code);
        if(airports.isEmpty()) throw new ResourceNotFoundException("Airports not present for code  : " + code);
        return airports;
    }
}
