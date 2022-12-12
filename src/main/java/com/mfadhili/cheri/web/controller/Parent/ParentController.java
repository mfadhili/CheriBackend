package com.mfadhili.cheri.web.controller.Parent;

import com.mfadhili.cheri.data.domain.child_caregiver.parent.Parents;
import com.mfadhili.cheri.data.repository.ParentsRepository;
import com.mfadhili.cheri.service.parent.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/parent")
public class ParentController {
    @Autowired
    ParentService parentService;
    @Autowired
    private ParentsRepository parentsRepository;

    @GetMapping("/{parentId}")
    public ResponseEntity<Parents> getParentById(@PathVariable("parentId") Long parentId){
        Optional<Parents> foundParent = parentService.getParentById(parentId);
        return new ResponseEntity<>(foundParent.get(), HttpStatus.FOUND);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Parents>> getAllParents(){
        List<Parents> parents = parentService.getAllParents();
        return new ResponseEntity<>(parents, HttpStatus.FOUND);
    }

    @PostMapping("/add")
    public ResponseEntity<Parents> createParent(@RequestBody Parents parentReq){
        Parents newParent = parentService.addParent(parentReq);
        return new ResponseEntity<>(newParent, HttpStatus.CREATED);
    }

    @PutMapping("/update/{parentId}")
    public ResponseEntity<Parents> updateParent(@PathVariable("parentId") Long parentId, @RequestBody Parents parentReq){
        Optional<Parents> parentUpdate = parentService.updateParents(parentId, parentReq);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{parentId}")
    public ResponseEntity<?> deleteParent(@PathVariable("parentId") Long parentId){
        parentService.deleteParent(parentId);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

}
