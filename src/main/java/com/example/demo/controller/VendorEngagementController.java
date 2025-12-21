package com.example.demo.controller;

import com.example.demo.model.VendorEngagementRecord;
import com.example.demo.service.VendorEngagementService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/engagements")
public class VendorEngagementController {

    private final VendorEngagementService engagementService;

    public VendorEngagementController(VendorEngagementService engagementService) {
        this.engagementService = engagementService;
    }

    @PostMapping
    public VendorEngagementRecord add(@RequestBody VendorEngagementRecord record) {
        return engagementService.addEngagement(record);
    }

    @GetMapping("/employee/{id}")
    public List<VendorEngagementRecord> getByEmployee(@PathVariable Long id) {
        return engagementService.getEngagementsByEmployee(id);
    }

    @GetMapping("/vendor/{id}")
    public List<VendorEngagementRecord> getByVendor(@PathVariable Long id) {
        return engagementService.getEngagementsByVendor(id);
    }

    @GetMapping
    public List<VendorEngagementRecord> getAll() {
        return engagementService.getAllEngagements();
    }
}
