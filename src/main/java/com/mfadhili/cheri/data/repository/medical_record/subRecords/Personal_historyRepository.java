package com.mfadhili.cheri.data.repository.medical_record.subRecords;

import com.mfadhili.cheri.data.domain.medical_record.Medical_record;
import com.mfadhili.cheri.data.domain.medical_record.subrecords.Personal_history;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Personal_historyRepository extends JpaRepository<Personal_history, Long> {
    @Query("select p from Personal_history p where p.medical_record = ?1")
    Personal_history findByMedical_record(Medical_record medical_record);
}