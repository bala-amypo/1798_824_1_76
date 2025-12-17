package com.example.demo.service;

import com.example.demo.entity.ConflictCase;
import java.util.List;

public interface ConflictCaseService {
    ConflictCase createCase(ConflictCase c);
    ConflictCase updateCaseStatus(Long id, String status);
    List<ConflictCase> getCasesByPerson(Long id);
    ConflictCase getCaseById(Long id);
    List<ConflictCase> getAllCases();
}