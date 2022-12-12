package com.mfadhili.cheri.service.parent;

import com.mfadhili.cheri.data.domain.child_caregiver.parent.Parents;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface ParentService {
    Parents addParent(Parents parentReq);

    Optional<Parents> getParentById(Long parentId);

    List<Parents> getAllParents();

    Optional<Parents> updateParents(Long parentId, Parents parentReq);

    String deleteParent(Long parentId);
}
