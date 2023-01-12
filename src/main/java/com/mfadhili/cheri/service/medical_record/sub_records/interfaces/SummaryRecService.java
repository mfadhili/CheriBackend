package com.mfadhili.cheri.service.medical_record.sub_records.interfaces;

import com.mfadhili.cheri.data.domain.child_caregiver.medical_record.subrecords.Summary;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SummaryRecService {
    Summary addMedicalRecSummary(Long ChildId, Summary summary_record);

    List<Summary> getMedicalRecSummary(Long ChildId);

    Summary updateMedicalRecSummary(Long ChildId, Summary summary_record);

    String deleteMedicalRecSummary(Long ChildId);
}
