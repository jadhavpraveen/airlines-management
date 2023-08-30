package com.renaissance.referencedataservice.repository;

import com.renaissance.referencedataservice.model.Airlines;
import com.renaissance.referencedataservice.model.Flights;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FlightsRepository extends MongoRepository<Flights, String> {
    @Query(value="{'airline_name': ?0}")
    Optional<List<Flights>> findFlightByAirlinesName(String airline_name);
}
