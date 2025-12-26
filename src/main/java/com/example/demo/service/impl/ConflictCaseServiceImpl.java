package com.example.demo.service.impl;

import com.example.demo.exception.ApiException;
import com.example.demo.model.ConflictCase;
import com.example.demo.repository.ConflictCaseRepository;
import com.example.demo.repository.ConflictFlagRepository;
import com.example.demo.service.ConflictCaseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service 
public class ConflictCaseServiceImpl implements ConflictCaseService {

    private final ConflictCaseRepository caseRepo;
    private final ConflictFlagRepository flagRepo;

    public ConflictCaseServiceImpl(ConflictCaseRepository caseRepo,
                                   ConflictFlagRepository flagRepo) {
        this.caseRepo = caseRepo;
        this.flagRepo = flagRepo;
    }

    @Override
    public ConflictCase createCase(ConflictCase c) {
        if (c.getStatus() == null) {
            c.setStatus("OPEN");
        }
        return caseRepo.save(c);
    }

    @Override
    public ConflictCase updateCaseStatus(Long id, String status) {
        ConflictCase c = caseRepo.findById(id)
                .orElseThrow(() -> new ApiException("Case not found"));
        c.setStatus(status);
        return caseRepo.save(c);
    }

    @Override
    public List<ConflictCase> getCasesByPerson(Long personId) {
        return caseRepo.findByPrimaryPersonIdOrSecondaryPersonId(personId, personId);
    }

    @Override
    public Optional<ConflictCase> getCaseById(Long id) {
        return caseRepo.findById(id);
    }

    @Override
    public List<ConflictCase> getAllCases() {
        return caseRepo.findAll();
    }
}
