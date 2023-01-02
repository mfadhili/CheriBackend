package com.mfadhili.cheri.service.medical_record.sub_records.impls;

import com.mfadhili.cheri.data.domain.child_caregiver.medical_record.subrecords.Personal_history;
import com.mfadhili.cheri.service.medical_record.sub_records.interfaces.Personal_histRecService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Personal_histRecServiceImpl implements Personal_histRecService {
    @Override
    public Personal_history addMedicalRecPersonal_history(Long ChildId, Personal_history personal_history_record) {
        return null;
    }

    @Override
    public Optional<Personal_history> getMedicalRecPersonal_history(Long ChildId) {
        return Optional.empty();
    }

    @Override
    public Personal_history updateMedicalRecPersonal_history(Long ChildId, Personal_history personal_history_record) {
        return null;
    }

    @Override
    public String deleteMedicalRecPersonal_history(Long ChildId) {
        return null;
    }
}
