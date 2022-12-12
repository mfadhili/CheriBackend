package com.mfadhili.cheri.service.children;

import com.mfadhili.cheri.data.domain.child_caregiver.child.Children;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface ChildrenService {

    Children addChild(Children childReq);

    Optional<Children> updateChild(Long childId, Children childReq);

    Optional<Children> getChildById(Long childId);

    List<Children> getAllChildren();

    String deleteChild(Long childId);

}
