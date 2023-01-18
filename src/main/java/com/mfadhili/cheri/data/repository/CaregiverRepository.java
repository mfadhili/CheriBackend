package com.mfadhili.cheri.data.repository;

import com.mfadhili.cheri.data.domain.Admin_Home.caregiver.Caregiver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CaregiverRepository extends JpaRepository<Caregiver, Long> {

    Optional<Caregiver> findById(Long Id);

    @Query("select c from Caregiver c where c.id = ?1")
    Caregiver findCaregiverId(Long id);


}