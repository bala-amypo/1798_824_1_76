package com.example.demo.controller;

import com.example.demo.model.ConflictCase;
import com.example.demo.service.ConflictCaseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conflict-cases")
public class ConflictCaseController {

    private final ConflictCaseService conflictCaseService;

    public ConflictCaseController(ConflictCaseService conflictCaseService) {
        this.conflictCaseService = conflictCaseService;
    }

    @PostMapping
    public ConflictCase create(@RequestBody ConflictCase conflictCase) {
        return conflictCaseService.createCase(conflictCase);
    }

    @PutMapping("/{id}/status")
    public ConflictCase updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        return conflictCaseService.updateCaseStatus(id, status);
    }

    @GetMapping("/{id}")
    public ConflictCase getById(@PathVariable Long id) {
        return conflictCaseService.getCaseById(id);
    }

    @GetMapping("/person/{personId}")
    public List<ConflictCase> getByPerson(@PathVariable Long personId) {
        return conflictCaseService.getCasesByPerson(personId);
    }

    @GetMapping
    public List<ConflictCase> getAll() {
        return conflictCaseService.getAllCases();
    }
}
