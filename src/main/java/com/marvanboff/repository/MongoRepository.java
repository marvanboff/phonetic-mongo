package com.marvanboff.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.marvanboff.entity.Person;

@Repository
public interface MongoRepository extends CrudRepository<Person, Long> {

}
