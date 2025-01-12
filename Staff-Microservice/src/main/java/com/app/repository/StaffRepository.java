package com.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.Staff;

@Repository
public interface StaffRepository extends CrudRepository<Staff, Long> {
	// Custom query methods (if needed) can be added here

}
