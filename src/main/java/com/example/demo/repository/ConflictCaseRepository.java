package com.example.demo.repository;

import com.example.demo.model.ConflictCase;
import java.util.List;
import java.util.Optional;

public interface ConflictCaseRepository {

    ConflictCase save(ConflictCase conflictCase);

    Optional<ConflictCase> findById(Long id);

    List<ConflictCase> findByPrimaryPersonIdOrSecondaryPersonId(Long p1, Long p2);

    List<ConflictCase> findAll();
}
