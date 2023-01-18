package com.mfadhili.cheri.web.controller.MedicalRecord;

import com.mfadhili.cheri.data.domain.medical_record.Medical_record;
import com.mfadhili.cheri.data.requestBodies.MedicalRequest;
import com.mfadhili.cheri.service.medical_record.MedicalRecService;
import com.mfadhili.cheri.service.medical_record.sub_records.interfaces.ActivityRecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medical_rec")
public class MedicalRecordController {

    @Autowired
    MedicalRecService medicalRecService;

    /** Method for creating a child (referenced by the Child Id).*/
    /** TODO: Include caregiver details via authentication */
    @PostMapping("/{childId}/add")
    public ResponseEntity<Medical_record> createMedRec(@PathVariable Long childId, @RequestBody Medical_record medical_record){
        Medical_record newMedicalRec = medicalRecService.addMedicalRecord(childId, medical_record);
        return new ResponseEntity<>(newMedicalRec, HttpStatus.CREATED);
    }

    /** An extension of the add with all details*/
    @PostMapping("/{childId}/add/all")
    public ResponseEntity<Medical_record> createMedRecAll(@PathVariable Long childId, @RequestBody MedicalRequest medicalRequest){
        Medical_record newMedicalRec = medicalRecService.addMedicalRecordAll(childId, medicalRequest);

        return new ResponseEntity<>(newMedicalRec, HttpStatus.CREATED);
    }


    /** General method to get all medical records in the system*/
    @GetMapping("/all")
    public ResponseEntity<List<Medical_record>>getAllMedRecs(){
        List<Medical_record> MedicalRecs = medicalRecService.getAllMed_Rec();
        return new ResponseEntity<>(MedicalRecs, HttpStatus.OK);
    }

    /** Medical record find but with child id since Medical record id may be  unknown to user*/
    @GetMapping("/{childId}/all")
    public ResponseEntity<List<Medical_record>> getMedRecByChild(@PathVariable Long childId){
        List<Medical_record> MedRecs = medicalRecService.getMed_Rec_By_ChildId(childId);
        return new ResponseEntity<>(MedRecs, HttpStatus.OK);
    }

    /** In case the user amazingly knows the medical record id*/
    @GetMapping("/{medRecId}")
    public ResponseEntity<Medical_record> getMedRecById(@PathVariable Long medRecId){
        Optional<Medical_record> foundMedRec = medicalRecService.getMed_Rec_By_Id(medRecId);
        return new ResponseEntity<>(foundMedRec.get(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{childId}")
    public ResponseEntity<?> deleteMedRec(@PathVariable Long childId){
        medicalRecService.deleteMed_Rec(childId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
