package com.example.demo.service;

import com.example.demo.entity.ConflictFlag;
import java.util.List;

public interface ConflictFlagService {
    ConflictFlag addFlag(ConflictFlag flag);
    List<ConflictFlag> getByCase(Long caseId);
    ConflictFlag getById(Long id);
    List<ConflictFlag> getAll();
}
    