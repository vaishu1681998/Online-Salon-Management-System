package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.entity.Booking;

import java.util.List;

@Repository
public interface BookingRepo extends JpaRepository<Booking, Long> {
	@Query("select b from Booking b where b.staffId = :staffId")
	List<Booking> findByStaffId(Long staffId);
}
