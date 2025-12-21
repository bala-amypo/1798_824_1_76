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

    public PersonProfile create(PersonProfile p) {
        if (repo.findByEmail(p.getEmail()).isPresent())
            throw new ApiException("email");
        if (repo.findByReferenceId(p.getReferenceId()).isPresent())
            throw new ApiException("reference");
        return repo.save(p);
    }

    public PersonProfile getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ApiException("person"));
    }

    public List<PersonProfile> getAll() {
        return repo.findAll();
    }

    public PersonProfile updateRelationshipDeclared(Long id, Boolean declared) {
        PersonProfile p = getById(id);
        p.setRelationshipDeclared(declared);
        return repo.save(p);
    }

    public PersonProfile findByReferenceId(String referenceId) {
        return repo.findByReferenceId(referenceId)
                .orElseThrow(() -> new ApiException("person"));
    }
}
