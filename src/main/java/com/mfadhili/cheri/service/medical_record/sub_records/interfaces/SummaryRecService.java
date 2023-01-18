package com.mfadhili.cheri.service.medical_record.sub_records.interfaces;

import com.mfadhili.cheri.data.domain.medical_record.subrecords.Summary;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface SummaryRecService {
    Summary addMedicalRecSummary(Long ChildId, Summary summary_record);

    Optional<Summary> getMedicalRecSummary(Long ChildId);

    Summary updateMedicalRecSummary(Long ChildId, Summary summary_record);

    String deleteMedicalRecSummary(Long ChildId);
}
