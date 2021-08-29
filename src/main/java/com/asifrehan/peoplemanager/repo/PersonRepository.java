package com.asifrehan.peoplemanager.repo;

import com.asifrehan.peoplemanager.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Optional<Person> findPersonById(Long id);
}
