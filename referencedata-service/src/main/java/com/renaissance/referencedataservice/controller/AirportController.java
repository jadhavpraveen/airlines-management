package com.renaissance.referencedataservice.controller;

import com.renaissance.referencedataservice.exception.CommonException;
import com.renaissance.referencedataservice.model.Airport;
import com.renaissance.referencedataservice.model.Country;
import com.renaissance.referencedataservice.service.AirportServiceImpl;
import com.renaissance.referencedataservice.service.CountryServiceImpl;
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
public class AirportController {
    private final AirportServiceImpl airportService;
    @PostMapping("airports")
    public String addAirport(@RequestBody List<Airport> airports)  {
        try {
            airportService.addAirport(airports);
            return "Airports data saved successfully. " ;
        }
        catch (Exception e) {
            return "Exception: " + e.getMessage();
        }
    }
    @GetMapping("airports")
    public ResponseEntity<List<Airport>> getAllAirports() throws Exception {
        try {
            List<Airport> airports = airportService.getAllAirports();
            return new ResponseEntity<>(airports, HttpStatus.OK);
        }
        catch(Exception e)  {
            throw new Exception(e.getMessage());
        }
    }
    @GetMapping("airports/{id}")
    public ResponseEntity<Airport> getAirportById(@PathVariable(value = "id") String id) throws Exception {
        try {
            Optional<Airport> airport = airportService.getAirportById(id);
            return new ResponseEntity<>(airport.get(), HttpStatus.OK);
        }
        catch(Exception e)  {
            throw new CommonException(e.getMessage());
        }
    }
    @GetMapping("airports/country/{country}")
    public ResponseEntity<List<Airport>> findAirportsByCountryName(@PathVariable(value = "country") String country) throws Exception {
        try {
            Optional<List<Airport>> airports = airportService.findAirportsByCountryName(country);
            return new ResponseEntity<>(airports.get(), HttpStatus.OK);
        }
        catch(Exception e)  {
            throw new CommonException(e.getMessage());
        }
    }
    @GetMapping("airports/city/{city}")
    public ResponseEntity<List<Airport>> findAirportsByCityName(@PathVariable(value = "city") String city) throws Exception {
        try {
            Optional<List<Airport>> airports = airportService.findAirportsByCityName(city);
            return new ResponseEntity<>(airports.get(), HttpStatus.OK);
        }
        catch(Exception e)  {
            throw new CommonException(e.getMessage());
        }
    }
    @GetMapping("airports/code/{code}")
    public ResponseEntity<List<Airport>> findAirportsByCode(@PathVariable(value = "code") String code) throws Exception {
        try {
            Optional<List<Airport>> airports = airportService.findAirportsByCode(code);
            return new ResponseEntity<>(airports.get(), HttpStatus.OK);
        }
        catch(Exception e)  {
            throw new CommonException(e.getMessage());
        }
    }
}
