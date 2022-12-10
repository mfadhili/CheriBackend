package com.mfadhili.cheri.data.repository;

import com.mfadhili.cheri.data.domain.child_caregiver.child.Children;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChildrenRepository extends JpaRepository<Children, Long> {
}