package com.mfadhili.cheri.service.medical_record.sub_records.impls;

import com.mfadhili.cheri.data.domain.child_caregiver.medical_record.subrecords.Occup_therapy;
import com.mfadhili.cheri.service.medical_record.sub_records.interfaces.Occup_therapyRecService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Occup_therapyRecServiceImpl implements Occup_therapyRecService {
    @Override
    public Occup_therapy addMedicalRecOccup_therapy(Long ChildId, Occup_therapy occup_therapy_record) {
        return null;
    }

    @Override
    public Optional<Occup_therapy> getMedicalRecOccup_therapy(Long ChildId) {
        return Optional.empty();
    }

    @Override
    public Occup_therapy updateMedicalRecOccup_therapy(Long ChildId, Occup_therapy occup_therapy_record) {
        return null;
    }

    @Override
    public String deleteMedicalRecOccup_therapy(Long ChildId) {
        return null;
    }
}
