package com.springboot.mongodb.service;

import com.springboot.mongodb.collection.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.bson.Document;

import java.util.List;

public interface PersonService {

    String save(Person person);

    List<Person> getPersonStartWith(String name);

    void delete(String id);

    List<Person> getPersonByAge(int minAge,int maxAge);

    Page<Person> search(String name, Integer minAge, Integer maxAge, String city, Pageable pageable);

    List<Document> getOldestPersonByCity();

    List<Document> getPopulationByCity();
}
