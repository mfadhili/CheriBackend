package com.mfadhili.cheri.web.controller.Parent;

import com.mfadhili.cheri.data.domain.child_guardian.guardian.Guardian;
import com.mfadhili.cheri.data.repository.GuardiansRepository;
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
    private GuardiansRepository guardiansRepository;

    @GetMapping("/{parentId}")
    public ResponseEntity<Guardian> getParentById(@PathVariable("parentId") Long parentId){
        Optional<Guardian> foundParent = parentService.getParentById(parentId);
        return new ResponseEntity<>(foundParent.get(), HttpStatus.FOUND);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Guardian>> getAllParents(){
        List<Guardian> parents = parentService.getAllParents();
        return new ResponseEntity<>(parents, HttpStatus.FOUND);
    }

    @PostMapping("/add")
    public ResponseEntity<Guardian> createParent(@RequestBody Guardian parentReq){
        Guardian newParent = parentService.addParent(parentReq);
        return new ResponseEntity<>(newParent, HttpStatus.CREATED);
    }

    @PutMapping("/update/{parentId}")
    public ResponseEntity<Guardian> updateParent(@PathVariable("parentId") Long parentId, @RequestBody Guardian parentReq){
        Optional<Guardian> parentUpdate = parentService.updateParents(parentId, parentReq);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{parentId}")
    public ResponseEntity<?> deleteParent(@PathVariable("parentId") Long parentId){
        parentService.deleteParent(parentId);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

}
