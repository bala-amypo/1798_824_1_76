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

    @Override
    public ConflictFlag addFlag(ConflictFlag flag) {
        return repo.save(flag);
    }

    @Override
    public List<ConflictFlag> getByCase(Long caseId) {
        return repo.findByCaseId(caseId);
    }

    @Override
    public ConflictFlag getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ApiException("flag"));
    }

    @Override
    public List<ConflictFlag> getAll() {
        return repo.findAll();
    }
}
