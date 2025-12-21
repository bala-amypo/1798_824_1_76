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

    @Override
    public VendorEngagementRecord addEngagement(VendorEngagementRecord record) {
        return repo.save(record);
    }

    @Override
    public List<VendorEngagementRecord> getByEmployee(Long employeeId) {
        return repo.findByEmployeeId(employeeId);
    }

    @Override
    public List<VendorEngagementRecord> getByVendor(Long vendorId) {
        return repo.findByVendorId(vendorId);
    }

    @Override
    public List<VendorEngagementRecord> getAll() {
        return repo.findAll();
    }
}
    