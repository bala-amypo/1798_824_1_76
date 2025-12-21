package com.example.demo.controller;

import com.example.demo.entity.RelationshipDeclaration;
import com.example.demo.service.RelationshipDeclarationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/relationships")
public class RelationshipDeclarationController {

    private final RelationshipDeclarationService service;

    public RelationshipDeclarationController(RelationshipDeclarationService service) {
        this.service = service;
    }

    @PostMapping
    public RelationshipDeclaration declare(@RequestBody RelationshipDeclaration d) {
        return service.declareRelationship(d);
    }

    @GetMapping("/person/{personId}")
    public List<RelationshipDeclaration> byPerson(@PathVariable Long personId) {
        return service.getDeclarationsByPerson(personId);
    }

    @PutMapping("/{id}/verify")
    public RelationshipDeclaration verify(@PathVariable Long id,
                                          @RequestParam Boolean verified) {
        return service.verifyDeclaration(id, verified);
    }

    @GetMapping
    public List<RelationshipDeclaration> all() {
        return service.getAllDeclarations();
    }
}
