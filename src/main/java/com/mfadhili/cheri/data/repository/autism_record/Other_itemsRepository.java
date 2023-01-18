package com.mfadhili.cheri.data.repository.autism_record;

import com.mfadhili.cheri.data.domain.autism_record.Autism_record;
import com.mfadhili.cheri.data.domain.autism_record.sub_records.Other_items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Other_itemsRepository extends JpaRepository<Other_items, Long> {
    @Query("select o from Other_items o where o.autism_record = ?1")
    Other_items findByAutism_record(Autism_record autism_record);
}