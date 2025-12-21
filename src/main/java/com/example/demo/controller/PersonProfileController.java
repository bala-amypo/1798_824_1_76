// FILE: src/main/java/com/example/demo/controller/PersonProfileController.java
package com.example.demo.controller;

import com.example.demo.entity.PersonProfile;
import com.example.demo.service.PersonProfileService;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/persons")
@Tag(name = "Person Profile")
public class PersonProfileController {

    private final PersonProfileService service;

    public PersonProfileController(PersonProfileService service) {
        this.service = service;
    }

    @PostMapping
    public PersonProfile create(@RequestBody PersonProfile p) {
        return service.createPerson(p);
    }

    @GetMapping("/{id}")
    public PersonProfile get(@PathVariable Long id) {
        return service.getPersonById(id);
    }

    @GetMapping
    public List<PersonProfile> all() {
        return service.getAllPersons();
    }

    @PutMapping("/{id}/relationship-declared")
    public PersonProfile updateRelationshipDeclared(
            @PathVariable Long id,
            @RequestParam boolean declared) {
        return service.updateRelationshipDeclared(id, declared);
    }

    @GetMapping("/lookup/{referenceId}")
    public PersonProfile getByReferenceId(
            @PathVariable String referenceId) {
        return service.findByReferenceId(referenceId);
    }
}
