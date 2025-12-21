package com.example.demo.controller;

import com.example.demo.model.PersonProfile;
import com.example.demo.service.PersonProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonProfileController {

    private final PersonProfileService personService;

    public PersonProfileController(PersonProfileService personService) {
        this.personService = personService;
    }

    @PostMapping
    public PersonProfile create(@RequestBody PersonProfile person) {
        return personService.createPerson(person);
    }

    @GetMapping("/{id}")
    public PersonProfile getById(@PathVariable Long id) {
        return personService.getPersonById(id);
    }

    @GetMapping
    public List<PersonProfile> getAll() {
        return personService.getAllPersons();
    }

    @GetMapping("/reference/{refId}")
    public PersonProfile getByReference(@PathVariable String refId) {
        return personService.findByReferenceId(refId);
    }

    @PutMapping("/{id}/relationship")
    public PersonProfile updateRelationshipDeclared(
            @PathVariable Long id,
            @RequestParam boolean declared) {
        return personService.updateRelationshipDeclared(id, declared);
    }
}
