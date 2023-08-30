package com.renaissance.referencedataservice.controller;

import com.renaissance.referencedataservice.exception.CommonException;
import com.renaissance.referencedataservice.model.Airlines;
import com.renaissance.referencedataservice.model.Airport;
import com.renaissance.referencedataservice.service.AirlinesService;
import com.renaissance.referencedataservice.service.AirportServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class AirlinesController {
    @Autowired
    private final AirlinesService airlinesService;
    @PostMapping("airlines")
    public String addAirlines(@RequestBody List<Airlines> airlines)  {
        try {
            airlinesService.addAirlines(airlines);
            return "Airlines data saved successfully. " ;
        }
        catch (Exception e) {
            return "Exception: " + e.getMessage();
        }
    }
    @GetMapping("airlines")
    public ResponseEntity<List<Airlines>> getAllAirlines() throws Exception {
        try {
            List<Airlines> airlines = airlinesService.getAllAirlines();
            return new ResponseEntity<>(airlines, HttpStatus.OK);
        }
        catch(Exception e)  {
            throw new Exception(e.getMessage());
        }
    }
    @GetMapping("airlines/{id}")
    public ResponseEntity<Airlines> getAirlinesById(@PathVariable(value = "id") String id) throws Exception {
        try {
            Optional<Airlines> airlines = airlinesService.getAirlinesById(id);
            return new ResponseEntity<>(airlines.get(), HttpStatus.OK);
        }
        catch(Exception e)  {
            throw new CommonException(e.getMessage());
        }
    }
    @GetMapping("airlines/{airline_name}/{status}")
    public ResponseEntity<List<Airlines>> findAirlinesByName(
                @PathVariable(value = "airline_name") String airline_name,
                @PathVariable(value = "status") String status) throws Exception {
        try {
            Optional<List<Airlines>> airlines = airlinesService.findAirlinesByName(airline_name,status);
            return new ResponseEntity<>(airlines.get(), HttpStatus.OK);
        }
        catch(Exception e)  {
            throw new CommonException(e.getMessage());
        }
    }

    @GetMapping("airlines/country/{country_name}/{status}")
    public ResponseEntity<List<Airlines>> findAirlinesByCountryName(
            @PathVariable(value = "country_name") String country_name,
            @PathVariable(value = "status") String status) throws Exception {
        try {
            Optional<List<Airlines>> airlines = airlinesService.findAirlinesByCountryName(country_name,status);
            return new ResponseEntity<>(airlines.get(), HttpStatus.OK);
        }
        catch(Exception e)  {
            throw new CommonException(e.getMessage());
        }
    }
    @GetMapping("airlines/iatacode/{iata_code}/{status}")
    public ResponseEntity<List<Airlines>> findAirlinesByIataCode(
            @PathVariable(value = "iata_code") String iata_code,
            @PathVariable(value = "status") String status) throws Exception {
        try {
            Optional<List<Airlines>> airlines = airlinesService.findAirlinesByIataCode(iata_code,status);
            return new ResponseEntity<>(airlines.get(), HttpStatus.OK);
        }
        catch(Exception e)  {
            throw new CommonException(e.getMessage());
        }
    }
    @GetMapping("airlines/icaocode/{icao_code}/{status}")
    public ResponseEntity<List<Airlines>> findAirlinesByIcaoCode(
            @PathVariable(value = "icao_code") String icao_code,
            @PathVariable(value = "status") String status) throws Exception {
        try {
            Optional<List<Airlines>> airlines = airlinesService.findAirlinesByIcaoCode(icao_code,status);
            return new ResponseEntity<>(airlines.get(), HttpStatus.OK);
        }
        catch(Exception e)  {
            throw new CommonException(e.getMessage());
        }
    }
}
