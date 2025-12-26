package com.example.demo.service.impl;

import com.example.demo.exception.ApiException;
import com.example.demo.model.PersonProfile;
import com.example.demo.repository.PersonProfileRepository;
import com.example.demo.service.PersonProfileService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonProfileServiceImpl implements PersonProfileService {

    private final PersonProfileRepository repo;

    public PersonProfileServiceImpl(PersonProfileRepository repo) {
        this.repo = repo;
    }

    @Override
    public PersonProfile createPerson(PersonProfile p) {
        if (p.getEmail() == null)
            throw new ApiException("Email required");

        if (repo.findByEmail(p.getEmail()).isPresent())
            throw new ApiException("Duplicate email");

        if (repo.findByReferenceId(p.getReferenceId()).isPresent())
            throw new ApiException("Duplicate reference");

        if (p.getRelationshipDeclared() == null)
            p.setRelationshipDeclared(false);

        return repo.save(p);
    }

    @Override
    public PersonProfile getPersonById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ApiException("Person not found"));
    }

    @Override
    public List<PersonProfile> getAllPersons() {
        return repo.findAll();
    }

    @Override
    public Optional<PersonProfile> findByReferenceId(String referenceId) {
        return repo.findByReferenceId(referenceId);
    }

    @Override
    public PersonProfile updateRelationshipDeclared(Long id, boolean declared) {
        PersonProfile p = getPersonById(id);
        p.setRelationshipDeclared(declared);
        return repo.save(p);
    }
}
