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

    @Override
    public ConflictCase createCase(ConflictCase c) {
        return repo.save(c);
    }

    @Override
    public ConflictCase updateStatus(Long caseId, String status) {
        ConflictCase c = repo.findById(caseId)
                .orElseThrow(() -> new ApiException("case"));
        c.setStatus(status);
        return repo.save(c);
    }

    @Override
    public List<ConflictCase> getByPerson(Long personId) {
        return repo.findByPrimaryPersonIdOrSecondaryPersonId(personId, personId);
    }

    @Override
    public ConflictCase getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ApiException("case"));
    }

    @Override
    public List<ConflictCase> getAll() {
        return repo.findAll();
    }
}
    