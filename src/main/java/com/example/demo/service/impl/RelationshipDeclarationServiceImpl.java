package com.example.demo.service.impl;

import com.example.demo.exception.ApiException;
import com.example.demo.model.PersonProfile;
import com.example.demo.model.RelationshipDeclaration;
import com.example.demo.repository.PersonProfileRepository;
import com.example.demo.repository.RelationshipDeclarationRepository;
import com.example.demo.service.RelationshipDeclarationService;

import java.util.List;

public class RelationshipDeclarationServiceImpl implements RelationshipDeclarationService {

    private final RelationshipDeclarationRepository repo;
    private final PersonProfileRepository personRepo;

    public RelationshipDeclarationServiceImpl(RelationshipDeclarationRepository repo,
                                              PersonProfileRepository personRepo) {
        this.repo = repo;
        this.personRepo = personRepo;
    }

    @Override
    public RelationshipDeclaration declareRelationship(RelationshipDeclaration declaration) {

        PersonProfile p = personRepo.findById(declaration.getPersonId())
                .orElseThrow(() -> new ApiException("Person not found"));

        p.setRelationshipDeclared(true);
        personRepo.save(p);

        return repo.save(declaration);
    }

    @Override
    public RelationshipDeclaration verifyDeclaration(Long id, boolean verified) {
        RelationshipDeclaration d = repo.findById(id)
                .orElseThrow(() -> new ApiException("Declaration not found"));
        d.setIsVerified(verified);
        return repo.save(d);
    }

    @Override
    public List<RelationshipDeclaration> getDeclarationsByPerson(Long personId) {
        return repo.findByPersonId(personId);
    }

    @Override
    public List<RelationshipDeclaration> getAllDeclarations() {
        return repo.findAll();
    }
}
