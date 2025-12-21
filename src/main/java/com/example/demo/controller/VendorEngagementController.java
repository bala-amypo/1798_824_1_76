// FILE: src/main/java/com/example/demo/controller/VendorEngagementController.java
package com.example.demo.controller;

import com.example.demo.entity.VendorEngagementRecord;
import com.example.demo.service.VendorEngagementService;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/engagements")
@Tag(name = "Vendor Engagements")
public class VendorEngagementController {

    private final VendorEngagementService service;

    public VendorEngagementController(
            VendorEngagementService service) {
        this.service = service;
    }

    @PostMapping
    public VendorEngagementRecord add(
            @RequestBody VendorEngagementRecord record) {
        return service.addEngagement(record);
    }

    @GetMapping("/employee/{employeeId}")
    public List<VendorEngagementRecord> byEmployee(
            @PathVariable Long employeeId) {
        return service.getEngagementsByEmployee(employeeId);
    }

    @GetMapping("/vendor/{vendorId}")
    public List<VendorEngagementRecord> byVendor(
            @PathVariable Long vendorId) {
        return service.getEngagementsByVendor(vendorId);
    }

    @GetMapping
    public List<VendorEngagementRecord> all() {
        return service.getAllEngagements();
    }
}
