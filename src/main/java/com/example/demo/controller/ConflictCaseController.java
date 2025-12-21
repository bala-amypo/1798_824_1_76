package com.example.demo.controller;

import com.example.demo.entity.ConflictCase;
import com.example.demo.service.ConflictCaseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return service.updateStatus(id, status);
    }

    @GetMapping("/person/{personId}")
    public List<ConflictCase> byPerson(@PathVariable Long personId) {
        return service.getByPerson(personId);
    }

    @GetMapping("/{id}")
    public ConflictCase get(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<ConflictCase> all() {
        return service.getAll();
    }
}
