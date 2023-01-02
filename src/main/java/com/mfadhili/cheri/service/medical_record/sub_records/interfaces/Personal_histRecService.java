package com.mfadhili.cheri.service.medical_record.sub_records.interfaces;

import com.mfadhili.cheri.data.domain.child_caregiver.medical_record.subrecords.Personal_history;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface Personal_histRecService {
    Personal_history addMedicalRecPersonal_history(Long ChildId, Personal_history personal_history_record);

    Optional<Personal_history> getMedicalRecPersonal_history(Long ChildId);

    Personal_history updateMedicalRecPersonal_history(Long ChildId, Personal_history personal_history_record);

    String deleteMedicalRecPersonal_history(Long ChildId);
}
