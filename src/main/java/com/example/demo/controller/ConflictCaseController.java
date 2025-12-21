package com.example.demo.controller;

import com.example.demo.model.ConflictCase;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/conflict-cases")
public class ConflictCaseController {

    // Temporary in-memory list (until service + repository are added)
    private final List<ConflictCase> conflictCases = new ArrayList<>();

    // CREATE
    @PostMapping
    public ConflictCase createConflictCase(@RequestBody ConflictCase conflictCase) {
        conflictCases.add(conflictCase);
        return conflictCase;
    }

    // READ ALL
    @GetMapping
    public List<ConflictCase> getAllConflictCases() {
        return conflictCases;
    }

    // READ BY INDEX (temporary)
    @GetMapping("/{index}")
    public ConflictCase getConflictCase(@PathVariable int index) {
        return conflictCases.get(index);
    }

    // UPDATE STATUS
    @PutMapping("/{index}/status")
    public ConflictCase updateStatus(
            @PathVariable int index,
            @RequestParam String status) {

        ConflictCase conflictCase = conflictCases.get(index);
        conflictCase.setStatus(status);
        return conflictCase;
    }
}
