package com.example.demo.service;

import com.example.demo.entity.ConflictCase;
import java.util.List;

public interface ConflictCaseService {
    ConflictCase createCase(ConflictCase conflictCase);
    ConflictCase updateStatus(Long caseId, String status);
    List<ConflictCase> getByPerson(Long personId);
    ConflictCase getById(Long id);
    List<ConflictCase> getAll();
}
