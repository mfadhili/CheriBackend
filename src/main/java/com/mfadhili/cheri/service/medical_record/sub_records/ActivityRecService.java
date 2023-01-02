package com.mfadhili.cheri.service.medical_record.sub_records;

import com.mfadhili.cheri.data.domain.child_caregiver.medical_record.subrecords.Activity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface ActivityRecService {

    Activity addMedicalRecActivity(Long ChildId, Activity activity_record);

    Optional<Activity> getMedicalRecActivity(Long ChildId);

    Activity updateMedicalRecActivity(Long ChildId, Activity activity_record);

    String deleteMedicalRecActivity(Long ChildId);

}
