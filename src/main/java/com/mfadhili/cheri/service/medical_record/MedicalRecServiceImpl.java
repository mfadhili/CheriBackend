package com.mfadhili.cheri.service.medical_record;

import com.mfadhili.cheri.data.domain.child_caregiver.caregiver.Caregiver;
import com.mfadhili.cheri.data.domain.child_caregiver.child.Children;
import com.mfadhili.cheri.data.domain.child_caregiver.medical_record.Medical_record;
import com.mfadhili.cheri.data.domain.child_caregiver.medical_record.subrecords.Activity;
import com.mfadhili.cheri.data.repository.CaregiverRepository;
import com.mfadhili.cheri.data.repository.ChildrenRepository;
import com.mfadhili.cheri.data.repository.medical_record.Medical_recordRepository;
import com.mfadhili.cheri.data.repository.medical_record.subRecords.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicalRecServiceImpl implements MedicalRecService {
    @Autowired
    private Medical_recordRepository medical_recordRepository;
    @Autowired
    private ChildrenRepository childrenRepository;
    @Autowired
    private CaregiverRepository caregiverRepository;

    @Autowired
    private ActivityRepository activityRepository;

    @Override
    /** Instantiate a medical record*/
    public Medical_record addMedicalRecord(Long childId, Medical_record medical_record) {
        Medical_record newMedical_record = new Medical_record();

        /**TODO: Replace Mock Caregiver with source from authentication principle */
        Caregiver caregiver = caregiverRepository.findCaregiverId(Long.valueOf("1"));

        /** Check child exists*/
        Optional<Children> oldChild = childrenRepository.findById(childId);
        
        if (oldChild.isEmpty()) {
            throw new IllegalStateException("Child of Id "+ childId + " Does not exist");
        }
        else {
            Children child = childrenRepository.findChildId(childId);
            newMedical_record.setChildren_id(child);
            newMedical_record.setCaregiver(caregiver);

            medical_recordRepository.save(newMedical_record);
            return newMedical_record;
        }
    }

    @Override
    public Optional<Medical_record> updateMedicalRec(Long medRec_Id, Medical_record medical_record) {
        return Optional.empty();
    }

    @Override
    /** Update activity form in medical record by child Id*/
    public Activity updateMedicalRecActivity(Long ChildId, Activity activity_req) {
        Activity newActivity = new Activity();

        /** Check child exists and find their record*/
        Optional<Children> contextChild = childrenRepository.findById(ChildId);

        List<Medical_record> foundRecord;
        if (contextChild.isEmpty()) {
            throw new IllegalStateException("Child of Id " + ChildId + " Does not exist");
        } else {
            Children child = childrenRepository.findChildId(ChildId);
            foundRecord = medical_recordRepository.findByChildren_id(child);

            /** Adding the record to the activity payload*/
            newActivity.setMedical_record(foundRecord.get(0));
            newActivity.setCommunication_skills(activity_req.getCommunication_skills());
            newActivity.setDomestic_skills(activity_req.getDomestic_skills());
            newActivity.setDressing_skills(activity_req.getDressing_skills());
            newActivity.setFeeding_eating(activity_req.getFeeding_eating());
            newActivity.setHygiene_skills(activity_req.getHygiene_skills());

            return activityRepository.save(newActivity);
        }
    }


    @Override
    /** Method finds Medical record by its Id*/
    public Optional<Medical_record> getMed_Rec_By_Id(Long medRec_Id) {
        Optional<Medical_record> medical_record = medical_recordRepository.findById(medRec_Id);

        if (medical_record.isPresent()) {
            return medical_record;
        }
        else {
            throw new IllegalStateException("Medical record of Id "+ medRec_Id + " Does not exist");
        }

    }

    @Override
    public List<Medical_record> getAllMed_Rec() {
        return medical_recordRepository.findAll();
    }


    @Override
    /** finds medical record by childId */
    public List<Medical_record> getMed_Rec_By_ChildId(Long ChildId) {
        /** Check child exists*/
        Optional<Children> contextChild = childrenRepository.findById(ChildId);

        if (contextChild.isEmpty()) {
            throw new IllegalStateException("Child of Id "+ ChildId + " Does not exist");
        }
        else {
            Children child = childrenRepository.findChildId(ChildId);
            return  medical_recordRepository.findByChildren_id(child);
        }

    }

    @Override
    public String deleteMed_Rec(Long medRec_Id) {
        boolean exist = medical_recordRepository.existsById(medRec_Id);

        if (!exist) {
            throw new IllegalStateException("Medical record of Id "+ medRec_Id + " Does not exist");
        }
        else {
            medical_recordRepository.deleteById(medRec_Id);
        }
        return "Delete Successful!";
    }
}
