// FILE: src/main/java/com/example/demo/controller/ConflictFlagController.java
package com.example.demo.controller;

import com.example.demo.entity.ConflictFlag;
import com.example.demo.service.ConflictFlagService;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/conflict-flags")
@Tag(name = "Conflict Flags")
public class ConflictFlagController {

    private final ConflictFlagService service;

    public ConflictFlagController(
            ConflictFlagService service) {
        this.service = service;
    }

    @PostMapping
    public ConflictFlag add(@RequestBody ConflictFlag flag) {
        return service.addFlag(flag);
    }

    @GetMapping("/case/{caseId}")
    public List<ConflictFlag> byCase(
            @PathVariable Long caseId) {
        return service.getFlagsByCase(caseId);
    }

    @GetMapping("/{id}")
    public ConflictFlag get(@PathVariable Long id) {
        return service.getFlagById(id);
    }

    @GetMapping
    public List<ConflictFlag> all() {
        return service.getAllFlags();
    }
}
