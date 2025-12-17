package com.example.demo.service.impl;

import com.example.demo.entity.ConflictFlag;
import com.example.demo.exception.ApiException;
import com.example.demo.repository.ConflictFlagRepository;
import com.example.demo.service.ConflictFlagService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ConflictFlagServiceImpl implements ConflictFlagService {

    private final ConflictFlagRepository repo;

    public ConflictFlagServiceImpl(ConflictFlagRepository repo) {
        this.repo = repo;
    }

    public ConflictFlag addFlag(ConflictFlag f) {
        return repo.save(f);
    }

    public List<ConflictFlag> getFlagsByCase(Long id) {
        return repo.findByCaseId(id);
    }

    public ConflictFlag getFlagById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ApiException("Missing flag"));
    }

    public List<ConflictFlag> getAllFlags() {
        return repo.findAll();
    }
}