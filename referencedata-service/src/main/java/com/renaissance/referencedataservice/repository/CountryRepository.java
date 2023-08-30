package com.renaissance.referencedataservice.repository;

import com.mongodb.client.MongoCursor;
import com.renaissance.referencedataservice.model.Country;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CountryRepository extends MongoRepository<Country, String> {
        @Query(value="{}",fields = "{'id':1,'name':1,'region':1, 'capital':1,'currency':1, 'iso3':1}")
        List<Country> findAll();

        @Query(value="{'id': ?0}",fields = "{'id':1,'name':1,'region':1, 'capital':1,'currency':1, 'iso3':1, 'states':  1}")
        Optional<Country> findById(int id);

        @Query(value="{'name': ?0}",fields = "{'id':1,'name':1,'region':1, 'capital':1,'currency':1, 'iso3':1, 'states':  1}")
        Optional<Country> findCountriesByCountryName(String name);

        @Query(value="{'region': ?0}",fields = "{'id':1,'name':1,'region':1, 'capital':1,'currency':1, 'iso3':1, 'states':  1}")
        Optional<List<Country>> findCountriesByCountryRegion(String region);


}
