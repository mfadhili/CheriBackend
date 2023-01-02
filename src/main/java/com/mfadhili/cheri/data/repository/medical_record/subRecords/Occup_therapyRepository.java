package com.mfadhili.cheri.data.repository.medical_record.subRecords;

import com.mfadhili.cheri.data.domain.child_caregiver.medical_record.Medical_record;
import com.mfadhili.cheri.data.domain.child_caregiver.medical_record.subrecords.Occup_therapy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Occup_therapyRepository extends JpaRepository<Occup_therapy, Long> {
    @Query("select o from Occup_therapy o where o.medical_record = ?1")
    Occup_therapy findByMedical_record(Medical_record medical_record);

}