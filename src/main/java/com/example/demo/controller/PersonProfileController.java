package com.example.demo.controller;

import com.example.demo.entity.PersonProfile;
import com.example.demo.service.PersonProfileService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonProfileController {

    private final PersonProfileService service;

    public PersonProfileController(PersonProfileService service) {
        this.service = service;
    }

    @PostMapping
    public PersonProfile create(@RequestBody PersonProfile p) {
        return service.create(p);
    }

    @GetMapping("/{id}")
    public PersonProfile get(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<PersonProfile> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}/relationship-declared")
    public PersonProfile update(@PathVariable Long id,
                                @RequestParam Boolean declared) {
        return service.updateRelationshipDeclared(id, declared);
    }

    @GetMapping("/lookup/{referenceId}")
    public PersonProfile lookup(@PathVariable String referenceId) {
        return service.findByReferenceId(referenceId);
    }
}
