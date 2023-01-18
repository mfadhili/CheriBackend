package com.mfadhili.cheri.data.repository;


import com.mfadhili.cheri.data.domain.autism_record.Autism_record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Autism_recordRepository extends JpaRepository<Autism_record, Long> {
}