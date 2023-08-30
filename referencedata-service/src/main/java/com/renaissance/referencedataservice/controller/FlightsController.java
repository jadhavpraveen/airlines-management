package com.renaissance.referencedataservice.controller;

import com.renaissance.referencedataservice.exception.CommonException;
import com.renaissance.referencedataservice.model.Flights;
import com.renaissance.referencedataservice.service.FlightsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class FlightsController {
    private final FlightsService flightsService;
    @PostMapping("flights")
    public String addAirlines(@RequestBody List<Flights> flights)  {
        try {
            flightsService.addFlights(flights);
            return "Flights data saved successfully. " ;
        }
        catch (Exception e) {
            return "Exception: " + e.getMessage();
        }
    }
    @GetMapping("flights")
    public ResponseEntity<List<Flights>> getAllFlights() throws Exception {
        try {
            List<Flights> flights = flightsService.getAllFlights();
            return new ResponseEntity<>(flights, HttpStatus.OK);
        }
        catch(Exception e)  {
            throw new Exception(e.getMessage());
        }
    }
    @GetMapping("flights/{id}")
    public ResponseEntity<Flights> getFlightsById(@PathVariable(value = "id") String id) throws Exception {
        try {
            Optional<Flights> flights = flightsService.getFlightsById(id);
            return new ResponseEntity<>(flights .get(), HttpStatus.OK);
        }
        catch(Exception e)  {
            throw new CommonException(e.getMessage());
        }
    }
    @GetMapping("flights/airlines/{airline_name}")
    public ResponseEntity<List<Flights>> findFlightByAirlinesName(@PathVariable(value = "airline_name") String airline_name) throws Exception {
        try {
            Optional<List<Flights>> flights = flightsService.findFlightByAirlinesName(airline_name);
            return new ResponseEntity<>(flights.get(), HttpStatus.OK);
        }
        catch(Exception e)  {
            throw new CommonException(e.getMessage());
        }
    }
}
