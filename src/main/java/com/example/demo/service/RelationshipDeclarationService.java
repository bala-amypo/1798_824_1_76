package com.example.demo.service;

import com.example.demo.entity.RelationshipDeclaration;
import java.util.List;

public interface RelationshipDeclarationService {
    RelationshipDeclaration declareRelationship(RelationshipDeclaration declaration);
    List<RelationshipDeclaration> getDeclarationsByPerson(Long personId);
    RelationshipDeclaration verifyDeclaration(Long declarationId, Boolean verified);
    List<RelationshipDeclaration> getAllDeclarations();
}
