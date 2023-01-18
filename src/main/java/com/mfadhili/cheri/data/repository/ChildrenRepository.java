package com.mfadhili.cheri.data.repository;

import com.mfadhili.cheri.data.domain.child_guardian.child.Children;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ChildrenRepository extends JpaRepository<Children, Long> {
    @Query("select c from Children c where c.id = ?1")
    Children findChildId(Long id);

}