package com.example.demo.controller;

import com.example.demo.model.entity.Person;
import com.example.demo.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping("/get")
    public ResponseEntity<?> getPerson(@RequestParam int id) {
        Optional<Person> optionalPerson = personService.getPerson(id);
        if (optionalPerson.isPresent()) {
            return new ResponseEntity<>(optionalPerson.get(), HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/delete")
    public ResponseEntity<?> deletePerson(@RequestParam int id) {
        personService.deletePerson(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createPerson(@RequestBody Person person) {
        personService.createPerson(person);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<?> updatePerson(@RequestBody Person person) {
        personService.updatePerson(person);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
