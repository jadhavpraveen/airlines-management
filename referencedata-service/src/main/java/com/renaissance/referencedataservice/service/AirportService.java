package com.renaissance.referencedataservice.service;

import com.renaissance.referencedataservice.model.Airport;
import com.renaissance.referencedataservice.model.Country;

import java.util.List;
import java.util.Optional;

public interface AirportService {
    void addAirport(List<Airport> airports) ;
    List<Airport> getAllAirports();
    Optional<Airport> getAirportById(String id);
    Optional<List<Airport>> findAirportsByCountryName(String country);
    Optional<List<Airport>> findAirportsByCityName(String city);
    Optional<List<Airport>> findAirportsByCode(String code);
}
