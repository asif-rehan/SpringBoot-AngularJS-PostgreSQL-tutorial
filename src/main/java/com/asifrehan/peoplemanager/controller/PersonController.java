package com.asifrehan.peoplemanager.controller;

import com.asifrehan.peoplemanager.model.Person;
import com.asifrehan.peoplemanager.service.PeopleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    private final PeopleService peopleService;

    public PersonController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Person>> getAllPersons(){
        List<Person> personList = peopleService.findAllPersons();
        return new ResponseEntity<>(personList, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable("id") Long id){
        Person person = peopleService.findPersonById(id);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Person> addPerson(@RequestBody Person person){
        Person newPerson = peopleService.addPerson(person);
        return new ResponseEntity<>(newPerson, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Person> updatePerson(@RequestBody Person person){
        Person updatedPerson = peopleService.updatePerson(person);
        return new ResponseEntity<>(updatedPerson, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> updatePerson(@PathVariable("id") Long id){
        peopleService.deletePerson(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
