package com.mfadhili.cheri.web.controller.children;

import com.mfadhili.cheri.data.domain.child_caregiver.child.Children;
import com.mfadhili.cheri.data.repository.ChildrenRepository;
import com.mfadhili.cheri.service.children.ChildrenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/children")
public class ChildrenController {
    @Autowired
    ChildrenService childrenService;
    @Autowired
    private ChildrenRepository childrenRepository;

    @GetMapping("/{childId}")
    public ResponseEntity<Children> getChildById(@PathVariable Long childId){
        Optional<Children> foundChild = childrenService.getChildById(childId);
        return new ResponseEntity<>(foundChild.get(), HttpStatus.FOUND);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Children>> getAllChildren(){
        List<Children> children = childrenService.getAllChildren();
        return new ResponseEntity<>(children, HttpStatus.FOUND);
    }

    @PostMapping("/add")
    public ResponseEntity<Children> createChild(@RequestBody Children childReq){
        Children newChild = childrenService.addChild(childReq);
        return new ResponseEntity<>(newChild, HttpStatus.CREATED);
    }

    @PutMapping("/update/{childId}")
    public ResponseEntity<Children> updateChild(@PathVariable Long childId, @RequestBody Children childReq){
        Optional<Children> childUpdate = childrenService.updateChild(childId,childReq);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{childId}")
    public ResponseEntity<?> deleteChild(@PathVariable Long childId){
        childrenService.deleteChild(childId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
