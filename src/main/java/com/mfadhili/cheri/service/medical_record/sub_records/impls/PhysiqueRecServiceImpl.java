package com.mfadhili.cheri.service.medical_record.sub_records.impls;

import com.mfadhili.cheri.data.domain.child_caregiver.medical_record.subrecords.Physique;
import com.mfadhili.cheri.service.medical_record.sub_records.interfaces.PhysiqueRecService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PhysiqueRecServiceImpl implements PhysiqueRecService {
    @Override
    public Physique addMedicalRecPhysique(Long ChildId, Physique physique_record) {
        return null;
    }

    @Override
    public Optional<Physique> getMedicalRecPhysique(Long ChildId) {
        return Optional.empty();
    }

    @Override
    public Physique updateMedicalRecPhysique(Long ChildId, Physique physique_record) {
        return null;
    }

    @Override
    public String deleteMedicalRecPhysique(Long ChildId) {
        return null;
    }
}
