package com.mfadhili.cheri.service.medical_record.sub_records.impls;

import com.mfadhili.cheri.data.domain.child_caregiver.child.Children;
import com.mfadhili.cheri.data.domain.child_caregiver.medical_record.Medical_record;
import com.mfadhili.cheri.data.domain.child_caregiver.medical_record.subrecords.Occup_therapy;
import com.mfadhili.cheri.data.repository.ChildrenRepository;
import com.mfadhili.cheri.data.repository.medical_record.Medical_recordRepository;
import com.mfadhili.cheri.data.repository.medical_record.subRecords.Occup_therapyRepository;
import com.mfadhili.cheri.service.medical_record.sub_records.interfaces.Occup_therapyRecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Occup_therapyRecServiceImpl implements Occup_therapyRecService {
    @Autowired
    private Medical_recordRepository medical_recordRepository;
    @Autowired
    private ChildrenRepository childrenRepository;
    @Autowired
    private Occup_therapyRepository occup_therapyRepository;

    @Override
    public Occup_therapy addMedicalRecOccup_therapy(Long ChildId, Occup_therapy occup_therapy_record) {
        Occup_therapy newOccupTherapyRec = new Occup_therapy();

        /** Check child exists and find their record*/
        Optional<Children> contextChild = childrenRepository.findById(ChildId);

        List<Medical_record> foundRecord;
        if (contextChild.isEmpty()) {
            throw new IllegalStateException("Child of Id " + ChildId + " Does not exist");
        } else {
            Children child = childrenRepository.findChildId(ChildId);
            foundRecord = medical_recordRepository.findByChildren_id(child);

            /** Adding the record from the activity payload*/
            newOccupTherapyRec.setMedical_record(foundRecord.get(0));
            newOccupTherapyRec.setNeed_for_therapy(occup_therapy_record.getNeed_for_therapy());
            newOccupTherapyRec.setExtensive_support(occup_therapy_record.getExtensive_support());
            newOccupTherapyRec.setReferral_followup(occup_therapy_record.getReferral_followup());
            newOccupTherapyRec.setWellness_support(occup_therapy_record.getWellness_support());

            return occup_therapyRepository.save(newOccupTherapyRec);
        }
    }

    @Override
    public Optional<Occup_therapy> getMedicalRecOccup_therapy(Long ChildId) {
        /** Check if child exists and find their record*/
        Optional<Children> contextChild = childrenRepository.findById(ChildId);

        List<Medical_record> foundMedicalRec;
        Occup_therapy foundOccup_therapy;
        if (contextChild.isEmpty()) {
            throw new IllegalStateException("Child of Id " + ChildId + " Does not exist");
        }
        else{
            Children child = childrenRepository.findChildId(ChildId);
            foundMedicalRec = medical_recordRepository.findByChildren_id(child);
            foundOccup_therapy = occup_therapyRepository.findByMedical_record(foundMedicalRec.get(0));

            return Optional.ofNullable(foundOccup_therapy);
        }
    }

    @Override
    public Occup_therapy updateMedicalRecOccup_therapy(Long ChildId, Occup_therapy occup_therapy_record) {

        /** Check child exists and find their record*/
        Optional<Children> contextChild = childrenRepository.findById(ChildId);

        List<Medical_record> foundRecord;
        Occup_therapy foundOccup_therapy;
        if (contextChild.isEmpty()) {
            throw new IllegalStateException("Child of Id " + ChildId + " Does not exist");
        } else {
            Children child = childrenRepository.findChildId(ChildId);
            foundRecord = medical_recordRepository.findByChildren_id(child);
            foundOccup_therapy = occup_therapyRepository.findByMedical_record(foundRecord.get(0));

            /** Adding the record from the activity payload*/
            foundOccup_therapy.setMedical_record(foundRecord.get(0));
            foundOccup_therapy.setNeed_for_therapy(occup_therapy_record.getNeed_for_therapy());
            foundOccup_therapy.setExtensive_support(occup_therapy_record.getExtensive_support());
            foundOccup_therapy.setReferral_followup(occup_therapy_record.getReferral_followup());
            foundOccup_therapy.setWellness_support(occup_therapy_record.getWellness_support());

            return occup_therapyRepository.save(foundOccup_therapy);
        }

    }

    @Override
    public String deleteMedicalRecOccup_therapy(Long ChildId) {
        /** Check if child exists and find their record*/
        Optional<Children> contextChild = childrenRepository.findById(ChildId);

        List<Medical_record> foundMedicalRec;
        Occup_therapy foundOccup_therapy;
        if (contextChild.isEmpty()) {
            throw new IllegalStateException("Child of Id " + ChildId + " Does not exist");
        }
        else{
            Children child = childrenRepository.findChildId(ChildId);
            foundMedicalRec = medical_recordRepository.findByChildren_id(child);
            foundOccup_therapy = occup_therapyRepository.findByMedical_record(foundMedicalRec.get(0));

            occup_therapyRepository.deleteById(foundOccup_therapy.getId());
        }
        return "Delete successful!";
    }
}
