package com.example.demo.service.impl;

import com.example.demo.entity.PersonProfile;
import com.example.demo.entity.RelationshipDeclaration;
import com.example.demo.exception.ApiException;
import com.example.demo.repository.PersonProfileRepository;
import com.example.demo.repository.RelationshipDeclarationRepository;
import com.example.demo.service.RelationshipDeclarationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelationshipDeclarationServiceImpl
        implements RelationshipDeclarationService {

    private final RelationshipDeclarationRepository declarationRepo;
    private final PersonProfileRepository personRepo;

    public RelationshipDeclarationServiceImpl(
            RelationshipDeclarationRepository declarationRepo,
            PersonProfileRepository personRepo) {
        this.declarationRepo = declarationRepo;
        this.personRepo = personRepo;
    }

    @Override
    public RelationshipDeclaration declareRelationship(RelationshipDeclaration d) {
        PersonProfile person = personRepo.findById(d.getPersonId())
                .orElseThrow(() -> new ApiException("person"));

        person.setRelationshipDeclared(true);
        personRepo.save(person);

        return declarationRepo.save(d);
    }

    @Override
    public List<RelationshipDeclaration> getDeclarationsByPerson(Long personId) {
        return declarationRepo.findByPersonId(personId);
    }

    @Override
    public RelationshipDeclaration verifyDeclaration(Long declarationId, Boolean verified) {
        RelationshipDeclaration d = declarationRepo.findById(declarationId)
                .orElseThrow(() -> new ApiException("declaration"));

        d.setIsVerified(verified);
        return declarationRepo.save(d);
    }

    @Override
    public List<RelationshipDeclaration> getAllDeclarations() {
        return declarationRepo.findAll();
    }
}
