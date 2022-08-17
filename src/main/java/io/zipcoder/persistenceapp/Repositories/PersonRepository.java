package io.zipcoder.persistenceapp.Repositories;

import io.zipcoder.persistenceapp.models.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {
}
