package com.mfadhili.cheri.service.autism_record;

import com.mfadhili.cheri.data.domain.autism_record.Autism_record;
import com.mfadhili.cheri.data.requestBodies.AutismRecRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface AutismRecService {
    Autism_record addAutismRecord(Long childId, AutismRecRequest autismRecRequest);

    Autism_record addAutismRecordAll(Long childId, AutismRecRequest autismRecRequest);

    Optional<Autism_record> updateAutismRecAll(Long childId, Autism_record autism_record);

    Optional<Autism_record> getAutism_Rec_By_Id(Long medRec_Id);

    List<Autism_record> getAllAutism_Rec();

    List<Autism_record> getAutism_Rec_By_ChildId(Long ChildId);

    String deleteAutism_Rec(Long childId);

}
