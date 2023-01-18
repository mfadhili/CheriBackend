package com.mfadhili.cheri.service.parent;


import com.mfadhili.cheri.data.domain.child_guardian.guardian.Guardian;
import com.mfadhili.cheri.data.repository.GuardiansRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParentServiceImpl implements ParentService{
    @Autowired
    private GuardiansRepository guardiansRepository;

    @Override
    public Guardian addParent(Guardian parentReq) {
        Guardian newParent = new Guardian();

        newParent.setFirst_name(parentReq.getFirst_name());
        newParent.setLast_name(parentReq.getLast_name());
        newParent.setNational_Id(parentReq.getNational_Id());
        newParent.setTelephone(parentReq.getTelephone());

        return guardiansRepository.save(newParent);
    }

    @Override
    public Optional<Guardian> getParentById(Long parentId) {
        Optional<Guardian> parent = guardiansRepository.findById(parentId);

        if (parent.isPresent()) {
            return parent;
        }
        else {
            throw new IllegalStateException("Parent of Id "+ parentId + "does not exist");
        }
    }

    @Override
    public List<Guardian> getAllParents() {
        return guardiansRepository.findAll();
    }

    @Override
    public Optional<Guardian> updateParents(Long parentId, Guardian parentReq) {
        Optional<Guardian> oldParent = guardiansRepository.findById(parentId);
        if (oldParent.isEmpty()) {
            throw new IllegalStateException("Parent of Id "+ parentId + "does not exist");
        }
        else {
            oldParent.get().setFirst_name(parentReq.getFirst_name());
            oldParent.get().setLast_name(parentReq.getLast_name());
            oldParent.get().setNational_Id(parentReq.getTelephone());
            oldParent.get().setTelephone(parentReq.getTelephone());

            guardiansRepository.save(oldParent.get());
        }
        return oldParent;
    }

    @Override
    public String deleteParent(Long parentId) {
        boolean exist = guardiansRepository.existsById(parentId);
        if (!exist) {
            throw new IllegalStateException("Parent of Id "+ parentId + "does not exist");
        }
        else {
            guardiansRepository.deleteById(parentId);
        }
        return "Delete successful";
    }
}
