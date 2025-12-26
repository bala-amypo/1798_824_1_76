package com.example.demo.repository;

import com.example.demo.model.VendorEngagementRecord;
import java.util.List;

public interface VendorEngagementRecordRepository {

    VendorEngagementRecord save(VendorEngagementRecord record);

    List<VendorEngagementRecord> findByEmployeeId(Long employeeId);

    List<VendorEngagementRecord> findByVendorId(Long vendorId);

    List<VendorEngagementRecord> findAll();
}
