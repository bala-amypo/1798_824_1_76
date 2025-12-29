package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class ConflictFlag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long caseId;
    private String flagType;
    private String severity;

    // -------- getters & setters --------

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getCaseId() { return caseId; }
    public void setCaseId(Long caseId) { this.caseId = caseId; }

    public String getFlagType() { return flagType; }
    public void setFlagType(String flagType) { this.flagType = flagType; }

    public String getSeverity() { return severity; }
    public void setSeverity(String severity) { this.severity = severity; }
}

package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class ConflictCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long primaryPersonId;
    private Long secondaryPersonId;

    private String triggerSource;
    private String riskLevel;
    private String status;

    // -------- getters & setters --------

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getPrimaryPersonId() { return primaryPersonId; }
    public void setPrimaryPersonId(Long primaryPersonId) {
        this.primaryPersonId = primaryPersonId;
    }

    public Long getSecondaryPersonId() { return secondaryPersonId; }
    public void setSecondaryPersonId(Long secondaryPersonId) {
        this.secondaryPersonId = secondaryPersonId;
    }

    public String getTriggerSource() { return triggerSource; }
    public void setTriggerSource(String triggerSource) {
        this.triggerSource = triggerSource;
    }

    public String getRiskLevel() { return riskLevel; }
    public void setRiskLevel(String riskLevel) { this.riskLevel = riskLevel; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
package com.example.demo.model;

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

    // -------- getters & setters --------

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getEmployeeId() { return employeeId; }
    public void setEmployeeId(Long employeeId) { this.employeeId = employeeId; }

    public Long getVendorId() { return vendorId; }
    public void setVendorId(Long vendorId) { this.vendorId = vendorId; }

    public String getEngagementType() { return engagementType; }
    public void setEngagementType(String engagementType) {
        this.engagementType = engagementType;
    }

    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }

    public LocalDate getEngagementDate() { return engagementDate; }
    public void setEngagementDate(LocalDate engagementDate) {
        this.engagementDate = engagementDate;
    }
}
package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class RelationshipDeclaration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long personId;
    private String relatedPersonName;
    private String relationshipType;
    private Boolean isVerified = false;

    // -------- getters & setters --------

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getPersonId() { return personId; }
    public void setPersonId(Long personId) { this.personId = personId; }

    public String getRelatedPersonName() { return relatedPersonName; }
    public void setRelatedPersonName(String relatedPersonName) {
        this.relatedPersonName = relatedPersonName;
    }

    public String getRelationshipType() { return relationshipType; }
    public void setRelationshipType(String relationshipType) {
        this.relationshipType = relationshipType;
    }

    public Boolean getIsVerified() { return isVerified; }
    public void setIsVerified(Boolean isVerified) { this.isVerified = isVerified; }
}
package com.example.demo.model;

import jakarta.persistence.*;

@Entity
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

    // -------- getters & setters --------

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPersonType() { return personType; }
    public void setPersonType(String personType) { this.personType = personType; }

    public String getReferenceId() { return referenceId; }
    public void setReferenceId(String referenceId) { this.referenceId = referenceId; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public Boolean getRelationshipDeclared() { return relationshipDeclared; }
    public void setRelationshipDeclared(Boolean relationshipDeclared) {
        this.relationshipDeclared = relationshipDeclared;
    }
}

