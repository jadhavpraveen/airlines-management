package com.renaissance.referencedataservice.repository;

import com.renaissance.referencedataservice.model.Airport;
import com.renaissance.referencedataservice.model.Country;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AirportRepository extends MongoRepository<Airport, String> {
    @Query(value="{'country': ?0}")
    Optional<List<Airport>> findAirportsByCountryName(String country);
    @Query(value="{'city': ?0}")
    Optional<List<Airport>> findAirportsByCityName(String city);
    @Query(value="{'code': ?0}")
    Optional<List<Airport>> findAirportsByCode(String code);
}
