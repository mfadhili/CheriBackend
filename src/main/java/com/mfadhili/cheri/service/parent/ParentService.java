package com.mfadhili.cheri.service.parent;

import com.mfadhili.cheri.data.domain.child_guardian.guardian.Guardian;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface ParentService {
    Guardian addParent(Guardian parentReq);

    Optional<Guardian> getParentById(Long parentId);

    List<Guardian> getAllParents();

    Optional<Guardian> updateParents(Long parentId, Guardian parentReq);

    String deleteParent(Long parentId);
}
