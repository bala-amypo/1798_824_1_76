// FILE: src/main/java/com/example/demo/controller/RelationshipDeclarationController.java
package com.example.demo.controller;

import com.example.demo.entity.RelationshipDeclaration;
import com.example.demo.service.RelationshipDeclarationService;
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
@RequestMapping("/api/relationships")
@Tag(name = "Relationship Declarations")
public class RelationshipDeclarationController {

    private final RelationshipDeclarationService service;

    public RelationshipDeclarationController(
            RelationshipDeclarationService service) {
        this.service = service;
    }

    @PostMapping
    public RelationshipDeclaration declare(
            @RequestBody RelationshipDeclaration declaration) {
        return service.declareRelationship(declaration);
    }

    @GetMapping("/person/{personId}")
    public List<RelationshipDeclaration> getByPerson(
            @PathVariable Long personId) {
        return service.getDeclarationsByPerson(personId);
    }

    @PutMapping("/{id}/verify")
    public RelationshipDeclaration verify(
            @PathVariable Long id,
            @RequestParam boolean verified) {
        return service.verifyDeclaration(id, verified);
    }

    @GetMapping
    public List<RelationshipDeclaration> all() {
        return service.getAllDeclarations();
    }
}
