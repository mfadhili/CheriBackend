package com.mfadhili.cheri.service.medical_record.sub_records.interfaces;

import com.mfadhili.cheri.data.domain.child_caregiver.medical_record.subrecords.Occup_therapy;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface Occup_therapyRecService {
    Occup_therapy addMedicalRecOccup_therapy(Long ChildId, Occup_therapy occup_therapy_record);

    Optional<Occup_therapy> getMedicalRecOccup_therapy(Long ChildId);

    Occup_therapy updateMedicalRecOccup_therapy(Long ChildId, Occup_therapy occup_therapy_record);

    String deleteMedicalRecOccup_therapy(Long ChildId);
}
