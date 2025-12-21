package com.example.demo.repository;

import com.example.demo.entity.ConflictCase;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ConflictCaseRepository
        extends JpaRepository<ConflictCase, Long> {
    List<ConflictCase> findByPrimaryPersonIdOrSecondaryPersonId(Long a, Long b);
}
