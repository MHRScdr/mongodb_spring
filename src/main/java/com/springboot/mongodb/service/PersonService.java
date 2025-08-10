package com.springboot.mongodb.service;

import com.springboot.mongodb.collection.Person;

import java.util.List;

public interface PersonService {

    String save(Person person);

    List<Person> getPersonStartWith(String name);

    void delete(String id);

    List<Person> getPersonByAge(int minAge,int maxAge);
}
