package com.mfadhili.cheri.data.repository;

import com.mfadhili.cheri.data.domain.attendance.daycare_attendance.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
}