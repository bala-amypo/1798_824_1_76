package com.example.demo.entity;

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