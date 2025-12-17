// ======================================================
// FILE: src/main/java/com/example/demo/DemoApplication.java
// ======================================================
package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
// ======================================================
// FILE: src/main/java/com/example/demo/exception/ApiException.java
// ======================================================
package com.example.demo.exception;

public class ApiException extends RuntimeException {
    public ApiException(String message) {
        super(message);
    }
}
===================== ENTITIES =====================
// FILE: src/main/java/com/example/demo/entity/PersonProfile.java
package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = "email"),
        @UniqueConstraint(columnNames = "referenceId")
})
public class PersonProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String personType;
    private String referenceId;
    private String fullName;
    private String email;
    private String department;

    private Boolean relationshipDeclared = false;
    private LocalDateTime createdAt = LocalDateTime.now();

    public Long getId() { return id; }
    public String getReferenceId() { return referenceId; }
    public void setReferenceId(String referenceId) { this.referenceId = referenceId; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public Boolean getRelationshipDeclared() { return relationshipDeclared; }
    public void setRelationshipDeclared(Boolean relationshipDeclared) {
        this.relationshipDeclared = relationshipDeclared;
    }
}
// FILE: src/main/java/com/example/demo/entity/RelationshipDeclaration.java
package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class RelationshipDeclaration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long personId;
    private String relatedPersonName;
    private String relationshipType;
    private String description;

    private Boolean isVerified = false;
    private LocalDateTime declaredAt = LocalDateTime.now();

    public Long getId() { return id; }
    public Long getPersonId() { return personId; }
    public void setIsVerified(Boolean verified) { isVerified = verified; }
}
// FILE: src/main/java/com/example/demo/entity/VendorEngagementRecord.java
package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class VendorEngagementRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long employeeId;
    private Long vendorId;
    private String engagementType;
    private Double amount;
    private LocalDate engagementDate;
    private String notes;

    public Long getId() { return id; }
}
// FILE: src/main/java/com/example/demo/entity/ConflictCase.java
package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ConflictCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long primaryPersonId;
    private Long secondaryPersonId;
    private String triggerSource;
    private String riskLevel;
    private String details;

    private String status = "OPEN";
    private LocalDateTime detectedAt = LocalDateTime.now();

    public Long getId() { return id; }
    public void setStatus(String status) { this.status = status; }
}
// FILE: src/main/java/com/example/demo/entity/ConflictFlag.java
package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ConflictFlag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long caseId;
    private String flagType;
    private String description;
    private String severity;
    private LocalDateTime flaggedAt = LocalDateTime.now();

    public Long getId() { return id; }
}
===================== REPOSITORIES =====================
// FILE: src/main/java/com/example/demo/repository/PersonProfileRepository.java
package com.example.demo.repository;

import com.example.demo.entity.PersonProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PersonProfileRepository extends JpaRepository<PersonProfile, Long> {
    Optional<PersonProfile> findByEmail(String email);
    Optional<PersonProfile> findByReferenceId(String refId);
}
// FILE: src/main/java/com/example/demo/repository/RelationshipDeclarationRepository.java
package com.example.demo.repository;

import com.example.demo.entity.RelationshipDeclaration;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RelationshipDeclarationRepository
        extends JpaRepository<RelationshipDeclaration, Long> {
    List<RelationshipDeclaration> findByPersonId(Long personId);
}
// FILE: src/main/java/com/example/demo/repository/VendorEngagementRecordRepository.java
package com.example.demo.repository;

import com.example.demo.entity.VendorEngagementRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VendorEngagementRecordRepository
        extends JpaRepository<VendorEngagementRecord, Long> {
    List<VendorEngagementRecord> findByEmployeeId(Long id);
    List<VendorEngagementRecord> findByVendorId(Long id);
}
// FILE: src/main/java/com/example/demo/repository/ConflictCaseRepository.java
package com.example.demo.repository;

import com.example.demo.entity.ConflictCase;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ConflictCaseRepository
        extends JpaRepository<ConflictCase, Long> {
    List<ConflictCase> findByPrimaryPersonIdOrSecondaryPersonId(Long a, Long b);
}
// FILE: src/main/java/com/example/demo/repository/ConflictFlagRepository.java
package com.example.demo.repository;

import com.example.demo.entity.ConflictFlag;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ConflictFlagRepository
        extends JpaRepository<ConflictFlag, Long> {
    List<ConflictFlag> findByCaseId(Long id);
}
===================== SERVICES =====================
// FILE: src/main/java/com/example/demo/service/PersonProfileService.java
package com.example.demo.service;

import com.example.demo.entity.PersonProfile;
import java.util.List;

public interface PersonProfileService {
    PersonProfile createPerson(PersonProfile p);
    PersonProfile getPersonById(Long id);
    List<PersonProfile> getAllPersons();
    PersonProfile findByReferenceId(String ref);
    PersonProfile updateRelationshipDeclared(Long id, boolean declared);
}
// FILE: src/main/java/com/example/demo/service/RelationshipDeclarationService.java
package com.example.demo.service;

import com.example.demo.entity.RelationshipDeclaration;
import java.util.List;

public interface RelationshipDeclarationService {
    RelationshipDeclaration declareRelationship(RelationshipDeclaration d);
    List<RelationshipDeclaration> getDeclarationsByPerson(Long id);
    RelationshipDeclaration verifyDeclaration(Long id, boolean verified);
    List<RelationshipDeclaration> getAllDeclarations();
}
// FILE: src/main/java/com/example/demo/service/VendorEngagementService.java
package com.example.demo.service;

import com.example.demo.entity.VendorEngagementRecord;
import java.util.List;

public interface VendorEngagementService {
    VendorEngagementRecord addEngagement(VendorEngagementRecord r);
    List<VendorEngagementRecord> getEngagementsByEmployee(Long id);
    List<VendorEngagementRecord> getEngagementsByVendor(Long id);
    List<VendorEngagementRecord> getAllEngagements();
}
// FILE: src/main/java/com/example/demo/service/ConflictCaseService.java
package com.example.demo.service;

import com.example.demo.entity.ConflictCase;
import java.util.List;

public interface ConflictCaseService {
    ConflictCase createCase(ConflictCase c);
    ConflictCase updateCaseStatus(Long id, String status);
    List<ConflictCase> getCasesByPerson(Long id);
    ConflictCase getCaseById(Long id);
    List<ConflictCase> getAllCases();
}
// FILE: src/main/java/com/example/demo/service/ConflictFlagService.java
package com.example.demo.service;

import com.example.demo.entity.ConflictFlag;
import java.util.List;

public interface ConflictFlagService {
    ConflictFlag addFlag(ConflictFlag f);
    List<ConflictFlag> getFlagsByCase(Long id);
    ConflictFlag getFlagById(Long id);
    List<ConflictFlag> getAllFlags();
}
===================== SERVICE IMPLEMENTATIONS =====================
// FILE: src/main/java/com/example/demo/service/impl/PersonProfileServiceImpl.java
package com.example.demo.service.impl;

import com.example.demo.entity.PersonProfile;
import com.example.demo.exception.ApiException;
import com.example.demo.repository.PersonProfileRepository;
import com.example.demo.service.PersonProfileService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PersonProfileServiceImpl implements PersonProfileService {

    private final PersonProfileRepository repo;

    public PersonProfileServiceImpl(PersonProfileRepository repo) {
        this.repo = repo;
    }

    public PersonProfile createPerson(PersonProfile p) {
        if (repo.findByEmail(p.getEmail()).isPresent())
            throw new ApiException("Duplicate email");
        if (repo.findByReferenceId(p.getReferenceId()).isPresent())
            throw new ApiException("Duplicate reference");
        return repo.save(p);
    }

    public PersonProfile getPersonById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ApiException("Missing person"));
    }

    public List<PersonProfile> getAllPersons() {
        return repo.findAll();
    }

    public PersonProfile findByReferenceId(String ref) {
        return repo.findByReferenceId(ref)
                .orElseThrow(() -> new ApiException("Missing person"));
    }

    public PersonProfile updateRelationshipDeclared(Long id, boolean declared) {
        PersonProfile p = getPersonById(id);
        p.setRelationshipDeclared(declared);
        return repo.save(p);
    }
}
// FILE: src/main/java/com/example/demo/service/impl/RelationshipDeclarationServiceImpl.java
package com.example.demo.service.impl;

import com.example.demo.entity.RelationshipDeclaration;
import com.example.demo.exception.ApiException;
import com.example.demo.repository.RelationshipDeclarationRepository;
import com.example.demo.service.RelationshipDeclarationService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RelationshipDeclarationServiceImpl
        implements RelationshipDeclarationService {

    private final RelationshipDeclarationRepository repo;

    public RelationshipDeclarationServiceImpl(RelationshipDeclarationRepository repo) {
        this.repo = repo;
    }

    public RelationshipDeclaration declareRelationship(RelationshipDeclaration d) {
        return repo.save(d);
    }

    public List<RelationshipDeclaration> getDeclarationsByPerson(Long id) {
        return repo.findByPersonId(id);
    }

    public RelationshipDeclaration verifyDeclaration(Long id, boolean verified) {
        RelationshipDeclaration d = repo.findById(id)
                .orElseThrow(() -> new ApiException("Missing person"));
        d.setIsVerified(verified);
        return repo.save(d);
    }

    public List<RelationshipDeclaration> getAllDeclarations() {
        return repo.findAll();
    }
}
// FILE: src/main/java/com/example/demo/service/impl/VendorEngagementServiceImpl.java
package com.example.demo.service.impl;

import com.example.demo.entity.VendorEngagementRecord;
import com.example.demo.repository.VendorEngagementRecordRepository;
import com.example.demo.service.VendorEngagementService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VendorEngagementServiceImpl implements VendorEngagementService {

    private final VendorEngagementRecordRepository repo;

    public VendorEngagementServiceImpl(VendorEngagementRecordRepository repo) {
        this.repo = repo;
    }

    public VendorEngagementRecord addEngagement(VendorEngagementRecord r) {
        return repo.save(r);
    }

    public List<VendorEngagementRecord> getEngagementsByEmployee(Long id) {
        return repo.findByEmployeeId(id);
    }

    public List<VendorEngagementRecord> getEngagementsByVendor(Long id) {
        return repo.findByVendorId(id);
    }

    public List<VendorEngagementRecord> getAllEngagements() {
        return repo.findAll();
    }
}
// FILE: src/main/java/com/example/demo/service/impl/ConflictCaseServiceImpl.java
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
// FILE: src/main/java/com/example/demo/service/impl/ConflictFlagServiceImpl.java
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
