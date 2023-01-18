package com.mfadhili.cheri.service.medical_record.sub_records.impls;

import com.mfadhili.cheri.data.domain.child_guardian.child.Children;
import com.mfadhili.cheri.data.domain.medical_record.Medical_record;
import com.mfadhili.cheri.data.domain.medical_record.subrecords.Summary;
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

            /** Check if the record exist. Solution to prevent multiple records*/
            Optional<Summary> foundSummary = Optional.ofNullable(summaryRepository.findByMedical_record2(foundRecord.get(0)));
            if (foundSummary.isPresent()) {
                throw new IllegalStateException("Summary record of Child " + ChildId + " exists, please update or delete");
            }
            else {
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
    }

    @Override
    public Optional<Summary> getMedicalRecSummary(Long ChildId) {
        /** Check if child exists and find their record*/
        Optional<Children> contextChild = childrenRepository.findById(ChildId);

        List<Medical_record> foundMedicalRec;
        Summary foundSummary;
        if (contextChild.isEmpty()) {
            throw new IllegalStateException("Child of Id " + ChildId + " Does not exist");
        }
        else{
            Children child = childrenRepository.findChildId(ChildId);
            foundMedicalRec = medical_recordRepository.findByChildren_id(child);
            foundSummary = summaryRepository.findByMedical_record2(foundMedicalRec.get(0));
            return Optional.ofNullable(foundSummary);
        }
    }

    @Override
    public Summary updateMedicalRecSummary(Long ChildId, Summary summary_record) {

        /** Check child exists and find their record*/
        Optional<Children> contextChild = childrenRepository.findById(ChildId);

        List<Medical_record> foundRecord;
        Summary foundSummary;
        if (contextChild.isEmpty()) {
            throw new IllegalStateException("Child of Id " + ChildId + " Does not exist");
        } else {
            Children child = childrenRepository.findChildId(ChildId);
            foundRecord = medical_recordRepository.findByChildren_id(child);
            foundSummary = summaryRepository.findByMedical_record2(foundRecord.get(0));

            /** If record does not exist an new is created*/
            boolean exist = summaryRepository.existsById(foundSummary.getId());
            if (!exist) {
                foundSummary = new Summary();
            }

            /** Adding the record from the activity payload*/
            foundSummary.setMedical_record(foundRecord.get(0));
            foundSummary.setAllergies(summary_record.getAllergies());
            foundSummary.setSpeaking_condition(summary_record.getSpeaking_condition());
            foundSummary.setSkin_condition(summary_record.getSkin_condition());
            foundSummary.setPsychological_condition(summary_record.getPsychological_condition());
            foundSummary.setPhysical_condition(summary_record.getPhysical_condition());
            foundSummary.setHearing_condition(summary_record.getHearing_condition());
            foundSummary.setOthers(summary_record.getOthers());

            return summaryRepository.save(foundSummary);
        }
    }

    @Override
    public String deleteMedicalRecSummary(Long ChildId) {
        /** Check if child exists and find their record*/
        Optional<Children> contextChild = childrenRepository.findById(ChildId);

        List<Medical_record> foundMedicalRec;
        Summary foundSummary;
        if (contextChild.isEmpty()) {
            throw new IllegalStateException("Child of Id " + ChildId + " Does not exist");
        }
        else{
            Children child = childrenRepository.findChildId(ChildId);
            foundMedicalRec = medical_recordRepository.findByChildren_id(child);
            foundSummary = summaryRepository.findByMedical_record2(foundMedicalRec.get(0));

            summaryRepository.deleteById(foundSummary.getId());
        }
        return "Delete successful!";
    }
}
