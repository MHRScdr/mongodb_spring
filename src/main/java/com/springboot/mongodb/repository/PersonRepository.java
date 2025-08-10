package com.springboot.mongodb.repository;

import com.springboot.mongodb.collection.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends MongoRepository<Person, String> {

    List<Person> findByFirstNameStartingWith(String name);

    void deleteById(String id);

    @Query(value = "{'age' : { $gt : ?0, $lt: ?1}}")
    List<Person> findPersonByAgeIsBetween(int min,int maxAge);

}
