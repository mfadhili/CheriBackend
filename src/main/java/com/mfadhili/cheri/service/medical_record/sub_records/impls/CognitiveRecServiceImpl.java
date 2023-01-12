package com.mfadhili.cheri.service.medical_record.sub_records.impls;

import com.mfadhili.cheri.data.domain.child_caregiver.child.Children;
import com.mfadhili.cheri.data.domain.child_caregiver.medical_record.Medical_record;
import com.mfadhili.cheri.data.domain.child_caregiver.medical_record.subrecords.Cognitive_ability;
import com.mfadhili.cheri.data.repository.ChildrenRepository;
import com.mfadhili.cheri.data.repository.medical_record.Medical_recordRepository;
import com.mfadhili.cheri.data.repository.medical_record.subRecords.Cognitive_abilityRepository;
import com.mfadhili.cheri.service.medical_record.sub_records.interfaces.CognitiveRecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CognitiveRecServiceImpl implements CognitiveRecService {

    @Autowired
    private Medical_recordRepository medical_recordRepository;
    @Autowired
    private ChildrenRepository childrenRepository;
    @Autowired
    private Cognitive_abilityRepository cognitive_abilityRepository;

    @Override
    public Cognitive_ability addMedicalRecCognitive_ability(Long ChildId, Cognitive_ability cognitive_ability_record) {
        Cognitive_ability newCognitive_ability = new Cognitive_ability();

        /** Check child exists and find their record*/
        Optional<Children> contextChild = childrenRepository.findById(ChildId);
        
        List<Medical_record> foundRecord;
        if (contextChild.isEmpty()) {
            throw new IllegalStateException("Child of Id " + ChildId + " Does not exist");
        } else {
            Children child = childrenRepository.findChildId(ChildId);
            foundRecord = medical_recordRepository.findByChildren_id(child);

            /** Adding the record from the activity payload*/
            newCognitive_ability.setMedical_record(foundRecord.get(0));
            newCognitive_ability.setMemory(cognitive_ability_record.getMemory());
            newCognitive_ability.setPlanning(cognitive_ability_record.getPlanning());
            newCognitive_ability.setOrganisational(cognitive_ability_record.getOrganisational());

            return cognitive_abilityRepository.save(newCognitive_ability);
        }
    }

    @Override
    public Optional<Cognitive_ability> getMedicalRecCognitive_ability(Long ChildId) {

        /** Check if child exists and find their record*/
        Optional<Children> contextChild = childrenRepository.findById(ChildId);

        List<Medical_record> foundMedicalRec;
        Cognitive_ability foundCognitive_ability;
        if (contextChild.isEmpty()) {
            throw new IllegalStateException("Child of Id " + ChildId + " Does not exist");
        }
        else{
            Children child = childrenRepository.findChildId(ChildId);
            foundMedicalRec = medical_recordRepository.findByChildren_id(child);
            foundCognitive_ability = cognitive_abilityRepository.findByMedical_record(foundMedicalRec.get(0));

            return Optional.ofNullable(foundCognitive_ability);
        }


    }

    @Override
    public Cognitive_ability updateMedicalRecCognitive_ability(Long ChildId, Cognitive_ability cognitive_ability_record) {

        /** Check child exists and find their record*/
        Optional<Children> contextChild = childrenRepository.findById(ChildId);

        List<Medical_record> foundRecord;
        Cognitive_ability foundCognitive_ability;
        if (contextChild.isEmpty()) {
            throw new IllegalStateException("Child of Id " + ChildId + " Does not exist");
        } else {
            Children child = childrenRepository.findChildId(ChildId);
            foundRecord = medical_recordRepository.findByChildren_id(child);
            foundCognitive_ability = cognitive_abilityRepository.findByMedical_record(foundRecord.get(0));

            /** Adding the record from the activity payload*/
            foundCognitive_ability.setMedical_record(foundRecord.get(0));
            foundCognitive_ability.setMemory(cognitive_ability_record.getMemory());
            foundCognitive_ability.setPlanning(cognitive_ability_record.getPlanning());
            foundCognitive_ability.setOrganisational(cognitive_ability_record.getOrganisational());

            return cognitive_abilityRepository.save(foundCognitive_ability);
        }
    }

    @Override
    public String deleteMedicalRecCognitive_ability(Long ChildId) {
        /** Check if child exists and find their record*/
        Optional<Children> contextChild = childrenRepository.findById(ChildId);

        List<Medical_record> foundMedicalRec;
        Cognitive_ability foundCognitive_ability;
        if (contextChild.isEmpty()) {
            throw new IllegalStateException("Child of Id " + ChildId + " Does not exist");
        }
        else{
            Children child = childrenRepository.findChildId(ChildId);
            foundMedicalRec = medical_recordRepository.findByChildren_id(child);
            foundCognitive_ability = cognitive_abilityRepository.findByMedical_record(foundMedicalRec.get(0));

            cognitive_abilityRepository.deleteById(foundCognitive_ability.getId());
        }
        return "Delete successful!";
    }
}
