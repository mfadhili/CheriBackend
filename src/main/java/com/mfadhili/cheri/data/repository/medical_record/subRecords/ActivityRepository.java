package com.mfadhili.cheri.data.repository.medical_record.subRecords;

import com.mfadhili.cheri.data.domain.child_caregiver.medical_record.subrecords.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
}