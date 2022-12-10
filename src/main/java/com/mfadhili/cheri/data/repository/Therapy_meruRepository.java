package com.mfadhili.cheri.data.repository;

import com.mfadhili.cheri.data.domain.child_caregiver.therapy_attendance.Therapy_meru;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Therapy_meruRepository extends JpaRepository<Therapy_meru, Long> {
}