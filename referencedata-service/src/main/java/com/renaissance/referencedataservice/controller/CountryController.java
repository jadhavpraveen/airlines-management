package com.renaissance.referencedataservice.controller;

import com.renaissance.referencedataservice.exception.CommonException;
import com.renaissance.referencedataservice.model.Country;
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
public class CountryController {

    private final CountryServiceImpl countryService;
    @PostMapping("countries")
    public String addCountry(@RequestBody List<Country> countries)  {
        try {
            countryService.addCountry(countries);
            return "Countries data saved successfully. " + HttpStatus.CREATED;
        }
        catch (Exception e) {
            return "Exception: " + e.getMessage();
        }
    }
    @GetMapping("countries")
    public ResponseEntity<List<Country>> getCountries() throws Exception {
        try {
            List<Country> countries = countryService.getAllCountries();
            return new ResponseEntity<>(countries, HttpStatus.OK);
        }
        catch(Exception e)  {
            throw new Exception(e.getMessage());
        }
    }

    @GetMapping("countries/{id}")
    public ResponseEntity<Country> getCountrById(@PathVariable(value = "id") int id) throws Exception {
        try {
            Optional<Country> country = countryService.getCountryById(id);
            return new ResponseEntity<>(country.get(), HttpStatus.OK);
        }
        catch(Exception e)  {
            throw new Exception(e.getMessage());
        }
    }
    @GetMapping("countries/country/{name}")
    public ResponseEntity<Country> findCountriesByCountryName(@PathVariable(value = "name") String name) throws Exception {
        try {
            Optional<Country> country = countryService.findCountriesByCountryName(name);
            return new ResponseEntity<>(country.get(), HttpStatus.OK);
        }
        catch(Exception e)  {
            throw new CommonException(e.getMessage() + " " + HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("countries/region/{region}")
    public ResponseEntity<List<Country>> findCountriesByCountryRegion(@PathVariable(value = "region") String region) throws Exception {
        try {
            Optional<List<Country>> countries = countryService.findCountriesByCountryRegion(region);
            return new ResponseEntity<>(countries.get(), HttpStatus.OK);
        }
        catch(Exception e)  {
            throw new CommonException(e.getMessage());
        }
    }
}
