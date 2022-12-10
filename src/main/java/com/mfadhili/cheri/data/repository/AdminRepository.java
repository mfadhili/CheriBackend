package com.mfadhili.cheri.data.repository;

import com.mfadhili.cheri.data.domain.Admin_Home.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
}