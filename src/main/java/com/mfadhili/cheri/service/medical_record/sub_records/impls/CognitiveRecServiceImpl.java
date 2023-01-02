package com.mfadhili.cheri.service.medical_record.sub_records.impls;

import com.mfadhili.cheri.data.domain.child_caregiver.medical_record.subrecords.Cognitive_ability;
import com.mfadhili.cheri.service.medical_record.sub_records.interfaces.CognitiveRecService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CognitiveRecServiceImpl implements CognitiveRecService {
    @Override
    public Cognitive_ability addMedicalRecCognitive_ability(Long ChildId, Cognitive_ability cognitive_ability_record) {
        return null;
    }

    @Override
    public Optional<Cognitive_ability> getMedicalRecCognitive_ability(Long ChildId) {
        return Optional.empty();
    }

    @Override
    public Cognitive_ability updateMedicalRecCognitive_ability(Long ChildId, Cognitive_ability cognitive_ability_record) {
        return null;
    }

    @Override
    public String deleteMedicalRecCognitive_ability(Long ChildId) {
        return null;
    }
}
