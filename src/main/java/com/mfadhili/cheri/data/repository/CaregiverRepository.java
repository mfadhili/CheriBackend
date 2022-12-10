package com.mfadhili.cheri.data.repository;

import com.mfadhili.cheri.data.domain.child_caregiver.caregiver.Caregiver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CaregiverRepository extends JpaRepository<Caregiver, Long> {

    Optional<Caregiver> findById(Long Id);
}