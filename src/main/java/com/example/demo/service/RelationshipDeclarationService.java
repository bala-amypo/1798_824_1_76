package com.example.demo.service;

import com.example.demo.entity.RelationshipDeclaration;
import java.util.List;

public interface RelationshipDeclarationService {
    RelationshipDeclaration declareRelationship(RelationshipDeclaration d);
    List<RelationshipDeclaration> getDeclarationsByPerson(Long id);
    RelationshipDeclaration verifyDeclaration(Long id, boolean verified);
    List<RelationshipDeclaration> getAllDeclarations();
}