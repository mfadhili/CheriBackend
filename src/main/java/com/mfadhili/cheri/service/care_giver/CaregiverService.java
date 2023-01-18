package com.mfadhili.cheri.service.care_giver;

import com.mfadhili.cheri.data.domain.Admin_Home.caregiver.Caregiver;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface CaregiverService {
    Caregiver addCaregiver(Caregiver caregiver);

    Optional<Caregiver> getCaregiverById(Long Id);

    List<Caregiver> getAllCaregivers();

    String deleteCaregiver(Long Id);

    Optional<Caregiver> updateCaregiver(Long caregiverId ,Caregiver caregiverReq);
}
