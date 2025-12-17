package com.example.demo.service.impl;

import com.example.demo.entity.PersonProfile;
import com.example.demo.exception.ApiException;
import com.example.demo.repository.PersonProfileRepository;
import com.example.demo.service.PersonProfileService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PersonProfileServiceImpl implements PersonProfileService {

    private final PersonProfileRepository repo;

    public PersonProfileServiceImpl(PersonProfileRepository repo) {
        this.repo = repo;
    }

    public PersonProfile createPerson(PersonProfile p) {
        if (repo.findByEmail(p.getEmail()).isPresent())
            throw new ApiException("Duplicate email");
        if (repo.findByReferenceId(p.getReferenceId()).isPresent())
            throw new ApiException("Duplicate reference");
        return repo.save(p);
    }

    public PersonProfile getPersonById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ApiException("Missing person"));
    }

    public List<PersonProfile> getAllPersons() {
        return repo.findAll();
    }

    public PersonProfile findByReferenceId(String ref) {
        return repo.findByReferenceId(ref)
                .orElseThrow(() -> new ApiException("Missing person"));
    }

    public PersonProfile updateRelationshipDeclared(Long id, boolean declared) {
        PersonProfile p = getPersonById(id);
        p.setRelationshipDeclared(declared);
        return repo.save(p);
    }
}