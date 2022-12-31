package com.mfadhili.cheri.data.repository.medical_record;

import com.mfadhili.cheri.data.domain.child_caregiver.child.Children;
import com.mfadhili.cheri.data.domain.child_caregiver.medical_record.Medical_record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Medical_recordRepository extends JpaRepository<Medical_record, Long> {
    /** find all records assigned to a particular child. Generated by JPA Buddy*/
    @Query("select m from Medical_record m where m.children_id = ?1")
    List<Medical_record> findByChildren_id(Children children_id);

}