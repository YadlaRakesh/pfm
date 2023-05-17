package com.appt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.appt.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long>{
	
	@Query("select a from Admin a where a.user.username=?1")
	Admin getAdminByUsername(String username);
	
}
