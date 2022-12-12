package com.mfadhili.cheri.service.parent;


import com.mfadhili.cheri.data.domain.child_caregiver.parent.Parents;
import com.mfadhili.cheri.data.repository.ParentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParentServiceImpl implements ParentService{
    @Autowired
    private ParentsRepository parentsRepository;

    @Override
    public Parents addParent(Parents parentReq) {
        Parents newParent = new Parents();

        newParent.setFirst_name(parentReq.getFirst_name());
        newParent.setLast_name(parentReq.getLast_name());
        newParent.setNational_Id(parentReq.getNational_Id());
        newParent.setTelephone(parentReq.getTelephone());

        return parentsRepository.save(newParent);
    }

    @Override
    public Optional<Parents> getParentById(Long parentId) {
        Optional<Parents> parent = parentsRepository.findById(parentId);

        if (parent.isPresent()) {
            return parent;
        }
        else {
            throw new IllegalStateException("Parent of Id "+ parentId + "does not exist");
        }
    }

    @Override
    public List<Parents> getAllParents() {
        return parentsRepository.findAll();
    }

    @Override
    public Optional<Parents> updateParents(Long parentId, Parents parentReq) {
        Optional<Parents> oldParent = parentsRepository.findById(parentId);
        if (oldParent.isEmpty()) {
            throw new IllegalStateException("Parent of Id "+ parentId + "does not exist");
        }
        else {
            oldParent.get().setFirst_name(parentReq.getFirst_name());
            oldParent.get().setLast_name(parentReq.getLast_name());
            oldParent.get().setNational_Id(parentReq.getTelephone());
            oldParent.get().setTelephone(parentReq.getTelephone());

            parentsRepository.save(oldParent.get());
        }
        return oldParent;
    }

    @Override
    public String deleteParent(Long parentId) {
        boolean exist = parentsRepository.existsById(parentId);
        if (!exist) {
            throw new IllegalStateException("Parent of Id "+ parentId + "does not exist");
        }
        else {
            parentsRepository.deleteById(parentId);
        }
        return "Delete successful";
    }
}
