package com.mfadhili.cheri.service.medical_record;

import com.mfadhili.cheri.data.domain.medical_record.Medical_record;
import com.mfadhili.cheri.data.requestBodies.MedicalRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface MedicalRecService  {
    Medical_record addMedicalRecord(Long childId, Medical_record medical_record);

    Medical_record addMedicalRecordAll(Long childId, MedicalRequest medicalRequest);


    Optional<Medical_record> updateMedicalRecAll(Long childId, MedicalRequest medicalRequest);

    Optional<Medical_record> getMed_Rec_By_Id(Long medRec_Id);

    List<Medical_record> getAllMed_Rec();

    List<Medical_record> getMed_Rec_By_ChildId(Long ChildId);

    String deleteMed_Rec(Long childId);
}
