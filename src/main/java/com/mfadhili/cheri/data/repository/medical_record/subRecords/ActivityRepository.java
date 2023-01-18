package com.mfadhili.cheri.data.repository.medical_record.subRecords;

import com.mfadhili.cheri.data.domain.medical_record.Medical_record;
import com.mfadhili.cheri.data.domain.medical_record.subrecords.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {

    @Query("select a from Activity a where a.medical_record = ?1")
    Activity findByMedical_record(Medical_record medical_record);



}