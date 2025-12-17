package com.example.demo.service.impl;

import com.example.demo.entity.RelationshipDeclaration;
import com.example.demo.exception.ApiException;
import com.example.demo.repository.RelationshipDeclarationRepository;
import com.example.demo.service.RelationshipDeclarationService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RelationshipDeclarationServiceImpl
        implements RelationshipDeclarationService {

    private final RelationshipDeclarationRepository repo;

    public RelationshipDeclarationServiceImpl(RelationshipDeclarationRepository repo) {
        this.repo = repo;
    }

    public RelationshipDeclaration declareRelationship(RelationshipDeclaration d) {
        return repo.save(d);
    }

    public List<RelationshipDeclaration> getDeclarationsByPerson(Long id) {
        return repo.findByPersonId(id);
    }

    public RelationshipDeclaration verifyDeclaration(Long id, boolean verified) {
        RelationshipDeclaration d = repo.findById(id)
                .orElseThrow(() -> new ApiException("Missing person"));
        d.setIsVerified(verified);
        return repo.save(d);
    }

    public List<RelationshipDeclaration> getAllDeclarations() {
        return repo.findAll();
    }
}