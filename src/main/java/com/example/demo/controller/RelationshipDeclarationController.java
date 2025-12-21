package com.example.demo.controller;

import com.example.demo.model.RelationshipDeclaration;
import com.example.demo.service.RelationshipDeclarationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/relationships")
public class RelationshipDeclarationController {

    private final RelationshipDeclarationService relationshipService;

    public RelationshipDeclarationController(RelationshipDeclarationService relationshipService) {
        this.relationshipService = relationshipService;
    }

    @PostMapping
    public RelationshipDeclaration declare(@RequestBody RelationshipDeclaration declaration) {
        return relationshipService.declareRelationship(declaration);
    }

    @GetMapping("/person/{personId}")
    public List<RelationshipDeclaration> getByPerson(@PathVariable Long personId) {
        return relationshipService.getDeclarationsByPerson(personId);
    }

    @PutMapping("/{id}/verify")
    public RelationshipDeclaration verify(
            @PathVariable Long id,
            @RequestParam boolean verified) {
        return relationshipService.verifyDeclaration(id, verified);
    }

    @GetMapping
    public List<RelationshipDeclaration> getAll() {
        return relationshipService.getAllDeclarations();
    }
}
