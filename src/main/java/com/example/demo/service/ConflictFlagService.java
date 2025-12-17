package com.example.demo.service;

import com.example.demo.entity.ConflictFlag;
import java.util.List;

public interface ConflictFlagService {
    ConflictFlag addFlag(ConflictFlag f);
    List<ConflictFlag> getFlagsByCase(Long id);
    ConflictFlag getFlagById(Long id);
    List<ConflictFlag> getAllFlags();
}