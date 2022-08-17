package controllers;

import models.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import services.PersonService;

import javax.xml.ws.Response;

@Controller
@RequestMapping
public class PersonController {

    private PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    public ResponseEntity<Iterable<Person>> index() {
        return new ResponseEntity<>(service.index(), HttpStatus.OK);
    }

    @PostMapping("/person/")
    public ResponseEntity<Person> create (@RequestBody Person person) {
        return new ResponseEntity<>(service.create(person), HttpStatus.OK);
    }

    @GetMapping("/person/{id}")
    public ResponseEntity<Person> show (@PathVariable Integer id) {
        return new ResponseEntity<>(service.show(id), HttpStatus.OK);
    }

    @PutMapping("/person/{id}")
    public ResponseEntity<Person> update (@PathVariable Integer id, Person person) {
        return new ResponseEntity<>(service.update(id, person), HttpStatus.OK);
    }

    @DeleteMapping("/person/{id}")
    public ResponseEntity<Boolean> delete (@PathVariable Integer id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}
