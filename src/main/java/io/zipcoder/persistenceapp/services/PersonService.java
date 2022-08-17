package io.zipcoder.persistenceapp.services;

import io.zipcoder.persistenceapp.Repositories.PersonRepository;
import io.zipcoder.persistenceapp.models.Person;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repo;

    public PersonService(PersonRepository repo) {
        this.repo = repo;
    }

    public Iterable<Person> index() {
        return repo.findAll();
    }

    public Person show(Integer id) {
        return repo.findOne(id);
    }

    public Person create(Person person) {
        return repo.save(person);
    }

    public Person update (Integer id, Person newPersonData) {
        Person originalPerson = repo.findOne(id);
        originalPerson.setFirst_name(newPersonData.getFirst_name());
        originalPerson.setLast_name(newPersonData.getLast_name());
        originalPerson.setMobile(newPersonData.getMobile());
        originalPerson.setBirthday(newPersonData.getBirthday());
        originalPerson.setHome_id(newPersonData.getHome_id());
        return repo.save(originalPerson);
    }

    public boolean delete(Integer id) {
        repo.delete(id);
        return true;
    }
}
