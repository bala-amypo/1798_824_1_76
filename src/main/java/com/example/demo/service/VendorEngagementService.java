package com.example.demo.service;

import com.example.demo.model.VendorEngagementRecord;

import java.util.List;

public interface VendorEngagementService {

    VendorEngagementRecord addEngagement(VendorEngagementRecord r);

    List<VendorEngagementRecord> getEngagementsByEmployee(Long id);

    List<VendorEngagementRecord> getEngagementsByVendor(Long id);

    List<VendorEngagementRecord> getAllEngagements();
}
