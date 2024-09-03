package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.Services;

@Repository
public interface ServiceRepository extends JpaRepository<Services, Long> {
	// Additional query methods (if needed) can be defined here
}
