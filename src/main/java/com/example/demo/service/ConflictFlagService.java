package com.example.demo.service;

import com.example.demo.model.ConflictFlag;

import java.util.List;

public interface ConflictFlagService {

    ConflictFlag addFlag(ConflictFlag f);

    ConflictFlag getFlagById(Long id);

    List<ConflictFlag> getFlagsByCase(Long caseId);

    List<ConflictFlag> getAllFlags();
}
