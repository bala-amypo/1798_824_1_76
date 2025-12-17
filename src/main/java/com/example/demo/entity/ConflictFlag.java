package com.example.demo.entity;


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