package com.example.demo.service.impl;

import com.example.demo.entity.VendorEngagementRecord;
import com.example.demo.repository.VendorEngagementRecordRepository;
import com.example.demo.service.VendorEngagementService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VendorEngagementServiceImpl implements VendorEngagementService {

    private final VendorEngagementRecordRepository repo;

    public VendorEngagementServiceImpl(VendorEngagementRecordRepository repo) {
        this.repo = repo;
    }

    public VendorEngagementRecord addEngagement(VendorEngagementRecord r) {
        return repo.save(r);
    }

    public List<VendorEngagementRecord> getEngagementsByEmployee(Long id) {
        return repo.findByEmployeeId(id);
    }

    public List<VendorEngagementRecord> getEngagementsByVendor(Long id) {
        return repo.findByVendorId(id);
    }

    public List<VendorEngagementRecord> getAllEngagements() {
        return repo.findAll();
    }
}