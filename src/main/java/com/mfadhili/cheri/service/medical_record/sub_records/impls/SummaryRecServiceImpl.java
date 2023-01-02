package com.mfadhili.cheri.service.medical_record.sub_records.impls;

import com.mfadhili.cheri.data.domain.child_caregiver.medical_record.subrecords.Summary;
import com.mfadhili.cheri.service.medical_record.sub_records.interfaces.SummaryRecService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SummaryRecServiceImpl implements SummaryRecService {
    @Override
    public Summary addMedicalRecSummary(Long ChildId, Summary summary_record) {
        return null;
    }

    @Override
    public Optional<Summary> getMedicalRecSummary(Long ChildId) {
        return Optional.empty();
    }

    @Override
    public Summary updateMedicalRecSummary(Long ChildId, Summary summary_record) {
        return null;
    }

    @Override
    public String deleteMedicalRecSummary(Long ChildId) {
        return null;
    }
}
