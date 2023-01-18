package com.mfadhili.cheri.data.repository.medical_record.subRecords;

import com.mfadhili.cheri.data.domain.medical_record.Medical_record;
import com.mfadhili.cheri.data.domain.medical_record.subrecords.Overview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OverviewRepository extends JpaRepository<Overview, Long> {
    @Query("select o from Overview o where o.medical_record = ?1")
    Overview findByMedical_record(Medical_record medical_record);
}