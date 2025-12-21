package com.example.demo.service;

import com.example.demo.entity.VendorEngagementRecord;
import java.util.List;

public interface VendorEngagementService {
    VendorEngagementRecord addEngagement(VendorEngagementRecord record);
    List<VendorEngagementRecord> getByEmployee(Long employeeId);
    List<VendorEngagementRecord> getByVendor(Long vendorId);
    List<VendorEngagementRecord> getAll();
}
