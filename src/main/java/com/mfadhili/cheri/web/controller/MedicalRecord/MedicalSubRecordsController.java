package com.mfadhili.cheri.web.controller.MedicalRecord;

import com.mfadhili.cheri.data.domain.child_caregiver.medical_record.subrecords.Activity;
import com.mfadhili.cheri.service.medical_record.MedicalRecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medical_rec")
public class MedicalSubRecordsController {

    @Autowired
    MedicalRecService medicalRecService;

    /** Adding the Activity record*/
    @PutMapping("/{childId}/activityRec")
    public ResponseEntity<Activity> addActivityRec(@PathVariable Long childId, @RequestBody Activity activityReq){
        Activity newActivity = medicalRecService.updateMedicalRecActivity(childId,activityReq);

        return new ResponseEntity<>(newActivity, HttpStatus.OK);
    }
}
