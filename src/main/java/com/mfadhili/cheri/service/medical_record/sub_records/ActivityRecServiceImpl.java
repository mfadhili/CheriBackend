package com.mfadhili.cheri.service.medical_record.sub_records;

import com.mfadhili.cheri.data.domain.child_caregiver.child.Children;
import com.mfadhili.cheri.data.domain.child_caregiver.medical_record.Medical_record;
import com.mfadhili.cheri.data.domain.child_caregiver.medical_record.subrecords.Activity;
import com.mfadhili.cheri.data.repository.ChildrenRepository;
import com.mfadhili.cheri.data.repository.medical_record.Medical_recordRepository;
import com.mfadhili.cheri.data.repository.medical_record.subRecords.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityRecServiceImpl implements ActivityRecService {

    @Autowired
    private Medical_recordRepository medical_recordRepository;
    @Autowired
    private ChildrenRepository childrenRepository;
    @Autowired
    private ActivityRepository activityRepository;

    @Override
    /** Update activity form in medical record by child Id*/
    public Activity addMedicalRecActivity(Long ChildId, Activity activity_req) {
        Activity newActivity = new Activity();

        /** Check child exists and find their record*/
        Optional<Children> contextChild = childrenRepository.findById(ChildId);

        List<Medical_record> foundRecord;
        if (contextChild.isEmpty()) {
            throw new IllegalStateException("Child of Id " + ChildId + " Does not exist");
        } else {
            Children child = childrenRepository.findChildId(ChildId);
            foundRecord = medical_recordRepository.findByChildren_id(child);

            /** Adding the record from the activity payload*/
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
    public Optional<Activity> getMedicalRecActivity(Long ChildId) {

        /** Check if child exists and find their record*/
        Optional<Children> contextChild = childrenRepository.findById(ChildId);

        List<Medical_record> foundMedicalRec;
        Activity foundActivityRec;
        if (contextChild.isEmpty()) {
            throw new IllegalStateException("Child of Id " + ChildId + " Does not exist");
        }
        else{
            Children child = childrenRepository.findChildId(ChildId);
            foundMedicalRec = medical_recordRepository.findByChildren_id(child);
            foundActivityRec = activityRepository.findByMedical_record(foundMedicalRec.get(0));

            return Optional.ofNullable(foundActivityRec);
        }
    }

    @Override
    public Activity updateMedicalRecActivity(Long ChildId, Activity activity_record) {
        
        /** Check if child exists and find their record*/
        Optional<Children> contextChild = childrenRepository.findById(ChildId);

        List<Medical_record> foundMedicalRec;
        Activity foundActivityRec;
        if (contextChild.isEmpty()) {
            throw new IllegalStateException("Child of Id " + ChildId + " Does not exist");
        }
        else{
            Children child = childrenRepository.findChildId(ChildId);
            foundMedicalRec = medical_recordRepository.findByChildren_id(child);
            foundActivityRec = activityRepository.findByMedical_record(foundMedicalRec.get(0));

            /** Adding the updates from the payload*/
            foundActivityRec.setCommunication_skills(activity_record.getCommunication_skills());
            foundActivityRec.setDomestic_skills(activity_record.getDomestic_skills());
            foundActivityRec.setDressing_skills(activity_record.getDressing_skills());
            foundActivityRec.setFeeding_eating(activity_record.getFeeding_eating());
            foundActivityRec.setHygiene_skills(activity_record.getHygiene_skills());
            
            return activityRepository.save(foundActivityRec);
        }
        
    }

    @Override
    public String deleteMedicalRecActivity(Long ChildId) {
        boolean exist;

        /** Check if child exists and find their record*/
        Optional<Children> contextChild = childrenRepository.findById(ChildId);

        List<Medical_record> foundMedicalRec;
        Activity foundActivityRec;
        if (contextChild.isEmpty()) {
            throw new IllegalStateException("Child of Id " + ChildId + " Does not exist");
        }
        else{
            Children child = childrenRepository.findChildId(ChildId);
            foundMedicalRec = medical_recordRepository.findByChildren_id(child);
            foundActivityRec = activityRepository.findByMedical_record(foundMedicalRec.get(0));

            activityRepository.deleteById(foundActivityRec.getId());
        }
        return "Delete successful!";
    }
}
