package com.mfadhili.cheri.data.repository;

import com.mfadhili.cheri.data.domain.attendance.therapy_attendance.Therapy_mikinduri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Therapy_mikinduriRepository extends JpaRepository<Therapy_mikinduri, Long> {
}