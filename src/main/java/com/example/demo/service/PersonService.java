package com.example.demo.service;

import com.example.demo.model.entity.Person;
import com.example.demo.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public void createPerson(Person person) {
        personRepository.save(Person.builder()
                .name(person.getName())
                .lastName(person.getLastName())
                .build());
    }

    public void deletePerson(int id) {
        Optional<Person> optUser = personRepository.findById(id);
        optUser.ifPresent(personRepository::delete);
    }

    public Optional<Person> getPerson(int id) {
        return personRepository.findById(id);
    }

    public void updatePerson(Person person) {
        Optional<Person> optUser = personRepository.findById(person.getId());
        if (optUser.isPresent())
            personRepository.save(person);
        else createPerson(person);
    }
}
