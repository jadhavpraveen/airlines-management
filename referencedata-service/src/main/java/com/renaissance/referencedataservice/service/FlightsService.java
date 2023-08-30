package com.renaissance.referencedataservice.service;

import com.renaissance.referencedataservice.model.Airlines;
import com.renaissance.referencedataservice.model.Flights;

import java.util.List;
import java.util.Optional;

public interface FlightsService {
    void addFlights(List<Flights> flights) ;
    List<Flights> getAllFlights();
    Optional<Flights> getFlightsById(String id);
    Optional<List<Flights>> findFlightByAirlinesName(String airline_name);
}
