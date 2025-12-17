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