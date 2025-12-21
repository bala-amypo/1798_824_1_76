// FILE: src/main/java/com/example/demo/controller/ConflictCaseController.java
package com.example.demo.controller;

import com.example.demo.entity.ConflictCase;
import com.example.demo.service.ConflictCaseService;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/conflict-cases")
@Tag(name = "Conflict Cases")
public class ConflictCaseController {

    private final ConflictCaseService service;

    public ConflictCaseController(
            ConflictCaseService service) {
        this.service = service;
    }

    @PostMapping
    public ConflictCase create(@RequestBody ConflictCase conflictCase) {
        return service.createCase(conflictCase);
    }

    @PutMapping("/{id}/status")
    public ConflictCase updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        return service.updateCaseStatus(id, status);
    }

    @GetMapping("/person/{personId}")
    public List<ConflictCase> byPerson(
            @PathVariable Long personId) {
        return service.getCasesByPerson(personId);
    }

    @GetMapping("/{id}")
    public ConflictCase get(@PathVariable Long id) {
        return service.getCaseById(id);
    }

    @GetMapping
    public List<ConflictCase> all() {
        return service.getAllCases();
    }
}
