package com.mfadhili.cheri.service.medical_record.sub_records.interfaces;

import com.mfadhili.cheri.data.domain.child_caregiver.medical_record.subrecords.Overview;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface OverviewRecService {
    Overview addMedicalRecOverview(Long ChildId, Overview overview_record);

    Optional<Overview> getMedicalRecOverview(Long ChildId);

    Overview updateMedicalRecOverview(Long ChildId, Overview overview_record);

    String deleteMedicalRecOverview(Long ChildId);
}
