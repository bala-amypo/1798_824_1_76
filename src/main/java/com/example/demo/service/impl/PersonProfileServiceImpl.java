package com.example.demo.service.impl;

import com.example.demo.exception.ApiException;
import com.example.demo.model.PersonProfile;
import com.example.demo.repository.PersonProfileRepository;
import com.example.demo.service.PersonProfileService;

import java.util.List;
import java.util.Optional;

public class PersonProfileServiceImpl implements PersonProfileService {

    private final PersonProfileRepository repo;

    public PersonProfileServiceImpl(PersonProfileRepository repo) {
        this.repo = repo;
    }

    @Override
    public PersonProfile createPerson(PersonProfile person) {

        if (person.getEmail() == null) {
            throw new ApiException("Email is required");
        }
        if (person.getReferenceId() == null) {
            throw new ApiException("ReferenceId is required");
        }

        if (repo.findByEmail(person.getEmail()).isPresent()) {
            throw new ApiException("Duplicate email");
        }
        if (repo.findByReferenceId(person.getReferenceId()).isPresent()) {
            throw new ApiException("Duplicate reference");
        }

        if (person.getRelationshipDeclared() == null) {
            person.setRelationshipDeclared(false);
        }

        return repo.save(person);
    }

    @Override
    public PersonProfile getPersonById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ApiException("Person not found"));
    }

    @Override
    public PersonProfile updateRelationshipDeclared(Long id, boolean declared) {
        PersonProfile p = getPersonById(id);
        p.setRelationshipDeclared(declared);
        return repo.save(p);
    }

    @Override
    public List<PersonProfile> getAllPersons() {
        return repo.findAll();
    }

    @Override
    public Optional<PersonProfile> findByReferenceId(String referenceId) {
        return repo.findByReferenceId(referenceId);
    }
}
