package com.mfadhili.cheri.data.repository.medical_record.subRecords;

import com.mfadhili.cheri.data.domain.child_caregiver.medical_record.Medical_record;
import com.mfadhili.cheri.data.domain.child_caregiver.medical_record.subrecords.Cognitive_ability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Cognitive_abilityRepository extends JpaRepository<Cognitive_ability, Long> {
    @Query("select c from Cognitive_ability c where c.medical_record = ?1")
    Cognitive_ability findByMedical_record(Medical_record medical_record);
}