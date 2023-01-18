package com.mfadhili.cheri.service.medical_record.sub_records.interfaces;

import com.mfadhili.cheri.data.domain.medical_record.subrecords.Cognitive_ability;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface CognitiveRecService {

    Cognitive_ability addMedicalRecCognitive_ability(Long ChildId, Cognitive_ability cognitive_ability_record);

    Optional<Cognitive_ability> getMedicalRecCognitive_ability(Long ChildId);

    Cognitive_ability updateMedicalRecCognitive_ability(Long ChildId, Cognitive_ability cognitive_ability_record);

    String deleteMedicalRecCognitive_ability(Long ChildId);
}
