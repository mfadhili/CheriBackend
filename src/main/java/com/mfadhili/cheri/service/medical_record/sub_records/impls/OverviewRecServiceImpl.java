package com.mfadhili.cheri.service.medical_record.sub_records.impls;

import com.mfadhili.cheri.data.domain.child_caregiver.medical_record.subrecords.Overview;
import com.mfadhili.cheri.service.medical_record.sub_records.interfaces.OverviewRecService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OverviewRecServiceImpl implements OverviewRecService {
    @Override
    public Overview addMedicalRecOverview(Long ChildId, Overview overview_record) {
        return null;
    }

    @Override
    public Optional<Overview> getMedicalRecOverview(Long ChildId) {
        return Optional.empty();
    }

    @Override
    public Overview updateMedicalRecOverview(Long ChildId, Overview overview_record) {
        return null;
    }

    @Override
    public String deleteMedicalRecOverview(Long ChildId) {
        return null;
    }
}
