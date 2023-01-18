package com.mfadhili.cheri.data.repository.autism_record;

import com.mfadhili.cheri.data.domain.autism_record.Autism_record;
import com.mfadhili.cheri.data.domain.autism_record.sub_records.Communication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CommunicationRepository extends JpaRepository<Communication, Long> {
    @Query("select c from Communication c where c.autism_record = ?1")
    Communication findByAutism_record(Autism_record autism_record);

}