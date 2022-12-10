package com.mfadhili.cheri.web.controller.Caregiver;

import com.mfadhili.cheri.data.domain.child_caregiver.caregiver.Caregiver;
import com.mfadhili.cheri.service.care_giver.CaregiverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/caregiver")
public class CaregiverController {
    @Autowired
    CaregiverService caregiverService;

    @GetMapping("/{caregiverId}")
    public ResponseEntity<Caregiver> getCaregiverById(@PathVariable("caregiverId") Long careGiverId){
        Optional<Caregiver> foundCaregiver = caregiverService.getCaregiverById(careGiverId);
        return new ResponseEntity<>(foundCaregiver.get(), HttpStatus.FOUND);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Caregiver>> getAllCaregivers(){
        List<Caregiver> caregivers = caregiverService.getAllCaregivers();
        return new ResponseEntity<>(caregivers, HttpStatus.FOUND);
    }

    @PostMapping("/add")
    public ResponseEntity<Caregiver> createCaregiver(@RequestBody Caregiver caregiverReq){
        Caregiver  newCaregiver = caregiverService.addCaregiver(caregiverReq);
        return new ResponseEntity<>(newCaregiver,HttpStatus.CREATED);
    }

    @PutMapping("/update/{caregiverId}")
    public ResponseEntity<Caregiver> updateCaregiver(@PathVariable("caregiverId") Long caregiverId, @RequestBody Caregiver caregiverReq){
        Optional<Caregiver> caregiverUpdate = caregiverService.updateCaregiver(caregiverId, caregiverReq);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{caregiverId}")
    public ResponseEntity<?> deleteCaregiver(@PathVariable("caregiverId") Long caregiverId){
        caregiverService.deleteCaregiver(caregiverId);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
