package com.mfadhili.cheri.data.repository;

import com.mfadhili.cheri.data.domain.child_guardian.guardian.Guardian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuardiansRepository extends JpaRepository<Guardian, Long> {
}