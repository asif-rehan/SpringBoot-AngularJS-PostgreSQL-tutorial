package com.asifrehan.peoplemanager.service;

import com.asifrehan.peoplemanager.exception.UserNotFoundException;
import com.asifrehan.peoplemanager.model.Person;
import com.asifrehan.peoplemanager.repo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class PeopleService {
    private final PersonRepository personRepository;

    @Autowired
    public PeopleService(PersonRepository peopleRepository) {
        this.personRepository = peopleRepository;
    }

    public Person addPerson(Person person) {
        person.setPersonUuidCode(UUID.randomUUID().toString());
        return personRepository.save(person);
    }

    public List<Person> findAllPersons(){
        return personRepository.findAll();
    }

    public Person updatePerson(Person person){
        return personRepository.save((person));
    }
    public void deletePerson(Long id){
        personRepository.deleteById(id);
    }

    public Person findPersonById(Long id) {
        return personRepository.findPersonById(id).orElseThrow(() ->
                new UserNotFoundException("User with id " + id + "not found!!"));

    }
}
