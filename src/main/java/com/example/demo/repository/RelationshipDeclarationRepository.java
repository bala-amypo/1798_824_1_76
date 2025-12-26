package com.example.demo.repository;

import com.example.demo.model.RelationshipDeclaration;
import java.util.List;
import java.util.Optional;

public interface RelationshipDeclarationRepository {

    Optional<RelationshipDeclaration> findById(Long id);

    List<RelationshipDeclaration> findByPersonId(Long personId);

    List<RelationshipDeclaration> findAll();

    RelationshipDeclaration save(RelationshipDeclaration declaration);
}
