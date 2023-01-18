package com.mfadhili.cheri.service.medical_record.sub_records.interfaces;

import com.mfadhili.cheri.data.domain.medical_record.subrecords.Physique;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface PhysiqueRecService {
    Physique addMedicalRecPhysique(Long ChildId, Physique physique_record);

    Optional<Physique> getMedicalRecPhysique(Long ChildId);

    Physique updateMedicalRecPhysique(Long ChildId, Physique physique_record);

    String deleteMedicalRecPhysique(Long ChildId);
}
