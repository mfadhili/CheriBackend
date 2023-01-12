package com.mfadhili.cheri.data.repository.medical_record.subRecords;

import com.mfadhili.cheri.data.domain.child_caregiver.medical_record.Medical_record;
import com.mfadhili.cheri.data.domain.child_caregiver.medical_record.subrecords.Summary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SummaryRepository extends JpaRepository<Summary, Long> {
    @Query("select s from Summary s where s.medical_record = ?1")
    Optional<List<Summary>> findByMedical_record(Medical_record medical_record);
    @Query("select s from Summary s where s.medical_record = ?1")
  List<Summary> findByMedical_record2(Medical_record medical_record);

}