package com.example.demo.service.impl;

import com.example.demo.entity.ConflictCase;
import com.example.demo.exception.ApiException;
import com.example.demo.repository.ConflictCaseRepository;
import com.example.demo.service.ConflictCaseService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ConflictCaseServiceImpl implements ConflictCaseService {

    private final ConflictCaseRepository repo;

    public ConflictCaseServiceImpl(ConflictCaseRepository repo) {
        this.repo = repo;
    }

    public ConflictCase createCase(ConflictCase c) {
        return repo.save(c);
    }

    public ConflictCase updateCaseStatus(Long id, String status) {
        ConflictCase c = repo.findById(id)
                .orElseThrow(() -> new ApiException("Missing case"));
        c.setStatus(status);
        return repo.save(c);
    }

    public List<ConflictCase> getCasesByPerson(Long id) {
        return repo.findByPrimaryPersonIdOrSecondaryPersonId(id, id);
    }

    public ConflictCase getCaseById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ApiException("Missing case"));
    }

    public List<ConflictCase> getAllCases() {
        return repo.findAll();
    }
}