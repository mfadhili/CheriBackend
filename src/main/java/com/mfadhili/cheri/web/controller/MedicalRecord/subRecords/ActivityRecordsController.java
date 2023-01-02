package com.mfadhili.cheri.web.controller.MedicalRecord.subRecords;

import com.mfadhili.cheri.data.domain.child_caregiver.medical_record.subrecords.Activity;
import com.mfadhili.cheri.service.medical_record.sub_records.ActivityRecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/medical_rec/{childId}/activityRec")
public class ActivityRecordsController {

    @Autowired
    ActivityRecService activityRecService;

    /** Adding the Activity record*/
    @PutMapping("/add")
    public ResponseEntity<Activity> addActivityRec(@PathVariable Long childId, @RequestBody Activity activityReq){
        Activity newActivity = activityRecService.addMedicalRecActivity(childId,activityReq);

        return new ResponseEntity<>(newActivity, HttpStatus.OK);
    }

    /** Update Activity record*/

    /** Get activity sub_record by child Id*/
    @GetMapping("/get")
    public ResponseEntity<Optional<Activity>>getActivityRec(@PathVariable Long childId){
        Optional<Activity> foundActivityRec = activityRecService.getMedicalRecActivity(childId);
        return new ResponseEntity<>(foundActivityRec, HttpStatus.OK);
    }

    /** Delete Activity record */
}
