package com.mfadhili.cheri.service.children;

import com.mfadhili.cheri.data.domain.child_guardian.child.Children;
import com.mfadhili.cheri.data.repository.ChildrenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ChildrenServiceImpl implements ChildrenService{
    @Autowired
    private ChildrenRepository childrenRepository;

    @Override
    public Children addChild(Children childReq) {
        Children newChild = new Children();

        newChild.setFirst_name(childReq.getFirst_name());
        newChild.setLast_name(childReq.getLast_name());
        newChild.setGender(childReq.getGender());
        newChild.setCreatedAt(LocalDate.now());
        newChild.setConsent_form(childReq.getConsent_form());

        return childrenRepository.save(newChild);
    }

    @Override
    public Optional<Children> updateChild(Long childId, Children childReq) {
        Optional<Children> oldChild = childrenRepository.findById(childId);

        if(oldChild.isEmpty()){
            throw new IllegalStateException("Child of Id "+ childId + "Does not exist");
        }
        else {
            oldChild.get().setFirst_name(childReq.getFirst_name());
            oldChild.get().setLast_name(childReq.getLast_name());
            oldChild.get().setGender(childReq.getGender());
            oldChild.get().setConsent_form(childReq.getConsent_form());
            oldChild.get().setUpdateAt(LocalDate.now());

            childrenRepository.save(oldChild.get());
        }

        return oldChild;
    }

    @Override
    public Optional<Children> getChildById(Long childId) {
        Optional<Children> child = childrenRepository.findById(childId);

        if(child.isPresent()){
            return child;
        }
        else {
            throw new IllegalStateException("Child of Id "+ childId + "Does not exist");
        }
    }

    @Override
    public List<Children> getAllChildren() {
        return childrenRepository.findAll();
    }

    @Override
    public String deleteChild(Long childId) {
        boolean exist = childrenRepository.existsById(childId);

        if (!exist) {
            throw new IllegalStateException("Child of Id "+ childId + "Does not exist");
        }
        else {
            childrenRepository.deleteById(childId);
        }
        return "Delete successful";
    }
}
