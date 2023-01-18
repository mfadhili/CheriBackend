package com.mfadhili.cheri.web.controller.Autism_record;

import com.mfadhili.cheri.data.domain.autism_record.Autism_record;
import com.mfadhili.cheri.data.requestBodies.AutismRecRequest;
import com.mfadhili.cheri.service.autism_record.AutismRecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/autism_rec")
public class AutismRecordController {
    @Autowired
    AutismRecService autismRecService;

    /** Adding the Autism record base test*/
    @PostMapping("/{childId}/add")
    public ResponseEntity<Autism_record> createAutismRec(@PathVariable Long childId, @RequestBody AutismRecRequest autismRecRequest){
        Autism_record newAutism_record = autismRecService.addAutismRecord(childId, autismRecRequest);
        return new ResponseEntity<>(newAutism_record, HttpStatus.CREATED);
    }
}
