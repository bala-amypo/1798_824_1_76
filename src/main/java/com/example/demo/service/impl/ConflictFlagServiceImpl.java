package com.example.demo.service.impl;

import com.example.demo.exception.ApiException;
import com.example.demo.model.ConflictCase;
import com.example.demo.model.ConflictFlag;
import com.example.demo.repository.ConflictCaseRepository;
import com.example.demo.repository.ConflictFlagRepository;
import com.example.demo.service.ConflictFlagService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConflictFlagServiceImpl implements ConflictFlagService {

    private final ConflictFlagRepository repo;
    private final ConflictCaseRepository caseRepo;

    public ConflictFlagServiceImpl(ConflictFlagRepository repo,
                                   ConflictCaseRepository caseRepo) {
        this.repo = repo;
        this.caseRepo = caseRepo;
    }

    @Override
    public ConflictFlag addFlag(ConflictFlag f) {
        ConflictCase c = caseRepo.findById(f.getCaseId())
                .orElseThrow(() -> new ApiException("Case not found"));

        ConflictFlag saved = repo.save(f);

        if ("HIGH".equalsIgnoreCase(f.getSeverity())) {
            c.setRiskLevel("HIGH");
            caseRepo.save(c);
        }

        return saved;
    }

    @Override
    public ConflictFlag getFlagById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ApiException("Flag not found"));
    }

    @Override
    public List<ConflictFlag> getFlagsByCase(Long caseId) {
        return repo.findByCaseId(caseId);
    }

    @Override
    public List<ConflictFlag> getAllFlags() {
        return repo.findAll();
    }
}
