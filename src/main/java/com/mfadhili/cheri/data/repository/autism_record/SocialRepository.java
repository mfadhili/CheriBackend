package com.mfadhili.cheri.data.repository.autism_record;

import com.mfadhili.cheri.data.domain.autism_record.Autism_record;
import com.mfadhili.cheri.data.domain.autism_record.sub_records.Social;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SocialRepository extends JpaRepository<Social, Long> {
    @Query("select s from Social s where s.autism_record = ?1")
    Social findByAutism_record(Autism_record autism_record);
}