package com.renaissance.referencedataservice.service;

import com.renaissance.referencedataservice.model.Airlines;
import com.renaissance.referencedataservice.model.Country;

import java.util.List;
import java.util.Optional;

public interface AirlinesService {
    void addAirlines(List<Airlines> airlines) ;
    List<Airlines> getAllAirlines();
    Optional<Airlines> getAirlinesById(String id);
    Optional<List<Airlines>> findAirlinesByName(String airline_name, String status);
    Optional<List<Airlines>> findAirlinesByCountryName(String country_name, String status);
    Optional<List<Airlines>> findAirlinesByIataCode(String iata_code, String status);
    Optional<List<Airlines>> findAirlinesByIcaoCode(String icao_code, String status);
}
