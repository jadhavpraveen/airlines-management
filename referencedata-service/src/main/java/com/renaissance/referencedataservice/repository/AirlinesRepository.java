package com.renaissance.referencedataservice.repository;

import com.renaissance.referencedataservice.model.Airlines;
import com.renaissance.referencedataservice.model.Airport;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AirlinesRepository extends MongoRepository<Airlines, String> {

    @Query(value="{'airline_name': ?0,'status': ?1}")
    Optional<List<Airlines>> findAirlinesByName(String airline_name, String status);
    @Query(value="{'country_name': ?0,'status': ?1}")
    Optional<List<Airlines>> findAirlinesByCountryName(String country_name, String status);
    @Query(value="{'iata_code': ?0,'status': ?1}")
    Optional<List<Airlines>> findAirlinesByIataCode(String iata_code, String status);
    @Query(value="{'icao_code': ?0,'status': ?1}")
    Optional<List<Airlines>> findAirlinesByIcaoCode(String icao_code, String status);
}
