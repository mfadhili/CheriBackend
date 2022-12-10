package com.mfadhili.cheri.service.care_giver;

import com.mfadhili.cheri.data.domain.child_caregiver.caregiver.Caregiver;
import com.mfadhili.cheri.data.repository.CaregiverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CaregiverServiceIpml implements CaregiverService{
    @Autowired
    private CaregiverRepository caregiverRepository;

    @Override
    public Caregiver addCaregiver(Caregiver caregiverReq) {
        Caregiver newCaregiver = new Caregiver();

        newCaregiver.setFirst_name(caregiverReq.getFirst_name());
        newCaregiver.setLast_name(caregiverReq.getLast_name());
        newCaregiver.setGender(caregiverReq.getGender());
        newCaregiver.setTelephone(caregiverReq.getTelephone());
        newCaregiver.setNational_id(caregiverReq.getNational_id());

        return caregiverRepository.save(newCaregiver);
    }

    @Override
    public Optional<Caregiver> getCaregiverById(Long Id) {
        Optional<Caregiver> caregiver = caregiverRepository.findById(Id);

        if (caregiver.isPresent()) {
            return caregiver;
        }
        else {
            throw new IllegalStateException("Caregiver of Id "+ Id + "Does not exist");
        }
    }

    @Override
    public List<Caregiver> getAllCaregivers() {
        return caregiverRepository.findAll();
    }

    @Override
    public String deleteCaregiver(Long Id) {
        boolean exist = caregiverRepository.existsById(Id);
        if (!exist) {
            throw new IllegalStateException("Caregiver of Id "+ Id + "Does not exist");
        }
        else
            caregiverRepository.deleteById(Id);

        return "Delete successful";
    }

    @Override
    public Optional<Caregiver> updateCaregiver(Long caregiverId, Caregiver caregiverReq) {
        Optional<Caregiver> oldCaregiver = caregiverRepository.findById(caregiverId);

        if (oldCaregiver.isEmpty()) {
            throw new IllegalStateException("Caregiver of Id "+ caregiverId + "Does not exist");
        }
        else {
            oldCaregiver.get().setFirst_name(caregiverReq.getFirst_name());
            oldCaregiver.get().setLast_name(caregiverReq.getLast_name());
            oldCaregiver.get().setGender(caregiverReq.getGender());
            oldCaregiver.get().setTelephone(caregiverReq.getTelephone());
            oldCaregiver.get().setNational_id(caregiverReq.getNational_id());

            caregiverRepository.save(oldCaregiver.get());
        }
        return oldCaregiver;
    }
}
