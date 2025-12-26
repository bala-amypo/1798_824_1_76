package com.example.demo.repository;

import com.example.demo.model.ConflictFlag;
import java.util.List;
import java.util.Optional;

public interface ConflictFlagRepository {

    ConflictFlag save(ConflictFlag flag);

    Optional<ConflictFlag> findById(Long id);

    List<ConflictFlag> findByCaseId(Long caseId);

    List<ConflictFlag> findAll();
}
