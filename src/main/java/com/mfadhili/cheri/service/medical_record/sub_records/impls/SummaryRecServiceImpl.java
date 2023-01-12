package com.mfadhili.cheri.service.medical_record.sub_records.impls;

import com.mfadhili.cheri.data.domain.child_caregiver.child.Children;
import com.mfadhili.cheri.data.domain.child_caregiver.medical_record.Medical_record;
import com.mfadhili.cheri.data.domain.child_caregiver.medical_record.subrecords.Summary;
import com.mfadhili.cheri.data.repository.ChildrenRepository;
import com.mfadhili.cheri.data.repository.medical_record.Medical_recordRepository;
import com.mfadhili.cheri.data.repository.medical_record.subRecords.SummaryRepository;
import com.mfadhili.cheri.service.medical_record.sub_records.interfaces.SummaryRecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SummaryRecServiceImpl implements SummaryRecService {
    @Autowired
    private Medical_recordRepository medical_recordRepository;
    @Autowired
    private ChildrenRepository childrenRepository;
    @Autowired
    private SummaryRepository summaryRepository;

    @Override
    public Summary addMedicalRecSummary(Long ChildId, Summary summary_record) {
        Summary newSummary = new Summary();

        /** Check child exists and find their record*/
        Optional<Children> contextChild = childrenRepository.findById(ChildId);

        List<Medical_record> foundRecord;
        if (contextChild.isEmpty()) {
            throw new IllegalStateException("Child of Id " + ChildId + " Does not exist");
        } else {
            Children child = childrenRepository.findChildId(ChildId);
            foundRecord = medical_recordRepository.findByChildren_id(child);

            /** Adding the record from the activity payload*/
            newSummary.setMedical_record(foundRecord.get(0));
            newSummary.setAllergies(summary_record.getAllergies());
            newSummary.setSpeaking_condition(summary_record.getSpeaking_condition());
            newSummary.setSkin_condition(summary_record.getSkin_condition());
            newSummary.setPsychological_condition(summary_record.getPsychological_condition());
            newSummary.setPhysical_condition(summary_record.getPhysical_condition());
            newSummary.setHearing_condition(summary_record.getHearing_condition());
            newSummary.setOthers(summary_record.getOthers());

            return summaryRepository.save(newSummary);
        }
    }

    @Override
    public List<Summary> getMedicalRecSummary(Long ChildId) {
        /** Check if child exists and find their record*/
        Optional<Children> contextChild = childrenRepository.findById(ChildId);

        List<Medical_record> foundMedicalRec;
        Optional<List<Summary>> foundSummary;
        if (contextChild.isEmpty()) {
            throw new IllegalStateException("Child of Id " + ChildId + " Does not exist");
        }
        else{
            Children child = childrenRepository.findChildId(ChildId);
            foundMedicalRec = medical_recordRepository.findByChildren_id(child);
            foundSummary = summaryRepository.findByMedical_record(foundMedicalRec.get(0));
            List<Summary> foundSummary2 = foundSummary.get();
            return foundSummary2;
        }
    }

    @Override
    public Summary updateMedicalRecSummary(Long ChildId, Summary summary_record) {

        /** Check child exists and find their record*/
        Optional<Children> contextChild = childrenRepository.findById(ChildId);

        List<Medical_record> foundRecord;
        List<Summary> foundSummary;
        if (contextChild.isEmpty()) {
            throw new IllegalStateException("Child of Id " + ChildId + " Does not exist");
        } else {
            Children child = childrenRepository.findChildId(ChildId);
            foundRecord = medical_recordRepository.findByChildren_id(child);
            foundSummary = summaryRepository.findByMedical_record2(foundRecord.get(0));
            Summary foundSummary2 = foundSummary.get(0);

            /** Adding the record from the activity payload*/
            foundSummary2.setMedical_record(foundRecord.get(0));
            foundSummary2.setAllergies(summary_record.getAllergies());
            foundSummary2.setSpeaking_condition(summary_record.getSpeaking_condition());
            foundSummary2.setSkin_condition(summary_record.getSkin_condition());
            foundSummary2.setPsychological_condition(summary_record.getPsychological_condition());
            foundSummary2.setPhysical_condition(summary_record.getPhysical_condition());
            foundSummary2.setHearing_condition(summary_record.getHearing_condition());
            foundSummary2.setOthers(summary_record.getOthers());

            return summaryRepository.save(foundSummary2);
        }
    }

    @Override
    public String deleteMedicalRecSummary(Long ChildId) {
        /** Check if child exists and find their record*/
        Optional<Children> contextChild = childrenRepository.findById(ChildId);

        List<Medical_record> foundMedicalRec;
        List<Summary> foundSummary;
        if (contextChild.isEmpty()) {
            throw new IllegalStateException("Child of Id " + ChildId + " Does not exist");
        }
        else{
            Children child = childrenRepository.findChildId(ChildId);
            foundMedicalRec = medical_recordRepository.findByChildren_id(child);
            foundSummary = summaryRepository.findByMedical_record2(foundMedicalRec.get(0));
            Summary foundSummary2 = foundSummary.get(0);

            summaryRepository.deleteById(foundSummary2.getId());
        }
        return "Delete successful!";
    }
}
