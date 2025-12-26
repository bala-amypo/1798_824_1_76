package com.example.demo.controller;

import com.example.demo.model.ConflictCase;
import com.example.demo.service.ConflictCaseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/conflict-cases")
public class ConflictCaseController {

    private final ConflictCaseService service;

    public ConflictCaseController(ConflictCaseService service) {
        this.service = service;
    }

    @PostMapping
    public ConflictCase create(@RequestBody ConflictCase c) {
        return service.createCase(c);
    }

    @PutMapping("/{id}/status")
    public ConflictCase updateStatus(@PathVariable Long id,
                                     @RequestParam String status) {
        return service.updateCaseStatus(id, status);
    }

    @GetMapping("/person/{personId}")
    public List<ConflictCase> byPerson(@PathVariable Long personId) {
        return service.getCasesByPerson(personId);
    }

    @GetMapping("/{id}")
    public Optional<ConflictCase> get(@PathVariable Long id) {
        return service.getCaseById(id);
    }

    @GetMapping
    public List<ConflictCase> all() {
        return service.getAllCases();
    }
}
