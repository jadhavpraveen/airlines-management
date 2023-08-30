package com.renaissance.referencedataservice.service;

import com.renaissance.referencedataservice.exception.CommonException;
import com.renaissance.referencedataservice.exception.ResourceNotFoundException;
import com.renaissance.referencedataservice.model.Airlines;
import com.renaissance.referencedataservice.model.Airport;
import com.renaissance.referencedataservice.model.Flights;
import com.renaissance.referencedataservice.repository.AirlinesRepository;
import com.renaissance.referencedataservice.repository.FlightsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class FlightsServiceImpl implements  FlightsService {
    @Autowired
    FlightsRepository repository;

    @Override
    public void addFlights(List<Flights> flights) {
        if(flights == null) throw new CommonException("flights object cannot be null or empty");
        repository.saveAll(flights);
        log.info("flights data saved successfully");
    }
    @Override
    public List<Flights> getAllFlights() {
        List<Flights> flights = repository.findAll();
        return flights;
    }

    @Override
    public Optional<Flights> getFlightsById(String id) {
        Optional<Flights> flights = repository.findById(id);
        if(flights.isEmpty()) throw new ResourceNotFoundException("Flights with id : " + id + " not found");
        return flights;
    }
    @Override
    public Optional<List<Flights>> findFlightByAirlinesName(String airline_name) {
        Optional<List<Flights>> flights = repository.findFlightByAirlinesName(airline_name);
        if(flights.isEmpty()) throw new ResourceNotFoundException("Flights not present for Airlines : " + flights);
        return flights;
    }
}
