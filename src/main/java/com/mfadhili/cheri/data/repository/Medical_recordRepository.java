package com.mfadhili.cheri.data.repository;

import com.mfadhili.cheri.data.domain.child_caregiver.medical_record.Medical_record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Medical_recordRepository extends JpaRepository<Medical_record, Long> {
}